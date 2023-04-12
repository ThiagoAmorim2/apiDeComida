package com.algaworks.domain.repository;

import com.algaworks.domain.model.Cozinha;
import com.algaworks.domain.model.FormaDePagamento;
import org.springframework.stereotype.Component;

import java.util.List;

public interface FormaDePagamentoRepository {

    List<FormaDePagamento> listar();
    FormaDePagamento buscar(Long id);
    FormaDePagamento salvar(FormaDePagamento formaDePagamento);
    void remover(FormaDePagamento formaDePagamento);

}
