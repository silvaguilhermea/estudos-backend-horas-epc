package com.silvaguilherme.estudoshorasepc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silvaguilherme.estudoshorasepc.entities.Area;
import com.silvaguilherme.estudoshorasepc.repositories.AreaRepository;

@RestController
@RequestMapping(value = "/areas")
public class AreaResource {

	@Autowired
	private AreaRepository areaRepository;
	
	@GetMapping
	public ResponseEntity<List<Area>> findAll() {
		List<Area> list = areaRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Area> findById(@PathVariable Long id) {
		Area ar = areaRepository.findById(id).get();
		return ResponseEntity.ok().body(ar);
	} 
}