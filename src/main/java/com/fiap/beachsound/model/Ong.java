package com.fiap.beachsound.model;


import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import javax.validation.constraints.NotBlank;


@Entity
public class Ong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome não pode estar em branco")

    private String nome;
    private String areaAtuacao;

    private boolean estaAtuando;
    public Ong() {}

    public Ong(Long id, String nome, String areaAtuacao, boolean estaAtuando) {
        this.id = id;
        this.nome = nome;
        this.areaAtuacao = areaAtuacao;
        this.estaAtuando = estaAtuando;
    }

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

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public boolean isEstaAtuando() {
        return estaAtuando;
    }

    public void setEstaAtuando(boolean estaAtuando) {
        this.estaAtuando = estaAtuando;
    }
}
