package br.com.rocketStore.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import br.com.rocketStore.enuns.StatusENUM;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private LocalDate dataPedido;
	private StatusENUM status;
	
	
	@OneToMany(mappedBy = "id.pedido", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Pedido_Pokemon> produtos = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	@NotNull
	private Cliente cliente;
	
	
	
	public Set<Pedido_Pokemon> getProdutos() {
		return produtos;
	}
	public void setProdutos(Set<Pedido_Pokemon> produtos) {
		this.produtos = produtos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	public StatusENUM getStatus() {
		return status;
	}
	public void setStatus(StatusENUM status) {
		this.status = status;
	}
	
	
	
}
