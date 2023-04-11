package com.algaworks.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.AlgafoodApiApplication;
import com.algaworks.domain.model.Cozinha;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(
				AlgafoodApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		
		CadastroCozinha cadastroCozinha =  applicationContext.getBean(CadastroCozinha.class);
		
		List<Cozinha> cozinhas = cadastroCozinha.listar();
		
		for (Cozinha cozinha: cozinhas) {
			System.out.println(cozinha.getNome());
		}
	}
}
