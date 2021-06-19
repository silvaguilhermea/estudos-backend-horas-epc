package com.silvaguilherme.estudoshorasepc.dto;

import java.util.ArrayList;
import java.util.List;

import com.silvaguilherme.estudoshorasepc.entities.Atividade;
import com.silvaguilherme.estudoshorasepc.entities.Usuario;

public class UsuarioDTO {

	private Integer id;
	private String name;
	private String user;
	private String email;
	private String password;
	private List<Atividade> atividades = new ArrayList<>();
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.name = usuario.getName();
		this.user = usuario.getUser();
		this.email = usuario.getEmail();
		this.password = usuario.getPassword();
		this.atividades = usuario.getAtividades();
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

}
