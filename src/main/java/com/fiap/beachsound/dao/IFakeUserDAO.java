package com.fiap.beachsound.dao;

import com.fiap.beachsound.model.FakeUser;

public interface IFakeUserDAO {
    void save(FakeUser fakeUser);
    FakeUser findByNome(String nome);
}