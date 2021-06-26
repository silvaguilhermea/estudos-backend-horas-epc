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

import com.silvaguilherme.estudoshorasepc.dto.EstadoDTO;
import com.silvaguilherme.estudoshorasepc.entities.Estado;
import com.silvaguilherme.estudoshorasepc.repositories.EstadoRepository;
import com.silvaguilherme.estudoshorasepc.services.exceptions.DataIntegrityException;
import com.silvaguilherme.estudoshorasepc.services.exceptions.ObjectNotFoundException;


@Service
public class EstadoService {
	
	@Autowired
	public EstadoRepository repo;
	
	public Estado insert(Estado obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Estado update(Estado obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		buscar(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um estado utilizado em atividades");
		}
	}
	
	public Estado buscar(Integer id) {
		Optional<Estado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
	}
	
	public List<Estado> buscarTudo() {
		//List<Estado> Estados = repo.findByName("Finalizado");
		List<Estado> Estados = repo.findSort();
		return Estados;
	}
	
	public List<EstadoDTO> converteDTO(List<Estado> estados) {
		List<EstadoDTO> listDto = estados.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return listDto;
	}
	
	public Page<Estado> buscarPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
	}

}
