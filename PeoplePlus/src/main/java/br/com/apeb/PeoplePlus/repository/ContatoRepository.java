package br.com.apeb.PeoplePlus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apeb.PeoplePlus.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	public List<Contato>findByPessoa_id(Long pessoa_id);
}