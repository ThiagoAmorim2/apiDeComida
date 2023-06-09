package com.algaworks.domain.repository;

import com.algaworks.domain.model.Estado;
import com.algaworks.domain.model.FormaDePagamento;

import java.util.List;

public interface EstadoRepository {

    List<Estado> listar();
    Estado buscar(Long id);
    Estado salvar(Estado estado);
    void remover(Estado estado);

}
