package br.com.rocketStore.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rocketStore.DTO.PedidoRequestDTO;
import br.com.rocketStore.DTO.PedidoResponseDTO;
import br.com.rocketStore.DTO.ProdutoQuantidadeDTO;
import br.com.rocketStore.entity.Cliente;
import br.com.rocketStore.entity.Pedido;
import br.com.rocketStore.entity.Pedido_Pokemon;
import br.com.rocketStore.entity.Pokemon;
import br.com.rocketStore.enuns.StatusENUM;
import br.com.rocketStore.exception.ClienteException;
import br.com.rocketStore.exception.ResourceNotFoundException;
import br.com.rocketStore.repository.ClienteRepository;
import br.com.rocketStore.repository.PedidoRepository;
import br.com.rocketStore.repository.PokemonRepository;
import jakarta.transaction.Transactional;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	@Autowired
	private PokemonService pokemonService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PokemonRepository pokeRepository;

	public List<PedidoResponseDTO> listar() {
		List<Pedido> pedidos = repository.findAll();
		return pedidos.stream().map((c) -> new PedidoResponseDTO(c)).collect(Collectors.toList());
	}

	public Page<Pedido> listarPorPagina(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Transactional
	public PedidoResponseDTO inserir(PedidoRequestDTO pedido) {

		Pedido f = new Pedido();
		Optional<Cliente> cliente = clienteRepository.findById(pedido.getIdCliente());
		if (cliente.get() != null) {
			f.setCliente(cliente.get());
			f.setDataPedido(pedido.getDataPedido());
			f.setStatus(pedido.getStatus());
			repository.save(f);

			Set<Pedido_Pokemon> pokemons = new HashSet<>();

			for (ProdutoQuantidadeDTO pokemon : pedido.getProdutos()) {
				Optional<Pokemon> pokemon1= pokeRepository.findById(pokemon.getIdPokemon());
				pokemons.add(new Pedido_Pokemon(f, pokemon1.get(), LocalDate.now(),pokemon.getQuantidade()));
			}
			f.setProdutos(pokemons);
			repository.save(f);
			PedidoResponseDTO response = new PedidoResponseDTO(f);
			return response;
		} else {
			throw new ClienteException("Cliente apresentado não encontrado!");
		}
	}

	public PedidoResponseDTO alterarStatus(Long id, StatusENUM status) {

		Pedido c = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Lancamento não encontrado"));
		c.setId(id);
		c.setStatus(status);
		repository.save(c);
		return new PedidoResponseDTO(c);
	}
}
