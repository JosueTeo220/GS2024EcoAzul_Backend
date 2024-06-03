package com.fiap.beachsound.service;

import com.fiap.beachsound.dao.IOngDAO;
import com.fiap.beachsound.entity.Ong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// OngService.java
@Service
public class OngService {
    @Autowired
    private IOngDAO ongDAO;

    public List<Ong> getAllOngs() {
        return ongDAO.findAll();
    }

    public Ong getOngById(Long id) {
        return ongDAO.findById(id);
    }

    public void saveOng(Ong ong) {
        ongDAO.save(ong);
    }

    public void updateOng(Ong ong) {
        ongDAO.update(ong);
    }

    public void deleteOng(Long id) {
        ongDAO.delete(id);
    }
}
