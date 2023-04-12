package com.algaworks.domain.repository;

import com.algaworks.domain.model.Cidade;
import com.algaworks.domain.model.Cozinha;

import java.util.List;

public interface CidadeRepository {

	List<Cidade> listar();
	Cidade buscar(Long id);
	Cidade salvar(Cidade cidade);
	void remover(Cidade cidade);
	
}
