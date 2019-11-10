package com.nettooe.swapi.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.nettooe.swapi.repository.response.SpeciesResponse;
import com.nettooe.swapi.repository.response.FilmsResponse;
import com.nettooe.swapi.repository.response.PagePersonResponse;
import com.nettooe.swapi.repository.response.PersonResponse;

@Component
public class SwApiRepository {

	String SwApiBasePath = "https://swapi.co/api/";

	@Autowired
	private RestTemplate restTemplate;

	@Cacheable(value = "personagens")
	public ArrayList<PersonResponse> listarPersonagens() {

		final HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		headers.add("Host", "swapi.co");
		headers.add("Accept-Encoding", "text/html; charset=utf-8");
		headers.add("Connection", "keep-alive");
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		ArrayList<PersonResponse> persons = new ArrayList<>();
		ResponseEntity<PagePersonResponse> response = null;

		Integer page = 1;

		do {
			final UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(SwApiBasePath).pathSegment("people")
					.queryParam("page", page.toString());

			response = this.restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET,
					new HttpEntity<>(headers), PagePersonResponse.class);

			persons.addAll(response.getBody().getResults());

			page++;

		} while (response.getBody().getNext() != null);

		return persons;
	}

	@Cacheable(value = "personagem", key = "#idPersonagem")
	public PersonResponse obterPersonagemPorId(final String idPersonagem) {

		final HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		headers.add("Host", "swapi.co");
		headers.add("Accept-Encoding", "text/html; charset=utf-8");
		headers.add("Connection", "keep-alive");
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		final UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(SwApiBasePath).pathSegment("people",
				idPersonagem);

		final ResponseEntity<PersonResponse> response = this.restTemplate.exchange(builder.build().encode().toUri(),
				HttpMethod.GET, new HttpEntity<>(headers), PersonResponse.class);

		PersonResponse person = response.getBody();
		return person;
	}

	@Cacheable(value = "filmeByUrl", key = "#url")
	public FilmsResponse obterFilmePorUrl(final String url) {

		final HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		headers.add("Host", "swapi.co");
		headers.add("Accept-Encoding", "text/html; charset=utf-8");
		headers.add("Connection", "keep-alive");
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		final ResponseEntity<FilmsResponse> response = this.restTemplate.exchange(url, HttpMethod.GET,
				new HttpEntity<>(headers), FilmsResponse.class);

		return response.getBody();
	}

	@Cacheable(value = "especieHumana")
	public SpeciesResponse obterEspecieHumana() {

		final HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		headers.add("Host", "swapi.co");
		headers.add("Accept-Encoding", "text/html; charset=utf-8");
		headers.add("Connection", "keep-alive");
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		final ResponseEntity<SpeciesResponse> response = this.restTemplate.exchange(
				"https://swapi.co/api/species/1", HttpMethod.GET, new HttpEntity<>(headers),
				SpeciesResponse.class);

		return response.getBody();
	}

	@Cacheable(value = "personagemByUri", key = "#uri")
	public PersonResponse obterPersonagemPorUri(final String uri) {

		final HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		headers.add("Host", "swapi.co");
		headers.add("Accept-Encoding", "text/html; charset=utf-8");
		headers.add("Connection", "keep-alive");
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		final ResponseEntity<PersonResponse> response = this.restTemplate.exchange(uri, HttpMethod.GET,
				new HttpEntity<>(headers), PersonResponse.class);

		return response.getBody();
	}

}
