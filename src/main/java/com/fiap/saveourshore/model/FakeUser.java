package com.fiap.saveourshore.model;


import jakarta.persistence.*;

@Entity
@Table(name = "fakeuser")
public class FakeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String fakepassword;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFakepassword() {
        return fakepassword;
    }

    public void setFakepassword(String fakepassword) {
        this.fakepassword = fakepassword;
    }
}
