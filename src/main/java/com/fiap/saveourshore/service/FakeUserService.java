package com.fiap.saveourshore.service;

import com.fiap.saveourshore.dao.IFakeUserDAO;
import com.fiap.saveourshore.model.FakeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FakeUserService {

    @Autowired
    private IFakeUserDAO fakeUserDAO;

    public void save(FakeUser fakeUser) {
        fakeUserDAO.save(fakeUser);
    }

    public FakeUser findByNome(String nome) {
        return fakeUserDAO.findByNome(nome);
    }
}
