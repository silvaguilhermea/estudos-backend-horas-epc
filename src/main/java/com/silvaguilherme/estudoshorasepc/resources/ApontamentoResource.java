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

import com.silvaguilherme.estudoshorasepc.dto.ApontamentoDTO;
import com.silvaguilherme.estudoshorasepc.entities.Apontamento;
import com.silvaguilherme.estudoshorasepc.services.ApontamentoService;

@RestController
@RequestMapping(value = "/apontamentos")
public class ApontamentoResource {

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

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ApontamentoDTO>> buscarTudo() {
		List<ApontamentoDTO> obj = service.converteDTO(service.buscarTudo());
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/responsavel/{attribute}", method = RequestMethod.GET)
	public ResponseEntity<List<ApontamentoDTO>> buscarPorUsuario(@PathVariable String attribute) {
		List<ApontamentoDTO> obj = service.converteDTO(service.buscarPorUsuario(attribute));
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/page",method = RequestMethod.GET)
	public ResponseEntity<Page<ApontamentoDTO>> buscarPage(
			@RequestParam(value = "page", defaultValue="0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue="24")Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue="dataInicial")String orderBy, 
			@RequestParam(value = "direction", defaultValue="ASC")String direction) {
		Page<Apontamento> listPage = service.buscarPage(page,linesPerPage,orderBy,direction);
		Page<ApontamentoDTO> listPageDto = listPage.map(obj -> new ApontamentoDTO(obj));
		return ResponseEntity.ok().body(listPageDto);
	}
	
}