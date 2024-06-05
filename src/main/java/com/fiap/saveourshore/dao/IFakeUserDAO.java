package com.fiap.saveourshore.dao;

import com.fiap.saveourshore.model.FakeUser;

public interface IFakeUserDAO {
    void save(FakeUser fakeUser);
    FakeUser findByNome(String nome);
}