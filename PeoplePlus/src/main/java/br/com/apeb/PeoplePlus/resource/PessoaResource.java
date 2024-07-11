package br.com.apeb.PeoplePlus.resource;

import java.util.List;
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

import br.com.apeb.PeoplePlus.dto.PessoaDTO;
import br.com.apeb.PeoplePlus.model.Pessoa;
import br.com.apeb.PeoplePlus.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;



@RestController
@RequestMapping("/api/pessoas") //http://localhost:8081/api/Pessoas
public class PessoaResource {

	@Autowired
	PessoaService PessoaService;
		
	@Operation(summary = "lista todas as Pessoas")
	@GetMapping("/pessoas")
	public ResponseEntity<List<Pessoa>> findAllPessoas(){
		List<Pessoa> Pessoas = PessoaService.findAll();
		if(Pessoas == null) {
			return ResponseEntity.notFound().build();
		}
		if(Pessoas.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(Pessoas);
	}
//*******************************************************************
	
	@Operation(summary = "retorna os dados de uma Pessoa por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> findById1(@PathVariable Long id){
		Optional<Pessoa> Pessoa = PessoaService.findById(id);
		if(Pessoa.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(Pessoa);
	}
//*******************************************************************
	
	@Operation(summary = "cria uma nova Pessoa")
	@PostMapping ("/pessoas")
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa Pessoa){
		Pessoa newPessoa = PessoaService.save(Pessoa);
		if(newPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newPessoa);
	}
//*******************************************************************
	
	@Operation(summary = "atualiza uma Pessoa existente")
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa Pessoa){
		Pessoa updPessoa = PessoaService.update(Pessoa);
		if(updPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(updPessoa);
	}
//*******************************************************************
	
	@Operation(summary = "remove uma Pessoa por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		PessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);} //status code 204

//*******************************************************************

@Operation(summary = "retorna os dados de uma Pessoa por ID para mala direta")
@GetMapping("maladireta/{id}")
public ResponseEntity<List<PessoaDTO>> findPessoa(){
	List<PessoaDTO> pessoaDtos = PessoaService.findPessoa();
	if(pessoaDtos == null) {
		return ResponseEntity.notFound().build();
	}
	if(pessoaDtos.size() == 0) {
		return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(pessoaDtos);
}
}


