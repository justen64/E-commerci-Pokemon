package br.com.rocketStore.DTO;

import br.com.rocketStore.entity.Pedido_Pokemon;

public class PedidoPokeResponseDTO {
	
	
	private Long numeroDoPedido;
	
	private PedidoPokemonResponseDTO produtos;

	

	public PedidoPokeResponseDTO(Pedido_Pokemon pok) {
		this.numeroDoPedido = pok.getId().getPedido().getId();
		this.produtos = new PedidoPokemonResponseDTO(pok);
	}

	public Long getNumeroDoPedido() {
		return numeroDoPedido;
	}



	public void setNumeroDoPedido(Long numeroDoPedido) {
		this.numeroDoPedido = numeroDoPedido;
	}

	public PedidoPokemonResponseDTO getProdutos() {
		return produtos;
	}

	public void setProdutos(PedidoPokemonResponseDTO produtos) {
		this.produtos = produtos;
	}
	
	
}