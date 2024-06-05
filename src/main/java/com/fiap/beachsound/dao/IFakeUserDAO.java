package com.fiap.beachsound.dao;

import com.fiap.beachsound.entity.FakeUser;

public interface IFakeUserDAO {
    void save(FakeUser fakeUser);
    FakeUser findByNome(String nome);
}