package br.com.rocketStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rocketStore.DTO.PokemonResponseDTO;
import br.com.rocketStore.service.PokemonService;


@RestController
@RequestMapping("/pokemon")
@CrossOrigin(originPatterns = "*")
public class PokemonController {
	
	@Autowired
	private PokemonService service;
	
	@PostMapping
	public ResponseEntity<List<PokemonResponseDTO>> inserir() throws Exception{
		return ResponseEntity.ok(service.inserir());
	}

	@GetMapping()
	public List<PokemonResponseDTO> listar() {
		return service.listarPokemon();
	}
	@GetMapping("/listar")
	public ResponseEntity<List<PokemonResponseDTO>> listarPorPagina(@PageableDefault (sort ="id",size = 30 )Pageable page ){
		return new ResponseEntity<>(service.listarPagina(page), HttpStatus.OK);

	}	
}
