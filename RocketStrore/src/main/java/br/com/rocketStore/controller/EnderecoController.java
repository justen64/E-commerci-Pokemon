package br.com.rocketStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rocketStore.DTO.EnderecoDTO;
import br.com.rocketStore.entity.Endereco;
import br.com.rocketStore.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
@CrossOrigin(originPatterns = "http://localhost:5173/")
public class EnderecoController {

	@Autowired
	private EnderecoService service;

	@PostMapping
	public ResponseEntity<EnderecoDTO> inserirCep(@RequestBody Endereco endereco) {
		EnderecoDTO dto = service.buscarPorCep(endereco.getCep());
		if (dto == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(dto);
		}
	}

	@GetMapping("{cep}")
	public ResponseEntity<EnderecoDTO> buscarCep(@PathVariable String cep) {
		EnderecoDTO dto = service.buscarPorCep(cep);
		if (dto == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(dto);
		}
	}

	@GetMapping()
	public List<Endereco> buscarEnderecos() {
		return service.TodosEnderecos();
	}

}
