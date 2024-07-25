package br.com.rocketStore.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.rocketStore.DTO.Pedido_PokemonDTO;
import br.com.rocketStore.pk.Pedido_PokemonPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Pedido_Pokemon {

	@EmbeddedId
	private Pedido_PokemonPK id = new Pedido_PokemonPK();
	private LocalDateTime dataCriacao;

	private Integer quantidade;
	private Double subtotal;
	
	
	public Pedido_Pokemon() {
		super();
	}

	public Pedido_Pokemon(Pedido_PokemonDTO pd, Pedido pedido, Pokemon pokemon) {
		super();
		this.id.setPedido(pedido);
		this.id.setPokemon(pokemon);
		this.dataCriacao = pokemon.getDataCadastro();
		this.quantidade = pd.getQuantidade();
	}

	public Pedido_Pokemon(Pedido f, Pokemon pokemon, LocalDate now,Integer quantidade) {
		this.id.setPedido(f);
		this.id.setPokemon(pokemon);
		this.dataCriacao = LocalDateTime.now();
		this.quantidade = quantidade;
		this.subtotal = pokemon.getValorUnitario()*quantidade;
	}

	public Pedido_PokemonPK getid() {
		return id;
	}

	public Pedido_PokemonPK getId() {
		return id;
	}

	public void setId(Pedido_PokemonPK id) {
		this.id = id;
	}

	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	
}
