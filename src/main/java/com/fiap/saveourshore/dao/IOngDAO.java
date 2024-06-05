package com.fiap.saveourshore.dao;

import com.fiap.saveourshore.model.Ong;
import java.util.List;

public interface IOngDAO {
    void save(Ong ong);
    Ong findById(Long id);
    List<Ong> findAll();
    List<Ong> findAllAtuando();
    void update(Ong ong);
    void delete(Long id);
}
