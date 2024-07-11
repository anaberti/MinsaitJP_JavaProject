package br.com.apeb.PeoplePlus.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.apeb.PeoplePlus.model.Contato;

public interface ContatoServiceInterface {
	
	Contato save(Contato contato);
	Optional<Contato> findById(Long id);
	Contato update(Contato contato);
	void delete(Long id);
	Contato delete(Contato contato);
	List<Contato> findByPessoa(Long PessoaId);
}