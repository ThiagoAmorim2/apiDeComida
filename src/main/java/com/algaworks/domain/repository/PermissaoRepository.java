package com.algaworks.domain.repository;

import com.algaworks.domain.model.FormaDePagamento;
import com.algaworks.domain.model.Permissao;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> listar();
    Permissao buscar(Long id);
    Permissao salvar(Permissao permissao);
    void remover(Permissao permissao);

}
