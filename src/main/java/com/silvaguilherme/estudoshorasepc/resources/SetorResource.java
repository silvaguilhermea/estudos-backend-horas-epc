package com.silvaguilherme.estudoshorasepc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silvaguilherme.estudoshorasepc.entities.Setor;
import com.silvaguilherme.estudoshorasepc.repositories.SetorRepository;

@RestController
@RequestMapping(value = "/setores")
public class SetorResource {

	@Autowired
	private SetorRepository setorRepository;
	
	@GetMapping
	public ResponseEntity<List<Setor>> findAll() {
		List<Setor> list = setorRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Setor> findById(@PathVariable Long id) {
		Setor set= setorRepository.findById(id).get();
		return ResponseEntity.ok().body(set);
	} 
}