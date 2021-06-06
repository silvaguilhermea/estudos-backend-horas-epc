
package com.silvaguilherme.estudoshorasepc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
public class Atividade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "setor_id")
	@NotNull
	private Setor setor;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@NotNull
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "estado_id")
	@NotNull
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(name = "projeto_id")
	@NotNull
	private Projeto projeto;
	
	public Atividade() {
	}

	public Atividade(Integer id, String name, Projeto projeto, Setor setor, Estado estado, Usuario usuario) {
		super();
		this.id = id;
		this.name = name;
		this.projeto = projeto;
		this.setor = setor;
		this.estado = estado;
		this.usuario = usuario;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
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
		Atividade other = (Atividade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
