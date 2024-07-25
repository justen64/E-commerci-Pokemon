package br.com.rocketStore.DTO;

import br.com.rocketStore.entity.Endereco;

public class EnderecoDTO {

	private String cep;
	private String logradouro;
	private String complemento;
	private String localidade;
	private String uf;
	private Integer ibge;
	private Integer numero;

	public EnderecoDTO() {
		super();
	}

	public EnderecoDTO(Endereco endereco) {
		super();
		cep = endereco.getCep();
		logradouro = endereco.getLogradouro();
		complemento = endereco.getComplemento();
		localidade = endereco.getLocalidade();
		uf = endereco.getUf();
		ibge = endereco.getIbge();
		numero = endereco.getNumero();
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getIbge() {
		return ibge;
	}

	public void setIbge(Integer ibge) {
		this.ibge = ibge;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
