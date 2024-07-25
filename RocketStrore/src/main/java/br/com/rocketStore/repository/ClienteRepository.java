package br.com.rocketStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rocketStore.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Cliente findByEmail(String email);

	Cliente findByNome(String nome);
}
