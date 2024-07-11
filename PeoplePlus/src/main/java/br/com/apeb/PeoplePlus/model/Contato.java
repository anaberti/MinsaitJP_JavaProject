package br.com.apeb.PeoplePlus.model;

import java.util.ArrayList;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Contato")
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Integer tipoContato;
	
	@Column(nullable = false)
	private String numero;
	
	@ManyToOne
	@JoinColumn(name = "PessoaId", referencedColumnName = "id") //nome do campo // referencia do campo da tabela Pessoa (id)
	private Pessoa pessoaId;
	
			
	// -------------------------------
	public Contato() {}
	public Contato(Long id, Integer tipoContato, Pessoa pessoa, String numero, Pessoa pessoaId) {
		this.id = id;
		this.tipoContato = tipoContato;
		this.numero = numero;
		this.pessoaId = pessoaId;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getTipoContato() {
		return tipoContato;
	}
	
	public void setTipoContato(Integer tipoContato) {
		this.tipoContato = tipoContato;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
		
	public Pessoa getPessoaId() {
		return pessoaId;
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
		Contato other = (Contato) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "[id = " + this.id + ", " +
				"tipo de contato = " + this.tipoContato +
				"número = " + this.numero +
				"id da pessoa = " + this.pessoaId +
				"]";
	}


}