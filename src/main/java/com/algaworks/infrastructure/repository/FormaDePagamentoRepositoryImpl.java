package com.algaworks.infrastructure.repository;

import com.algaworks.domain.model.Cozinha;
import com.algaworks.domain.model.FormaDePagamento;
import com.algaworks.domain.repository.FormaDePagamentoRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class FormaDePagamentoRepositoryImpl implements FormaDePagamentoRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<FormaDePagamento> listar() {
        return manager.createQuery("from FormaDePagamento", FormaDePagamento.class)
                .getResultList();
    }

    @Override
    public FormaDePagamento buscar(Long id) {
        return manager.find(FormaDePagamento.class, id);
    }

    @Transactional
    @Override
    public FormaDePagamento salvar(FormaDePagamento formaDePagamento) {
        return manager.merge(formaDePagamento);
    }

    @Transactional
    @Override
    public void remover(FormaDePagamento formaDePagamento) {
        formaDePagamento = buscar(formaDePagamento.getId());
        manager.remove(formaDePagamento);
    }
}
