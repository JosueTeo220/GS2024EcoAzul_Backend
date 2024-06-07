package com.fiap.saveourshore.dao;

import com.fiap.saveourshore.model.Registro;

import java.util.List;

public interface IRegistroDAO {
    void save(Registro registro);
    Registro findById(Long id);
    List<Registro> findAll();
    List<Registro> findAllWithPoluidaPraia();
    List<Registro> findTop3ByDataFinalizado();
    void update(Registro registro);
    void delete(Long id);
}