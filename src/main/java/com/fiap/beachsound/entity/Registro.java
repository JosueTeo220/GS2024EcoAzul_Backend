package com.fiap.beachsound.entity;


import jakarta.persistence.*;

import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 30)
    private String nomePessoa;

    private Date dataReport;
    private Date dataFinalizado;

    @OneToOne
    private Praia praia;
    @OneToOne
    private Ong ong;
}
