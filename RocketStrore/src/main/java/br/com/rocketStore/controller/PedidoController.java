package br.com.rocketStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rocketStore.DTO.PedidoResponseDTO;
import br.com.rocketStore.DTO.PedidoRequestDTO;
import br.com.rocketStore.enuns.StatusENUM;
import br.com.rocketStore.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(originPatterns = "http://localhost:5173/")
public class PedidoController {

	@Autowired
	public PedidoService service;
	
	@GetMapping
	public List<PedidoResponseDTO> listar(){
		return service.listar();
	}
	
	@GetMapping("{page}")
	public PedidoResponseDTO listarPorPagina (@PathVariable Pageable pageable) {
		return (PedidoResponseDTO) service.listarPorPagina(pageable);
	}
	
	@PostMapping
	public ResponseEntity<PedidoResponseDTO> inserir(@RequestBody PedidoRequestDTO pedido) {
		PedidoResponseDTO p = service.inserir(pedido);
		return ResponseEntity.created(null).body(p);
	}
	
	@PutMapping("/status/{id}")
 public ResponseEntity<PedidoResponseDTO> alterarStatus(@PathVariable Long id, @RequestBody StatusENUM status) {
	    PedidoResponseDTO StatusAtualizado = service.alterarStatus(id, status);
        return ResponseEntity.ok(StatusAtualizado);
	}
	
}
