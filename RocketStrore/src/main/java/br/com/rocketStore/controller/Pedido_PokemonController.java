package br.com.rocketStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rocketStore.DTO.PedidoPokeResponseDTO;
import br.com.rocketStore.DTO.Pedido_PokemonDTO;
import br.com.rocketStore.service.Pedido_PokemonService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Pedido_pokemon")
@CrossOrigin(originPatterns = "http://localhost:5173/")
public class Pedido_PokemonController {

	@Autowired
	private Pedido_PokemonService service;
	
	
	@PostMapping
	public ResponseEntity<PedidoPokeResponseDTO> inserir(@Valid @RequestBody Pedido_PokemonDTO pedido) {
		return ResponseEntity.ok(service.inserirPedido(pedido));
	}
	
	@GetMapping
    public ResponseEntity<List<PedidoPokeResponseDTO>> listaCarrinho(){
        return ResponseEntity.ok(service.listaCarrinho());
    }
}
