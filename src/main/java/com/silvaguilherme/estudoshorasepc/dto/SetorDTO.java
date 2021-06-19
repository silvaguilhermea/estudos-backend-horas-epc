package com.silvaguilherme.estudoshorasepc.dto;

import java.util.ArrayList;
import java.util.List;

import com.silvaguilherme.estudoshorasepc.entities.Atividade;
import com.silvaguilherme.estudoshorasepc.entities.Setor;

public class SetorDTO {

	private Integer id;
	private String name;
	private String sigla;
	private List<Atividade> atividades = new ArrayList<>();
	
	public SetorDTO() {
	}

	public SetorDTO(Setor setor) {
		super();
		this.id = setor.getId();
		this.name = setor.getName();
		this.sigla = setor.getSigla();
		this.atividades = setor.getAtividades();
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}
	
}
