package com.fiap.beachsound.dao;

import com.fiap.beachsound.entity.Ong;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class OngDAO implements IOngDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Ong ong) {
        entityManager.persist(ong);
    }

    @Override
    public Ong findById(Long id) {
        return entityManager.find(Ong.class, id);
    }

    @Override
    public List<Ong> findAll() {
        return entityManager.createQuery("from Ong", Ong.class).getResultList();
    }

    @Override
    public List<Ong> findAllAtuando(){
        return entityManager.createQuery("from Ong where estaAtuando = true ", Ong.class).getResultList();
    }
    @Override
    public void update(Ong ong) {
        entityManager.merge(ong);
    }

    @Override
    public void delete(Long id) {
        Ong ong = findById(id);
        if (ong != null) {
            entityManager.remove(ong);
        }
    }
}
