package com.algaworks.api.controller;

import com.algaworks.domain.exception.EntidadeEmUsoException;
import com.algaworks.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.domain.model.Cozinha;
import com.algaworks.domain.repository.CozinhaRepository;
import com.algaworks.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/cozinhas", produces = MediaType.APPLICATION_JSON_VALUE)
public class CozinhaController {

    private final CadastroCozinhaService cadastroCozinhaService;

    public CozinhaController(CadastroCozinhaService cadastroCozinhaService) {
        this.cadastroCozinhaService = cadastroCozinhaService;
    }

    @GetMapping
    public List<Cozinha> listar(){
        return cadastroCozinhaService.listarCozinhas();
    }

    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId){
       Cozinha cozinha = cadastroCozinhaService.buscarCozinhas(cozinhaId);
       if(cozinha != null){
           return ResponseEntity.ok(cozinha);
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha){
        return cadastroCozinhaService.salvar(cozinha);
    }

    @PutMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> atualizar(
            @PathVariable Long cozinhaId, @RequestBody Cozinha cozinha){
//        Cozinha cozinhaAtual = cadastroCozinhaService.buscarCozinhas(cozinhaId);

        try{
            cadastroCozinhaService.atualizarCozinha(cozinhaId, cozinha);
            return ResponseEntity.ok().body(cozinha);
        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }
//        if(cozinhaAtual != null) {
//            BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
//
//            cadastroCozinhaService.salvar(cozinhaAtual);
//            return ResponseEntity.ok().body(cozinhaAtual);
//        }
//        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId){
        try {
            cadastroCozinhaService.excluir(cozinhaId);
            return ResponseEntity.noContent().build();

        }catch (EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }
    }
}
