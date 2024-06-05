package com.fiap.beachsound.service;
import com.fiap.beachsound.dao.IPraiaDAO;
import com.fiap.beachsound.model.Praia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PraiaService {
    @Autowired
    private IPraiaDAO praiaDAO;

    public List<Praia> getAllPraias() {
        return praiaDAO.findAll();
    }

    public Praia getPraiaById(Long id) {
        return praiaDAO.findById(id);
    }
    
    public List<Praia> getPraiaPoluida(){
        return praiaDAO.findAllPoluidas();
    }

    public void savePraia(Praia praia) {
        praiaDAO.save(praia);
    }

    public void updatePraia(Praia praia) {
        praiaDAO.update(praia);
    }

    public void deletePraia(Long id) {
        praiaDAO.delete(id);
    }

    public void markPraiaAsPoluida(Long id) {
        Praia praia = getPraiaById(id);
        if (praia != null) {
            praia.setPoluida(true);
            praiaDAO.update(praia);
        }
    }
    public void markPraiaAsLimpa(Long id) {
        Praia praia = getPraiaById(id);
        if (praia != null) {
            praia.setPoluida(false);
            praiaDAO.update(praia);
        }
    }
}
