package com.silvaguilherme.estudoshorasepc.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.silvaguilherme.estudoshorasepc.entities.Apontamento;
import com.silvaguilherme.estudoshorasepc.services.ApontamentoService;

@RestController
@RequestMapping(value = "/apontamentos")
public class ApontamentoResource {
/*
	@Autowired
	private ApontamentoRepository ApontamentoRepository;
	
	@GetMapping
	public ResponseEntity<List<Apontamento>> findAll() {
		List<Apontamento> list = ApontamentoRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Apontamento> findById(@PathVariable Long id) {
		Apontamento set= ApontamentoRepository.findById(id).get();
		return ResponseEntity.ok().body(set);
	} 
	*/
	@Autowired /* instância objetos automaticamente */
	public ApontamentoService service;

	/* Método Inserir */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Apontamento obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/* Método Atualizar */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Apontamento obj,@PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	/* Método Deletar */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		 service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/* método GET para tratar as requisições  */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Apontamento obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	/* FAZER COM O DTO */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Apontamento>> buscarTudo() {
		List<Apontamento> obj = service.buscarTudo();
		return ResponseEntity.ok().body(obj);
	}
}