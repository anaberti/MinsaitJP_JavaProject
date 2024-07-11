package br.com.apeb.PeoplePlus.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apeb.PeoplePlus.model.Contato;
import br.com.apeb.PeoplePlus.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/contato") //http://localhost:8081/api/contato
public class ContatoResource {
	
	@Autowired
	private ContatoService contatoService; 
	
	@Operation(summary = "adiciona um novo Contato a uma Pessoa")
	@PostMapping("/contatos")
	public ResponseEntity<Contato> save(@RequestBody Contato contato){
		Contato newContato = contatoService.save(contato);
		if(newContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newContato);
	}
	//*******************************************************************
	
	@Operation(summary = "retorna os dados de um Contato por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Contato>> findById(@PathVariable Long id){
		Optional<Contato> findContato = contatoService.findById(id);
		if(findContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(findContato);
	}
	//*******************************************************************
	
	@Operation(summary = "atualiza um contato existente")
	@PutMapping("/{id}")
	public ResponseEntity<Contato> update(@RequestBody Contato Contato){
		Contato updContato = contatoService.update(Contato);
		if(updContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(updContato);
	}
	//*******************************************************************
	
	@Operation(summary = "remove um contato por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		contatoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	//*******************************************************************
	
	@Operation(summary = "lista todos os Contatos de uma Pessoa")
	@GetMapping("/pessoa/{idPessoa}")
	public ResponseEntity<Optional<Contato>>findAllById(@PathVariable Long pessoaId){
		Optional<Contato> findNumeros = contatoService.findById(pessoaId);
		if(findNumeros == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(findNumeros);
	}
		
		
}