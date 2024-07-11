package br.com.apeb.PeoplePlus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import br.com.apeb.PeoplePlus.model.Contato;
import br.com.apeb.PeoplePlus.model.Pessoa;
import br.com.apeb.PeoplePlus.repository.ContatoRepository;
import br.com.apeb.PeoplePlus.repository.PessoaRepository;
import br.com.apeb.PeoplePlus.service.interfaces.ContatoServiceInterface;


@Service
public class ContatoService implements ContatoServiceInterface {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

//*******************************************************************
	//CRUD de Contato
	//2a Adicionar novo contato a uma pessoa
	@Override
	public Contato save(Contato contato) {
		//buscar o pessoa no banco de dados
			Optional<Pessoa> findPessoa = pessoaRepository.
					findById(contato.getPessoaId());			
			if(!findPessoa.isEmpty()) {
				//ñ vazio
				contato.setPessoa(findPessoa.get());
				return contatoRepository.save(contato);
			}else {
				System.out.println("pessoa não encontrado id: " + 
						contato.getPessoaId());
				return null;
			}
		}
		
//*******************************************************************
	//2b Obter contato por ID
	@Override
	public Optional<Contato> findById(Long id) {
		return contatoRepository.findById(id);
	}

//*******************************************************************
	//2c Listar todos os contatos de uma pessoa
	public List<Contato> findByPessoa(Long PessoaId) {
		return contatoRepository.findByPessoa_id(PessoaId);
		}
	
//*******************************************************************
	//2d Atualizar contato por ID
	@Override
	public Contato update(Contato contato) {
		//pesquisar se o contato existe:
		Optional<Contato> findContato = contatoRepository
				.findById(contato.getId());
		
		//se o contato existir, atualizo (persisto)
		if(findContato.isPresent()) {
			//criar um novo objeto de contato  
			// e lançar os dados do objeto de parâmetro neste novo obj e gravar
			Contato updContato = findContato.get();
			//retornar o objeto gravado:
			return contatoRepository.save(updContato); //UPDATE
		}else {
			//INSERT
			return save(contato);
			}
		}
		
//*********************************************************************		
		//2e Apagar contato por ID
		@Override
		public void delete(Long id) {
			contatoRepository.deleteById(id);
	
			}
	}