package com.fiap.saveourshore.dao;

import com.fiap.saveourshore.model.Praia;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PraiaDAO implements IPraiaDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Praia praia) {
        entityManager.persist(praia);
    }

    @Override
    public Praia findById(Long id) {
        return entityManager.find(Praia.class, id);
    }

    @Override
    public List<Praia> findAll() {
        return entityManager.createQuery("from Praia", Praia.class).getResultList();
    }
    @Override
    public List<Praia> findAllPoluidas() {
        return entityManager.createQuery("from Praia where poluida = true ", Praia.class).getResultList();
    }
    @Override
    public long count() {
        return entityManager.createQuery("SELECT COUNT(p) FROM Praia p", Long.class).getSingleResult();
    }
    @Override
    public void update(Praia praia) {
        entityManager.merge(praia);
    }

    @Override
    public void delete(Long id) {
        Praia praia = findById(id);
        if (praia != null) {
            entityManager.remove(praia);
        }
    }
}