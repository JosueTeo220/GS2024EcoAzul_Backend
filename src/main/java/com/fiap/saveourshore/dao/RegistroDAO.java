package com.fiap.saveourshore.dao;

import com.fiap.saveourshore.model.Registro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class RegistroDAO implements IRegistroDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Registro registro) {
        entityManager.persist(registro);
    }

    @Override
    public Registro findById(Long id) {
        return entityManager.find(Registro.class, id);
    }

    @Override
    public List<Registro> findAll() {
        return  entityManager.createQuery("from Registro", Registro.class).getResultList();
    }
    @Override
    public void update(Registro registro) {
        entityManager.merge(registro);
    }

    @Override
    public void delete(Long id) {
        Registro registro = entityManager.find(Registro.class, id);
        if (registro != null) {
            entityManager.remove(registro);
        }
    }
}
