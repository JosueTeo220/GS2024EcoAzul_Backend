package com.fiap.beachsound.model;


import jakarta.persistence.*;


import java.util.Date;

@Entity
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nomePessoa;


    private String cpf;


    private boolean statusPendente;


    private String descricao;

    private Date dataReport;
    private Date dataFinalizado;

    @OneToOne
    private Praia praia;
    @OneToOne
    private Ong ong;




    public Registro(Long id, String nomePessoa, String cpf, boolean statusPendente, String descricao, Date dataReport, Date dataFinalizado, Praia praia, Ong ong) {
        this.id = id;
        this.nomePessoa = nomePessoa;
        this.cpf = cpf;
        this.statusPendente = statusPendente;
        this.descricao = descricao;
        this.dataReport = dataReport;
        this.dataFinalizado = dataFinalizado;
        this.praia = praia;
        this.ong = ong;
    }

    public Registro() {

    }

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

    public Date getDataReport() {
        return dataReport;
    }

    public void setDataReport(Date dataReport) {
        this.dataReport = dataReport;
    }

    public Date getDataFinalizado() {
        return dataFinalizado;
    }

    public void setDataFinalizado(Date dataFinalizado) {
        this.dataFinalizado = dataFinalizado;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public boolean isValid() {
        if (nomePessoa == null || nomePessoa.isEmpty() || cpf == null || cpf.isEmpty() || cpf.matches("([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})\n")) {
            return false;
        }
        return true;
    }
}

