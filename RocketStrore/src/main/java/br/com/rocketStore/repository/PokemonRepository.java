package br.com.rocketStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rocketStore.entity.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{

}
