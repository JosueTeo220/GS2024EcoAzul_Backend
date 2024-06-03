package com.fiap.beachsound.dao;

import com.fiap.beachsound.entity.Ong;
import java.util.List;

public interface IOngDAO {
    void save(Ong ong);
    Ong findById(Long id);
    List<Ong> findAll();
    void update(Ong ong);
    void delete(Long id);
}
