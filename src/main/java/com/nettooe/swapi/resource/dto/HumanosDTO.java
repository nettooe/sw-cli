package com.nettooe.swapi.resource.dto;

import java.util.ArrayList;
import java.util.List;

public class HumanosDTO {
	
	private Double pesoMedio;
	
	private List<PersonagemDTO> personagens;

	public List<PersonagemDTO> getPersonagens() {
		if(personagens == null) personagens = new ArrayList<PersonagemDTO>();
		return personagens;
	}

	public void setPersonagens(List<PersonagemDTO> personagens) {
		this.personagens = personagens;
	}

	public Double getPesoMedio() {
		return pesoMedio;
	}

	public void setPesoMedio(Double pesoMedio) {
		this.pesoMedio = pesoMedio;
	}
	
	

}
