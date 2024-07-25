package br.com.rocketStore.DTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import br.com.rocketStore.entity.Pedido;
import br.com.rocketStore.entity.Pokemon;
import br.com.rocketStore.enuns.StatusENUM;

public class PedidoRequestDTO {

	private LocalDate dataPedido;
	private StatusENUM status;
	private Long idCliente;
//	private Integer quantidade;
//	private List<Long> idPokemon;
	private List <ProdutoQuantidadeDTO> produtos;
	
	public PedidoRequestDTO() {
		super();
	}

	public PedidoRequestDTO(Pedido pedido, Set<Pokemon> pokemon) {
		this.dataPedido = pedido.getDataPedido();
		this.status = pedido.getStatus();
		this.idCliente = pedido.getCliente().getId();
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

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public List<ProdutoQuantidadeDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoQuantidadeDTO> produtos) {
		this.produtos = produtos;
	}

	

}
