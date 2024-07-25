package br.com.rocketStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rocketStore.DTO.EnderecoDTO;
import br.com.rocketStore.entity.Endereco;
import br.com.rocketStore.exception.CepException;
import br.com.rocketStore.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	public EnderecoDTO buscarPorCep(String cep) {
		Optional<Endereco> verifica = Optional.ofNullable(repository.findByCep(cep));
		if (verifica.isPresent()) {
			return new EnderecoDTO(verifica.get());
		} else {
			throw new CepException("Nenhum endereço cadastrado nesse Cep foi encontrado!");
		}
	}

	public EnderecoDTO inserir(Endereco endereco) {
		return new EnderecoDTO(repository.save(endereco));
	}

	public List<Endereco> TodosEnderecos() {
		return repository.findAll();
	}

}
