package com.silvaguilherme.estudoshorasepc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silvaguilherme.estudoshorasepc.entities.Atividade;
import com.silvaguilherme.estudoshorasepc.repositories.AtividadeRepository;

@RestController
@RequestMapping(value = "/atividades")
public class AtividadeResource {

	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@GetMapping
	public ResponseEntity<List<Atividade>> findAll() {
		List<Atividade> list = atividadeRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Atividade> findById(@PathVariable Long id) {
		Atividade obj = atividadeRepository.findById(id).get();
		return ResponseEntity.ok().body(obj);
	} 
}
