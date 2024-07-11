package br.com.apeb.PeoplePlus.dto;

public record PessoaSimplesDTO(
		Long id,
		String nome,
		String endereco,
		String cep,
		String cidade,
		String uf) { }