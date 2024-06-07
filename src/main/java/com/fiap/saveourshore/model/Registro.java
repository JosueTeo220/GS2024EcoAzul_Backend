package com.fiap.saveourshore.model;


import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomePessoa;
    private String cpf;
    private LocalDate dataReport;
    private LocalDate dataFinalizado;
    private boolean statusPendente;
    private String descricao;

    @OneToOne
    @JoinColumn(name = "praia_id")
    private Praia praia;

    @OneToOne
    @JoinColumn(name = "ong_id", nullable = true)
    private Ong ong;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataReport() {
        return dataReport;
    }

    public void setDataReport(LocalDate dataReport) {
        this.dataReport = dataReport;
    }

    public LocalDate getDataFinalizado() {
        return dataFinalizado;
    }

    public void setDataFinalizado(LocalDate dataFinalizado) {
        this.dataFinalizado = dataFinalizado;
    }

    public boolean isStatusPendente() {
        return statusPendente;
    }

    public void setStatusPendente(boolean statusPendente) {
        this.statusPendente = statusPendente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Praia getPraia() {
        return praia;
    }

    public void setPraia(Praia praia) {
        this.praia = praia;
    }

    public Ong getOng() {
        return ong;
    }

    public void setOng(Ong ong) {
        this.ong = ong;
    }

    public boolean isValid() {
        return nomePessoa != null && !nomePessoa.isEmpty() && cpf != null && !cpf.isEmpty() && !cpf.matches("([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})\n");
    }
}

