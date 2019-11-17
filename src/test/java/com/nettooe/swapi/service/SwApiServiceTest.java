package com.nettooe.swapi.service;

import java.util.List;

import org.flywaydb.test.FlywayTestExecutionListener;
import org.flywaydb.test.annotation.FlywayTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nettooe.swapi.resource.dto.HumanosDTO;
import com.nettooe.swapi.resource.dto.PersonagemDTO;
import com.nettooe.swapi.service.SwApiService;

@SpringBootTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, FlywayTestExecutionListener.class })
@FlywayTest(locationsForMigrate = { "db/migration", "db/testdata" })
public class SwApiServiceTest extends AbstractTestNGSpringContextTests {

	@Autowired
	SwApiService swApiService;

	// caso queira um 'reset' no banco de dados, basta descomentar a linha abaixo
//	@FlywayTest(locationsForMigrate = { "db/migration", "db/testdata" })
	@Test(description = "Este teste valida a funcionalidade que consulta todos os personagens no serviço StarWars API.")
	void test_listarPersonagens() {
		List<PersonagemDTO> listarPersonagens = swApiService.listarPersonagens();

		Assert.assertNotNull(listarPersonagens);
		Assert.assertTrue(listarPersonagens.size() > 0);
	}

	@Test(description = "Este teste valida a funcionalidade que consulta todos os personagens da espécie humana e calcula a massa média.")
	void test_listarHumanosEpesoMedio() {
		HumanosDTO humanosEpesoMedio = swApiService.listarHumanosEpesoMedio();

		Assert.assertNotNull(humanosEpesoMedio);
		Assert.assertNotNull(humanosEpesoMedio.getPesoMedio());
		Assert.assertNotNull(humanosEpesoMedio.getPersonagens());
		Assert.assertFalse(humanosEpesoMedio.getPersonagens().isEmpty());
	}

	@Test(description = "Este teste valida a funcionalidade que consulta um personagem pelo ID = 1.")
	void test_obterPersonagemPorId() {

		PersonagemDTO obterPersonagemPorId = swApiService.obterPersonagemPorId(1);

		Assert.assertNotNull(obterPersonagemPorId);
		Assert.assertNotNull(obterPersonagemPorId.getNome());

	}

	@Test(description = "Este teste valida a funcionalidade que consulta um personagem pelo ID = 2.")
	void test_obterPersonagemPorId_02() {

		PersonagemDTO obterPersonagemPorId = swApiService.obterPersonagemPorId(2);

		Assert.assertNotNull(obterPersonagemPorId);
		Assert.assertNotNull(obterPersonagemPorId.getNome());

	}

}
