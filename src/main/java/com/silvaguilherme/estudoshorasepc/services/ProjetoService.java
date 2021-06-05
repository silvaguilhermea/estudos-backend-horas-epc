package com.silvaguilherme.estudoshorasepc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.silvaguilherme.estudoshorasepc.entities.Projeto;
import com.silvaguilherme.estudoshorasepc.repositories.ProjetoRepository;
import com.silvaguilherme.estudoshorasepc.services.exceptions.DataIntegrityException;
import com.silvaguilherme.estudoshorasepc.services.exceptions.ObjectNotFoundException;


@Service
public class ProjetoService {
	
	@Autowired
	public ProjetoRepository repo;
	
	public Projeto insert(Projeto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Projeto update(Projeto obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		buscar(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um projeto que possuí atividades");
		}
	}
	
	public Projeto buscar(Integer id) {
		Optional<Projeto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Projeto.class.getName()));
	}
	
	public List<Projeto> buscarTudo() {
		List<Projeto> Projetos = repo.findAll();
		return Projetos;
	}

}