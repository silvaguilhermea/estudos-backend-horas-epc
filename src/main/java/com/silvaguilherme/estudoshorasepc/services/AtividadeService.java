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

import com.silvaguilherme.estudoshorasepc.dto.AtividadeDTO;
import com.silvaguilherme.estudoshorasepc.entities.Atividade;
import com.silvaguilherme.estudoshorasepc.repositories.AtividadeRepository;
import com.silvaguilherme.estudoshorasepc.services.exceptions.DataIntegrityException;
import com.silvaguilherme.estudoshorasepc.services.exceptions.ObjectNotFoundException;


@Service
public class AtividadeService {
	
	@Autowired
	public AtividadeRepository repo;
	
	public Atividade insert(Atividade obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Atividade update(Atividade obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		buscar(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir a atividade");
		}
	}
	
	public Atividade buscar(Integer id) {
		Optional<Atividade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Atividade.class.getName()));
	}
	
	public List<Atividade> buscarTudo() {
		List<Atividade> Atividades = repo.findAll();
		return Atividades;
	}
	
	public List<AtividadeDTO> converteDTO(List<Atividade> atividades) {
		List<AtividadeDTO> listDto = atividades.stream().map(obj -> new AtividadeDTO(obj)).collect(Collectors.toList());
		return listDto;
	}
	
	public Page<Atividade> buscarPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
	}

}
