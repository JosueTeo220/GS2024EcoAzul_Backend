package com.fiap.saveourshore.service;

import com.fiap.saveourshore.dao.IOngDAO;
import com.fiap.saveourshore.dao.IRegistroDAO;
import com.fiap.saveourshore.dao.OngDAO;
import com.fiap.saveourshore.model.Ong;
import com.fiap.saveourshore.model.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroService {

    @Autowired
    private IRegistroDAO registroDAO;
    @Autowired
    private IOngDAO ongDAO;

    @Transactional
    public void save(Registro registro) {
        registroDAO.save(registro);
    }

    @Transactional(readOnly = true)
    public Registro findById(Long id) {
        return registroDAO.findById(id);
    }
    @Transactional
    public List<Registro> getAllRegistros() {
        return  registroDAO.findAll();
    }

    @Transactional
    public void update(Registro registro) {
        registroDAO.update(registro);
    }

    @Transactional
    public void delete(Long id) {
        registroDAO.delete(id);
    }
    @Transactional
    public void assignOngToRegistro(Long registroId, Long ongId) {
        Optional<Registro> registroOptional = Optional.ofNullable(registroDAO.findById(registroId));
        Optional<Ong> ongOptional = Optional.ofNullable(ongDAO.findById(ongId));

        if (registroOptional.isPresent() && ongOptional.isPresent()) {
            Registro registro = registroOptional.get();
            Ong ong = ongOptional.get();
            registro.setOng(ong);
            if(!ong.isEstaAtuando()){
                ong.setEstaAtuando(true);
            }
            registroDAO.save(registro);
        } else {
            throw new IllegalArgumentException("Registro or ONG not found");
        }

    }
    @Transactional
    public void updateStatusPendente(Long registroId, boolean statusPendente) {
        Optional<Registro> registroOptional = Optional.ofNullable(registroDAO.findById(registroId));
        if (registroOptional.isPresent()) {
            Registro registro = registroOptional.get();
            if(registro.isStatusPendente()){
                registro.setDataFinalizado(LocalDate.from(LocalDateTime.now()));
            }
            registro.setStatusPendente(statusPendente);
            registroDAO.save(registro);
        } else {
            throw new IllegalArgumentException("Registro not found");
        }
    }
    @Transactional
    public List<Registro> getAllRegistrosWithPoluidaPraia() {
        return registroDAO.findAllWithPoluidaPraia();
    }
    @Transactional
    public List<Registro> getTop3ByDataFinalizado() {
        return registroDAO.findTop3ByDataFinalizado();
    }

}
