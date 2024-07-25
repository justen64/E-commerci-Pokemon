package br.com.rocketStore.DTO;

import br.com.rocketStore.entity.Pedido_Pokemon;

public class PedidoPokemonResponseDTO {

	private String nomePokemon;
	private Double valorPedido;
	private Integer quantidade;
	

	public PedidoPokemonResponseDTO(Pedido_Pokemon save) {
		this.nomePokemon = save.getId().getPokemon().getNome();
		this.valorPedido = save.getId().getPokemon().getValorUnitario();
		this.quantidade = save.getQuantidade();
	}
	public String getNomePokemon() {
		return nomePokemon;
	}
	public void setNomePokemon(String nomePokemon) {
		this.nomePokemon = nomePokemon;
	}
	public Double getValorPedido() {
		return valorPedido;
	}
	public void setValorPedido(Double valorPedido) {
		this.valorPedido = valorPedido;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}