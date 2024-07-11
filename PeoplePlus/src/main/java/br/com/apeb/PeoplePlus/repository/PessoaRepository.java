package br.com.apeb.PeoplePlus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apeb.PeoplePlus.model.Pessoa;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	Optional<Pessoa> findByCpf(String cpf);

	Optional<Pessoa> getPessoa();

	List<Object[]> findPessoa();

	Optional<Pessoa> findByPessoaId(Pessoa pessoaId);
}