package com.fiap.saveourshore.dao;

import java.util.List;
import com.fiap.saveourshore.model.Praia;
public interface IPraiaDAO {
    void save(Praia praia);
    Praia findById(Long id);
    List<Praia> findAll();
    long count();
    List<Praia> findAllPoluidas();
    void update(Praia praia);
    void delete(Long id);
}

