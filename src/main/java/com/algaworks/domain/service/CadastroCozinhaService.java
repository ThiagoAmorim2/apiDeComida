package com.algaworks.domain.service;

import com.algaworks.domain.exception.EntidadeEmUsoException;
import com.algaworks.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.domain.model.Cozinha;
import com.algaworks.domain.repository.CozinhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CadastroCozinhaService {

    private final CozinhaRepository cozinhaRepository;

    public CadastroCozinhaService(CozinhaRepository cozinhaRepository) {
        this.cozinhaRepository = cozinhaRepository;
    }

    public List<Cozinha> listarCozinhas(){
        return cozinhaRepository.listar();
    }

    public Cozinha buscarCozinhas(@PathVariable Long id){
        Cozinha cozinha = cozinhaRepository.buscar(id);

        if(cozinha != null){
            return cozinha;
        }
        throw new EntidadeNaoEncontradaException(
                String.format("Não existe cadastro de cozinha com o código %d", id)
        );
    }
    public Cozinha salvar(Cozinha cozinha){
        return cozinhaRepository.salvar(cozinha);
    }

    public Cozinha atualizarCozinha(Long id, Cozinha cozinha){
        Cozinha cozinhaAtual = cozinhaRepository.buscar(id);
        if(cozinhaAtual != null) {
            BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
            return cozinhaRepository.salvar(cozinhaAtual);
        }
        throw new EntidadeNaoEncontradaException(
                String.format("Não existe cadastro de cozinha com o código %d", id)
        );
    }

    public void excluir(Long cozinhaId){
        try{
            cozinhaRepository.remover(cozinhaId);
        }catch(EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cozinha com o código %d", cozinhaId)
            );
        }catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                    String.format("Cozinha de código %d não pode ser removida, pois está em uso", cozinhaId)
            );
        }
    }
}
