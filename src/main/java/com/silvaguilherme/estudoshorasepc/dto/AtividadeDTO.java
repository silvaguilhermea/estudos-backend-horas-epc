package com.silvaguilherme.estudoshorasepc.dto;

import com.silvaguilherme.estudoshorasepc.entities.Atividade;
import com.silvaguilherme.estudoshorasepc.entities.Estado;
import com.silvaguilherme.estudoshorasepc.entities.Projeto;
import com.silvaguilherme.estudoshorasepc.entities.Setor;
import com.silvaguilherme.estudoshorasepc.entities.Usuario;

public class AtividadeDTO {
	
	private Integer id;
	private String name;
	private Setor setor;
	private Usuario usuario;
	private Estado estado;
	private Projeto projeto;
	
	public AtividadeDTO() {
	}

	public AtividadeDTO(Atividade atividade) {
		super();
		this.id = atividade.getId();
		this.name = atividade.getName();
		this.setor = atividade.getSetor();
		this.usuario = atividade.getUsuario();
		this.estado = atividade.getEstado();
		this.projeto = atividade.getProjeto();
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

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	

}
