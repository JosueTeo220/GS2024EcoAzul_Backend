package com.fiap.saveourshore.dao;

import com.fiap.saveourshore.model.Registro;

import java.util.List;

public interface IRegistroDAO {
    void save(Registro registro);
    Registro findById(Long id);
    List<Registro> findAll();
    void update(Registro registro);
    void delete(Long id);
}