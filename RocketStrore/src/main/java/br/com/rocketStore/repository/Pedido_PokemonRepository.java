package br.com.rocketStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rocketStore.entity.Pedido_Pokemon;
import br.com.rocketStore.pk.Pedido_PokemonPK;

public interface Pedido_PokemonRepository extends JpaRepository<Pedido_Pokemon, Pedido_PokemonPK> {

}
