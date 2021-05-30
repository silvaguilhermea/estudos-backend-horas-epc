package com.silvaguilherme.estudoshorasepc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silvaguilherme.estudoshorasepc.entities.Area;
import com.silvaguilherme.estudoshorasepc.entities.Projeto;
import com.silvaguilherme.estudoshorasepc.repositories.ProjetoRepository;

@RestController
@RequestMapping(value = "/projetos")
public class ProjetoResource {
	
	private List<Projeto> list;

	@Autowired
	private ProjetoRepository projetoRepository;
	
	@GetMapping
	public ResponseEntity<List<Projeto>> findAll() {
		List<Projeto> list = projetoRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Projeto> findById(@PathVariable Long id) {
		Projeto obj = projetoRepository.findById(id).get();
		return ResponseEntity.ok().body(obj);
	}
	
}
