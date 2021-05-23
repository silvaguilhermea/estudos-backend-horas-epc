package com.silvaguilherme.estudoshorasepc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silvaguilherme.estudoshorasepc.entities.Estado;
import com.silvaguilherme.estudoshorasepc.repositories.EstadoRepository;

@RestController
@RequestMapping(value = "/estados")
public class UsuarioResource {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping
	public ResponseEntity<List<Estado>> findAll() {
		List<Estado> list = estadoRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Estado> findById(@PathVariable Long id) {
		Estado e = estadoRepository.findById(id).get();
		return ResponseEntity.ok().body(e);
	} 
}