package br.com.apeb.PeoplePlus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apeb.PeoplePlus.dto.PessoaDTO;
import br.com.apeb.PeoplePlus.dto.PessoaSimplesDTO;
import br.com.apeb.PeoplePlus.model.Pessoa;
import br.com.apeb.PeoplePlus.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	//CRUD de Pessoas 
	//1a Criar Pessoa
	public Pessoa save(Pessoa pessoa) {
		if (pessoa.getCpf() != null) {
			System.out.println("Pessoa já cadastrada.");
			return null;
		}
		if (pessoa.getCpf() == null) {
				if(pessoa.getNome() == null) {
					System.out.println("Nome da pessoa está vazio.");
					return null;
				}
				if(pessoa.getEndereco() == null) {
					System.out.println("Endereço da pessoa está vazio");
					return null;
				}	
				if(pessoa.getCpf() == null) {
					System.out.println("CPF da pessoa está vazio");
					return null;
				}	
				//gravar:
				try {
					return pessoaRepository.save(pessoa); //vai para o banco de dados "INSERT"
				}catch(Exception e) {
					System.out.println("ERR: Erro ao inserir pessoa " + 
					pessoa.toString() + ": " + e.getMessage());
					return null;
				}
		}
		return pessoa;
	}

//*******************************************************************
	
	//1b Encontrar pessoa por ID
	public Optional<Pessoa> findById(Long id) {
		return pessoaRepository.findById(id); //select * from pessoa where id = ?
	}
//*******************************************************************
	
	//1c Obter pessoa por ID para Mala Direta
	public List<PessoaDTO> findPessoa(){
		
		List<Object[]> listResult = pessoaRepository.findPessoa();
		List<PessoaDTO> listPessoaDTO = new ArrayList<PessoaDTO>();
		
		for(Object[] obj : listResult) {
			PessoaDTO pDTO = returnBDPessoaDTO(obj);
			listPessoaDTO.add(pDTO);
		}
		
		return listPessoaDTO;
	}
	
	private PessoaDTO returnBDPessoaDTO(Object[] resultado) {
		PessoaDTO pessoaDTO = new PessoaDTO();
		if(resultado != null) {
			pessoaDTO.setId(((Long)resultado[0]).longValue()   );
			pessoaDTO.setNome((String)resultado[1]);
			pessoaDTO.setCpf((String)resultado[2]);
			pessoaDTO.setEndereco((String)resultado[3]);
			pessoaDTO.setCidade((String)resultado[4]);
			pessoaDTO.setUf((String)resultado[5]);
			pessoaDTO.setCep((String)resultado[6]);
		}
		return pessoaDTO;
	}
	

//*******************************************************************
	
	//1d Listar todas as pessoas
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll(); //select * from pessoa
	}
//*******************************************************************
	
	//1e Atualizar pessoa por ID
	public Pessoa update(Pessoa pessoa) {
		//pesquisar se o pessoa existe
		Optional<Pessoa> findPessoa = pessoaRepository.findById(pessoa.getId());
		
		//se o pessoa existir, atualizo:
		if(findPessoa.isPresent()) {
			//criar um novo objeto do pessoa  
			// e lançar os dados do objeto de parâmetro neste novo obj e grava
			Pessoa updPessoa = findPessoa.get(); //setId
			updPessoa.setNome(pessoa.getNome());
			updPessoa.setEndereco(pessoa.getEndereco());
			updPessoa.setCep(pessoa.getCep());
			updPessoa.setCidade(pessoa.getCidade());
			updPessoa.setUf(pessoa.getUf());
			//retornar o objeto gravado
			return pessoaRepository.save(updPessoa); //"UPDATE"
		}		
		//retornar o objeto gravado
		return pessoaRepository.save(pessoa);  //"INSERT"
	}
//*******************************************************************	
	//1f Deletar pessoa por ID
	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}
//*******************************************************************

}