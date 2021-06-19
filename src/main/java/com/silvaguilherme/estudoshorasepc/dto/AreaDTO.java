package com.silvaguilherme.estudoshorasepc.dto;

import java.util.ArrayList;
import java.util.List;

import com.silvaguilherme.estudoshorasepc.entities.Area;
import com.silvaguilherme.estudoshorasepc.entities.Projeto;

public class AreaDTO {
	
	private Integer id;
	private String name;
	private String descricao;
	private List<Projeto> projetos = new ArrayList<>();
	
	public AreaDTO(){
	}
	
	public AreaDTO(Area area) {
		this.id = area.getId();
		this.name = area.getName();
		this.descricao = area.getDescricao();
		this.projetos = area.getProjetos();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

}
