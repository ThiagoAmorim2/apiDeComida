package com.algaworks.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class FormaDePagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao_forma_pagamento", nullable = false)
    private String descricao;

}
