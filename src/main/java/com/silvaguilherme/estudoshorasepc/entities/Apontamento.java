package com.silvaguilherme.estudoshorasepc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Apontamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String area;
	
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String projeto;
	
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String setor;
	
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String atividade;
	
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String responsavel;
	
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String dataInicial;
	
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String dataFinal;
	
	private String comentario;	
	
	public Apontamento() {
	}

	public Apontamento(Integer id, String area, String projeto, String setor, String atividade, String responsavel, String dataInicial, String dataFinal, String comentario) {
		super();
		this.id = id;
		this.area = area;
		this.projeto = projeto;
		this.setor = setor;
		this.atividade = atividade;
		this.responsavel = responsavel;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.comentario = comentario;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apontamento other = (Apontamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
