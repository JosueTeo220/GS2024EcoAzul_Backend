package com.fiap.saveourshore.dao;

import com.fiap.saveourshore.model.FakeUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class FakeUserDAO implements IFakeUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(FakeUser fakeUser) {
        entityManager.persist(fakeUser);
    }

    @Override
    public FakeUser findByNome(String nome) {
        TypedQuery<FakeUser> query = entityManager.createQuery("SELECT f FROM FakeUser f WHERE f.nome = :nome", FakeUser.class);
        query.setParameter("nome", nome);
        return query.getResultList().stream().findFirst().orElse(null);
    }
}