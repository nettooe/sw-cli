package com.nettooe.swapi.repository.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonResponse {
	private String name;
	private String height;
	private String mass;
	private String hairColor;
	private String skinColor;
	private String eyeColor;
	private String birthYear;
	private String gender;
	private String homeworld;
	private List<String> films;
	private List<String> species;
	private List<String> vehicles;
	private List<String> starships;
	private String created;
	private String edited;
	private String url;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String value) {
		this.name = value;
	}

	@JsonProperty("height")
	public String getHeight() {
		return height;
	}

	@JsonProperty("height")
	public void setHeight(String value) {
		this.height = value;
	}

	@JsonProperty("mass")
	public String getMass() {
		return mass;
	}

	@JsonProperty("mass")
	public void setMass(String value) {
		this.mass = value;
	}

	@JsonProperty("hair_color")
	public String getHairColor() {
		return hairColor;
	}

	@JsonProperty("hair_color")
	public void setHairColor(String value) {
		this.hairColor = value;
	}

	@JsonProperty("skin_color")
	public String getSkinColor() {
		return skinColor;
	}

	@JsonProperty("skin_color")
	public void setSkinColor(String value) {
		this.skinColor = value;
	}

	@JsonProperty("eye_color")
	public String getEyeColor() {
		return eyeColor;
	}

	@JsonProperty("eye_color")
	public void setEyeColor(String value) {
		this.eyeColor = value;
	}

	@JsonProperty("birth_year")
	public String getBirthYear() {
		return birthYear;
	}

	@JsonProperty("birth_year")
	public void setBirthYear(String value) {
		this.birthYear = value;
	}

	@JsonProperty("gender")
	public String getGender() {
		return gender;
	}

	@JsonProperty("gender")
	public void setGender(String value) {
		this.gender = value;
	}

	@JsonProperty("homeworld")
	public String getHomeworld() {
		return homeworld;
	}

	@JsonProperty("homeworld")
	public void setHomeworld(String value) {
		this.homeworld = value;
	}

	@JsonProperty("films")
	public List<String> getFilms() {
		return films;
	}

	@JsonProperty("films")
	public void setFilms(List<String> value) {
		this.films = value;
	}

	@JsonProperty("species")
	public List<String> getSpecies() {
		return species;
	}

	@JsonProperty("species")
	public void setSpecies(List<String> value) {
		this.species = value;
	}

	@JsonProperty("vehicles")
	public List<String> getVehicles() {
		return vehicles;
	}

	@JsonProperty("vehicles")
	public void setVehicles(List<String> value) {
		this.vehicles = value;
	}

	@JsonProperty("starships")
	public List<String> getStarships() {
		return starships;
	}

	@JsonProperty("starships")
	public void setStarships(List<String> value) {
		this.starships = value;
	}

	@JsonProperty("created")
	public String getCreated() {
		return created;
	}

	@JsonProperty("created")
	public void setCreated(String value) {
		this.created = value;
	}

	@JsonProperty("edited")
	public String getEdited() {
		return edited;
	}

	@JsonProperty("edited")
	public void setEdited(String value) {
		this.edited = value;
	}

	@JsonProperty("url")
	public String getURL() {
		return url;
	}

	@JsonProperty("url")
	public void setURL(String value) {
		this.url = value;
	}

	public int getFilmSize() {
		if (films == null)
			return 0;
		return films.size();
	}

}
