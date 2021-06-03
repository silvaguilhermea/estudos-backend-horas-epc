package com.silvaguilherme.estudoshorasepc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.silvaguilherme.estudoshorasepc.entities.Area;
import com.silvaguilherme.estudoshorasepc.repositories.AreaRepository;
import com.silvaguilherme.estudoshorasepc.services.exceptions.DataIntegrityException;
import com.silvaguilherme.estudoshorasepc.services.exceptions.ObjectNotFoundException;


@Service
public class AreaService {
	
	@Autowired
	public AreaRepository repo;
	
	public Area insert(Area obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Area update(Area obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		buscar(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma área que possuí projetos");
		}
	}
	
	public Area buscar(Integer id) {
		Optional<Area> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Area.class.getName()));
	}
	
	public List<Area> buscarTudo() {
		List<Area> areas = repo.findAll();
		return areas;
	}

}
