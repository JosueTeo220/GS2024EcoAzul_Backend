package com.fiap.beachsound.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class Praia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String estado;

    private String cidade;
    private boolean poluida;

    public Praia() {}

    public Long getId() {
        return id;
    }

    public Praia(Long id, String nome, String estado, String cidade, boolean poluida) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.cidade = cidade;
        this.poluida = poluida;
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


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public boolean isPoluida() {
        return poluida;
    }

    public void setPoluida(boolean poluida) {
        this.poluida = poluida;
    }
}