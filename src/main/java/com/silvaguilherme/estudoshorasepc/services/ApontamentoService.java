package com.silvaguilherme.estudoshorasepc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.silvaguilherme.estudoshorasepc.entities.Apontamento;
import com.silvaguilherme.estudoshorasepc.repositories.ApontamentoRepository;
import com.silvaguilherme.estudoshorasepc.services.exceptions.DataIntegrityException;
import com.silvaguilherme.estudoshorasepc.services.exceptions.ObjectNotFoundException;


@Service
public class ApontamentoService {
	
	@Autowired
	public ApontamentoRepository repo;
	
	public Apontamento insert(Apontamento obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Apontamento update(Apontamento obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		buscar(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir o apontamento");
		}
	}
	
	public Apontamento buscar(Integer id) {
		Optional<Apontamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Apontamento.class.getName()));
	}
	
	public List<Apontamento> buscarTudo() {
		List<Apontamento> Apontamentos = repo.findAll();
		return Apontamentos;
	}

}
