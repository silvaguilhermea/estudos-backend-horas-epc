package com.silvaguilherme.estudoshorasepc.dto;

import java.util.ArrayList;
import java.util.List;

import com.silvaguilherme.estudoshorasepc.entities.Area;
import com.silvaguilherme.estudoshorasepc.entities.Atividade;
import com.silvaguilherme.estudoshorasepc.entities.Projeto;

public class ProjetoDTO {
	
	private Integer id;
	private String name;
	private String dataInicial;
	private String dataFinal;
	private Area area;
	private List<Atividade> atividades = new ArrayList<>();
	
	public ProjetoDTO() {
	}
	
	public ProjetoDTO(Projeto projeto) {
		this.id = projeto.getId();
		this.name = projeto.getName();
		this.dataInicial = projeto.getDataInicial();
		this.dataFinal = projeto.getDataFinal();
		this.area = projeto.getArea();
		this.atividades = projeto.getAtividades();
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
	public String getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}
	public String getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public List<Atividade> getAtividades() {
		return atividades;
	}

}
