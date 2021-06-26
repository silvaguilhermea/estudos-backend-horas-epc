package com.silvaguilherme.estudoshorasepc.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.silvaguilherme.estudoshorasepc.dto.EstadoDTO;
import com.silvaguilherme.estudoshorasepc.entities.Estado;
import com.silvaguilherme.estudoshorasepc.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

	@Autowired /* instância objetos automaticamente */
	public EstadoService service;

	/* Método Inserir */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Estado obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/* Método Atualizar */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Estado obj,@PathVariable Integer id) {
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
		Estado obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> buscarTudo() {
		List<EstadoDTO> obj = service.converteDTO(service.buscarTudo());
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/page",method = RequestMethod.GET)
	public ResponseEntity<Page<EstadoDTO>> buscarPage(
			@RequestParam(value = "page", defaultValue="0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue="24")Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue="name")String orderBy, 
			@RequestParam(value = "direction", defaultValue="ASC")String direction) {
		Page<Estado> listPage = service.buscarPage(page,linesPerPage,orderBy,direction);
		Page<EstadoDTO> listPageDto = listPage.map(obj -> new EstadoDTO(obj));
		return ResponseEntity.ok().body(listPageDto);
	}
	
}