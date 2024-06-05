package com.fiap.beachsound.dao;

import com.fiap.beachsound.model.Registro;

import java.util.List;

public interface IRegistroDAO {
    void save(Registro registro);
    Registro findById(Long id);
    List<Registro> findAll();
    void update(Registro registro);
    void delete(Long id);
}