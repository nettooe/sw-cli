package com.nettooe.swapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nettooe.swapi.resource.dto.HumanosDTO;
import com.nettooe.swapi.resource.dto.PersonagemDTO;
import com.nettooe.swapi.service.SwApiService;

@RestController
@RequestMapping("/personagens")
public class PersonagensResource {

	@Autowired
	private SwApiService swApiService;

//	@Autowired
//	private ApplicationEventPublisher publisher;

	@GetMapping
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public List<PersonagemDTO> listar() {
		return swApiService.listarPersonagens();
	}

	@GetMapping("/{idPersonagem}")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public PersonagemDTO obterPorId(@PathVariable("idPersonagem") Integer idPersonagem) {
		return swApiService.obterPersonagemPorId(idPersonagem);
	}

	@GetMapping("/humanos")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public HumanosDTO listarHumanosEpesoMedio() {
		return swApiService.listarHumanosEpesoMedio();
	}

}
