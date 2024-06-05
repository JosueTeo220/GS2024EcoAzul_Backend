package com.fiap.saveourshore.service;

import com.fiap.saveourshore.dao.IRegistroDAO;
import com.fiap.saveourshore.model.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegistroService {

    @Autowired
    private IRegistroDAO registroDAO;

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
}
