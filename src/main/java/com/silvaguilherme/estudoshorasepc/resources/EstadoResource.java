package com.silvaguilherme.estudoshorasepc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silvaguilherme.estudoshorasepc.entities.Usuario;
import com.silvaguilherme.estudoshorasepc.repositories.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuarios")
public class EstadoResource {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> list = usuarioRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		Usuario u = usuarioRepository.findById(id).get();
		return ResponseEntity.ok().body(u);
	} 
}