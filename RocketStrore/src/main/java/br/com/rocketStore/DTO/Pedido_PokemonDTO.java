package br.com.rocketStore.DTO;

public class Pedido_PokemonDTO {
	
	private Long idPedido;
    private Long idProduto;
    private Integer quantidade;    
    
    public Long getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
    public Long getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
