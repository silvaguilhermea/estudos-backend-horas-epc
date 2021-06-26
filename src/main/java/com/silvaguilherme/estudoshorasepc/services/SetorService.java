package com.silvaguilherme.estudoshorasepc.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.silvaguilherme.estudoshorasepc.dto.SetorDTO;
import com.silvaguilherme.estudoshorasepc.entities.Setor;
import com.silvaguilherme.estudoshorasepc.repositories.SetorRepository;
import com.silvaguilherme.estudoshorasepc.services.exceptions.DataIntegrityException;
import com.silvaguilherme.estudoshorasepc.services.exceptions.ObjectNotFoundException;


@Service
public class SetorService {
	
	@Autowired
	public SetorRepository repo;
	
	public Setor insert(Setor obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Setor update(Setor obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		buscar(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Setor responsável por atividades");
		}
	}
	
	public Setor buscar(Integer id) {
		Optional<Setor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Setor.class.getName()));
	}
	
	public List<Setor> buscarTudo() {
		List<Setor> Setors = repo.findSort();
		return Setors;
	}
	
	public List<SetorDTO> converteDTO(List<Setor> setores) {
		List<SetorDTO> listDto = setores.stream().map(obj -> new SetorDTO(obj)).collect(Collectors.toList());
		return listDto;
	}
	
	public Page<Setor> buscarPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
	}

}
