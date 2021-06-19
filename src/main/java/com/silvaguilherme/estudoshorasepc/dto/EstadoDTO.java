package com.silvaguilherme.estudoshorasepc.dto;

import java.util.ArrayList;
import java.util.List;

import com.silvaguilherme.estudoshorasepc.entities.Atividade;
import com.silvaguilherme.estudoshorasepc.entities.Estado;

public class EstadoDTO {

	private Integer id;
	private String name;
	private List<Atividade> atividades = new ArrayList<>();
	
	public EstadoDTO() {
	}

	public EstadoDTO(Estado estado) {
		this.id = estado.getId();
		this.name = estado.getName();
		this.atividades = estado.getAtividades();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

}
