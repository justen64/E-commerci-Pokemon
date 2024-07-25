package br.com.rocketStore.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column
	private String nome;
	
	private Long ordem;
	
	@Embedded
	private Types types;
	
	private LocalDateTime dataCadastro;

	private Double valorUnitario;
	private String imagem;
	
	

	public Pokemon() {
		super();
	}

	public Pokemon( String nome, Long ordem, Types types,String imagem) {
		super();
		this.nome = nome;
		this.ordem = ordem;
		this.types = types;
		this.imagem= imagem;
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getOrdem() {
		return ordem;
	}

	public void setOrdem(Long ordem) {
		this.ordem = ordem;
	}


	public Types getTypes() {
		return types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}
	
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}	
	
	
}
