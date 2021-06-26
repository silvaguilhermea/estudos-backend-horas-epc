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

import com.silvaguilherme.estudoshorasepc.dto.SetorDTO;
import com.silvaguilherme.estudoshorasepc.entities.Setor;
import com.silvaguilherme.estudoshorasepc.services.SetorService;

@RestController
@RequestMapping(value = "/setores")
public class SetorResource {

	@Autowired /* instância objetos automaticamente */
	public SetorService service;

	/* Método Inserir */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Setor obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/* Método Atualizar */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Setor obj,@PathVariable Integer id) {
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
		Setor obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SetorDTO>> buscarTudo() {
		List<SetorDTO> obj = service.converteDTO(service.buscarTudo());
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/page",method = RequestMethod.GET)
	public ResponseEntity<Page<SetorDTO>> buscarPage(
			@RequestParam(value = "page", defaultValue="0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue="24")Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue="name")String orderBy, 
			@RequestParam(value = "direction", defaultValue="ASC")String direction) {
		Page<Setor> listPage = service.buscarPage(page,linesPerPage,orderBy,direction);
		Page<SetorDTO> listPageDto = listPage.map(obj -> new SetorDTO(obj));
		return ResponseEntity.ok().body(listPageDto);
	}
	
}