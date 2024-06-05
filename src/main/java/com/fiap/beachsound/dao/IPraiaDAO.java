package com.fiap.beachsound.dao;

import java.util.List;
import com.fiap.beachsound.entity.Praia;
public interface IPraiaDAO {
    void save(Praia praia);
    Praia findById(Long id);
    List<Praia> findAll();

    List<Praia> findAllPoluidas();
    void update(Praia praia);
    void delete(Long id);
}

