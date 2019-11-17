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

import com.nettooe.swapi.model.User;

@SpringBootTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, FlywayTestExecutionListener.class })
@FlywayTest(locationsForMigrate = { "db/migration", "db/testdata" })
public class UserServiceTest extends AbstractTestNGSpringContextTests {

	@Autowired
	UserService userService;

	@Test(description = "Este teste valida a funcionalidade que consulta todos os Usuários e perfis salvos no banco de dados.")
	public void findAllTest() {
		
		List<User> all = userService.findAll();
		
		Assert.assertNotNull(all);
		Assert.assertEquals(all.size(), 2);
		
	}
}
