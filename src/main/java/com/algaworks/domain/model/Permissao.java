package com.algaworks.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_permissao", nullable = false)
    private String nome;

    @Column(name = "descricao_permissao", nullable = false)
    private String descricao;
}
