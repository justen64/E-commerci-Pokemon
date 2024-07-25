package br.com.rocketStore.pk;

import br.com.rocketStore.entity.Pedido;
import br.com.rocketStore.entity.Pokemon;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Pedido_PokemonPK {

	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "id_pokemon")
	private Pokemon pokemon;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

}
