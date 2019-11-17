package com.nettooe.swapi.resource.dto;

import java.util.ArrayList;
import java.util.List;

public class PersonagemDTO {

	private String uri;
	private String nome;
	private String anoNascimento;
	private Double massa;
	private List<String> filmes;
	
	
	public Double getMassa() {
		if(massa == null) massa = 0D;
		return massa;
	}

	public void setMassa(Double massa) {
		this.massa = massa;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(String anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public List<String> getFilmes() {

		if (filmes == null)
			filmes = new ArrayList<String>();

		return filmes;
	}

	public void setFilmes(List<String> filmes) {
		this.filmes = filmes;
	}

	@Override
	public String toString() {
		return "PersonagemDTO [uri=" + uri + ", nome=" + nome + ", anoNascimento=" + anoNascimento + ", massa=" + massa
				+ ", filmes=" + filmes + "]";
	}

	
}
