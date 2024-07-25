package br.com.rocketStore.DTO;

import org.hibernate.validator.constraints.br.CPF;

import br.com.rocketStore.entity.Cliente;
import br.com.rocketStore.entity.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClienteRequestDTO {
	@NotBlank(message = "Nome vazio ou nulo!")
	private String nome;
	private String telefone1;
	private String telefone2;
	@Email(message = "email inválido!")
	private String email;
	@CPF(message = "CPF inválido!")
	private String cpf;
	@NotBlank
	private String senha;
	@NotBlank
	private String confirmaSenha;
	@NotBlank
	private String cep;
	private Integer numero;
	
	public ClienteRequestDTO() {
		super();
	}

	public ClienteRequestDTO(Cliente cliente) {
		nome = cliente.getNome();
		telefone1 = cliente.getTelefone1();
		telefone1 = cliente.getTelefone2();
		email = cliente.getEmail();
		cpf = cliente.getCpf();
		senha = cliente.getSenha();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	
	
	
	
}