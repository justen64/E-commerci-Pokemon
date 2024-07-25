package br.com.rocketStore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rocketStore.DTO.PedidoPokeResponseDTO;
import br.com.rocketStore.DTO.Pedido_PokemonDTO;
import br.com.rocketStore.entity.Pedido;
import br.com.rocketStore.entity.Pedido_Pokemon;
import br.com.rocketStore.entity.Pokemon;
import br.com.rocketStore.exception.ResourceNotFoundException;
import br.com.rocketStore.repository.PedidoRepository;
import br.com.rocketStore.repository.Pedido_PokemonRepository;
import br.com.rocketStore.repository.PokemonRepository;

@Service
public class Pedido_PokemonService {

	@Autowired
	private Pedido_PokemonRepository repository;

	@Autowired
	private PokemonRepository pokrepository;

	@Autowired
	private PedidoRepository pedrepository;

	public PedidoPokeResponseDTO inserirPedido(Pedido_PokemonDTO pd) {

		if (pd == null)
			throw new ResourceNotFoundException("Carrinho inválido");
		Optional<Pokemon> pokemon = pokrepository.findById(pd.getIdProduto());
		Optional<Pedido> pedido = pedrepository.findById(pd.getIdPedido());
		Pedido_Pokemon pd1 = new Pedido_Pokemon(pd, pedido.get(), pokemon.get());
		pd1.getId().setPedido(pedido.get());
		pd1.getId().setPokemon(pokemon.get());
		repository.save(pd1);
		return new PedidoPokeResponseDTO(pd1);	
	}
	
	public List<PedidoPokeResponseDTO> listaCarrinho(){
        return repository.findAll().stream().map(pok -> new PedidoPokeResponseDTO(pok)).collect(Collectors.toList());
    }
}
