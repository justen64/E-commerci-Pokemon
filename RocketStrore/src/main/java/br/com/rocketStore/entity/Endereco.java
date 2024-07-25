package br.com.rocketStore.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Cep vazio ou nulo!")
	private String cep;
	private String logradouro;
	private String complemento;
	private String localidade;
	private String uf;
	private Integer ibge;
	@NotNull(message = "Número inválido!")
	private Integer numero;
	@OneToMany(mappedBy = "endereco")
	private List<Cliente> clientes;

	public Endereco() {
		super();
	}

	public Endereco(Endereco endereco) {
		super();
		this.id = endereco.getId();
		this.cep = endereco.getCep();
		this.logradouro = endereco.getLogradouro();
		this.complemento = endereco.getComplemento();
		this.localidade = endereco.getLocalidade();
		this.uf = endereco.getUf();
		this.ibge = endereco.getIbge();
		this.numero = endereco.getNumero();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	
}
