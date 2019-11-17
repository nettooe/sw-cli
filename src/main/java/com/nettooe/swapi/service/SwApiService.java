package com.nettooe.swapi.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nettooe.swapi.repository.SwApiRepository;
import com.nettooe.swapi.repository.response.PersonResponse;
import com.nettooe.swapi.repository.response.SpeciesResponse;
import com.nettooe.swapi.resource.dto.HumanosDTO;
import com.nettooe.swapi.resource.dto.PersonagemDTO;

@Service
public class SwApiService {

	@Autowired
	SwApiRepository apiRepository;

	public List<PersonagemDTO> listarPersonagens() {

		List<PersonResponse> persons = apiRepository.listarPersonagens();

		List<PersonagemDTO> personagemDTOs = new ArrayList<PersonagemDTO>(persons.size());

		persons = persons.stream().sorted(
				Comparator.comparing(PersonResponse::getFilmSize).reversed().thenComparing(PersonResponse::getName))
				.collect(Collectors.toList());

		persons.stream().forEach(person -> {
			PersonagemDTO personagemDTO = convertPersonToPersonagemDto(person);

			personagemDTOs.add(personagemDTO);

		});

		return personagemDTOs;
	}

	public PersonagemDTO obterPersonagemPorId(Integer idPersonagem) {
		PersonResponse person = apiRepository.obterPersonagemPorId(idPersonagem.toString());

		PersonagemDTO personagemDTO = convertPersonToPersonagemDto(person);

		return personagemDTO;
	}

	private PersonagemDTO convertPersonToPersonagemDto(PersonResponse person) {
		PersonagemDTO personagemDTO = new PersonagemDTO();
		personagemDTO
				.setUri(person.getURL().replace("https://swapi.co/api/people/", "http://localhost:8080/personagens/"));
		personagemDTO.setNome(person.getName());
		personagemDTO.setAnoNascimento(person.getBirthYear());

		personagemDTO.setMassa(person.getMass() == null ? null : convertMass(person.getMass()));

		person.getFilms().stream().forEach(f -> {
			personagemDTO.getFilmes().add(apiRepository.obterFilmePorUrl(f).getTitle());
		});
		return personagemDTO;
	}

	private Double convertMass(String mass) {
		if (mass.contains("unknown"))
			return null;

		if (mass.contains(",")) {
			mass = mass.replace(",", ".");
		}

		return Double.valueOf(mass);
	}

	public HumanosDTO listarHumanosEpesoMedio() {

		SpeciesResponse especieHumana = apiRepository.obterEspecieHumana();

		HumanosDTO humanosDTO = new HumanosDTO();

		especieHumana.getPeople().parallelStream().forEach(h -> {
			humanosDTO.getPersonagens().add(convertPersonToPersonagemDto(apiRepository.obterPersonagemPorUri(h)));
		});

		DoubleSummaryStatistics estatisticas = humanosDTO.getPersonagens().stream()
				.collect(Collectors.summarizingDouble(PersonagemDTO::getMassa));

		humanosDTO.setPesoMedio(estatisticas.getAverage());

		return humanosDTO;
	}

}
