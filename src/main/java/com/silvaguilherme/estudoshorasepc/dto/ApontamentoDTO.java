package com.silvaguilherme.estudoshorasepc.dto;

import com.silvaguilherme.estudoshorasepc.entities.Apontamento;

public class ApontamentoDTO {
	
	private Integer id;
	private String area;
	private String projeto;
	private String setor;
	private String atividade;
	private String responsavel;
	private String dataInicial;
	private String dataFinal;
	private String comentario;
	
	public ApontamentoDTO() {
	}
	
	public ApontamentoDTO(Apontamento apontamento) {
		super();
		this.id = apontamento.getId();
		this.area = apontamento.getArea();
		this.projeto = apontamento.getProjeto();
		this.setor = apontamento.getSetor();
		this.atividade = apontamento.getAtividade();
		this.responsavel = apontamento.getResponsavel();
		this.dataInicial = apontamento.getDataInicial();
		this.dataFinal = apontamento.getDataFinal();
		this.comentario = apontamento.getComentario();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	

}
