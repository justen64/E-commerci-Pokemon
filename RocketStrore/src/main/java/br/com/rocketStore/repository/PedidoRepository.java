package br.com.rocketStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rocketStore.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
