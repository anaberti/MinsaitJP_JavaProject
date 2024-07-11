package br.com.apeb.PeoplePlus.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false)
	private String cep;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	private String uf;
	
	@OneToMany(mappedBy = "pessoa_id")
	private List<Contato> contatos;
	
	// -----------------------------------------
	public Pessoa() {}

	public Pessoa(Long id, String nome, String endereco, String cep, String cidade, String uf, String cpf) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.nome = cpf;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "[Id: " 				+ this.id 		+ ", " 		+ 
				"Nome: " 			+ this.nome 	+ ", "		+
				"CPF: "				+ this.cpf		+ ", "		+
				"Endereço: " 		+ this.endereco + " - "		+ 
									this.cep		+" - " 		+ 
									this.cidade 	+"/" 		+ 
									this.uf 		+  "]";
	}

	public String getPessoa(Long id) {
		return "[Id: " 				+ this.id 		+ ", " 		+ 
				"Nome: " 			+ this.nome 	+ ", "		+
				"CPF: "				+ this.cpf		+ ", "		+
				"Endereço: " 		+ this.endereco + " - "		+ 
									this.cep		+" - " 		+ 
									this.cidade 	+"/" 		+ 
									this.uf 		+  "]";
	}


}