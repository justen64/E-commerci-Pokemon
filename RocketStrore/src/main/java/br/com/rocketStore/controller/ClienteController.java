package br.com.rocketStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rocketStore.DTO.ClienteRequestDTO;
import br.com.rocketStore.DTO.ClienteResponseDTO;
import br.com.rocketStore.DTO.LoginDTO;
import br.com.rocketStore.entity.Cliente;
import br.com.rocketStore.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(originPatterns = "http://localhost:5173/")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping
	public List<ClienteResponseDTO> listar() {
		return service.listar();
	}

	@GetMapping("{page}")
	public ClienteResponseDTO listarPorPagina(@PathVariable Pageable pageable) {
		return (ClienteResponseDTO) service.listarPorPagina(pageable);
	}

	@PostMapping
	public ResponseEntity<ClienteResponseDTO> inserir(@Valid @RequestBody ClienteRequestDTO cliente) {
		return ResponseEntity.ok(service.inserir(cliente));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteResponseDTO> alterarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		ClienteResponseDTO clienteAtualizado = service.alterarCliente(id, cliente);
		return ResponseEntity.ok(clienteAtualizado);
	}
	@PostMapping("/login")
	public ResponseEntity<ClienteResponseDTO> login(@Valid @RequestBody LoginDTO login){
		return new ResponseEntity<>(service.login(login), HttpStatus.OK);
	}
}
