package br.com.rocketStore.DTO;

import br.com.rocketStore.entity.Cliente;

public class ClienteResponseDTO {
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private String telefone1;
	private String telefone2;

	public ClienteResponseDTO(Cliente cliente) {
		id =cliente.getId();
		nome = cliente.getNome();
		telefone1 = cliente.getTelefone1();
		telefone2 = cliente.getTelefone2();
		email = cliente.getEmail();
		cpf = cliente.getCpf();
	}

	public ClienteResponseDTO() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getcpf() {
		return cpf;
	}

	public void setcpf(String cpf) {
		this.cpf = cpf;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



}
