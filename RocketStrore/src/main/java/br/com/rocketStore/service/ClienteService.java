package br.com.rocketStore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.rocketStore.DTO.ClienteRequestDTO;
import br.com.rocketStore.DTO.ClienteResponseDTO;
import br.com.rocketStore.DTO.LoginDTO;
import br.com.rocketStore.configuration.MailConfig;
import br.com.rocketStore.entity.Cliente;
import br.com.rocketStore.entity.Endereco;
import br.com.rocketStore.exception.CepException;
import br.com.rocketStore.exception.ConfirmaSenhaException;
import br.com.rocketStore.exception.EmailException;
import br.com.rocketStore.exception.ResourceNotFoundException;
import br.com.rocketStore.repository.ClienteRepository;
import br.com.rocketStore.repository.EnderecoRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private MailConfig mailConfig;
	@Autowired
	private EnderecoRepository eRepository;
	
	public ClienteResponseDTO inserir(ClienteRequestDTO cliente) {
		if (!cliente.getSenha().equals(cliente.getConfirmaSenha())) {
			throw new ConfirmaSenhaException("As senhas não são iguais!");
		}

		if (repository.findByEmail(cliente.getEmail()) != null) {
			throw new EmailException("Email Já Cadastrado!");
		}
		Cliente c = new Cliente();
		c.setNome(cliente.getNome());
		c.setTelefone1(cliente.getTelefone1());
		c.setTelefone2(cliente.getTelefone2());
		c.setEmail(cliente.getEmail());
		c.setCpf(cliente.getCpf());
		c.setSenha(encoder.encode(cliente.getSenha()));
		
		if (cliente.getCep() != null) {
			RestTemplate rs = new RestTemplate();
			String url = "http://viacep.com.br/ws/" + cliente.getCep() + "/json";
			System.out.println(url);
			Optional<Endereco> enderecoViaCep = Optional.ofNullable(rs.getForObject(url, Endereco.class));
			if (enderecoViaCep.get().getCep() != null) {
				String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
				enderecoViaCep.get().setCep(cepSemTraco);
				enderecoViaCep.get().setNumero(cliente.getNumero());
				c.setEndereco(enderecoViaCep.get());
				eRepository.save(enderecoViaCep.get());
			} else {
				throw new CepException("Cep Não Encontrado!");
			}
		} else {
			throw new CepException("Por favor, insira um endereço!");
		}
		repository.save(c);
		mailConfig.sendMail(cliente.getEmail(), "Cadastro de Usuário no Sistema", cliente.toString());
		ClienteResponseDTO response = new ClienteResponseDTO(c); 
		return response;
	}

	public List<ClienteResponseDTO> listar() {
		List<Cliente> clientes = repository.findAll();
		return clientes.stream().map((c) -> new ClienteResponseDTO(c)).collect(Collectors.toList());
	}

	public Page<Cliente> listarPorPagina(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public ClienteResponseDTO alterarCliente(Long id, Cliente cliente) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lançamento não encontrado"));
		cliente.setId(id);
		cliente.setCpf(cliente.getCpf());
		cliente.setEmail(cliente.getEmail());
		cliente.setNome(cliente.getNome());
		cliente.setSenha(cliente.getSenha());
		repository.save(cliente);
		ClienteResponseDTO response = new ClienteResponseDTO(cliente); 
		return response;
	}
	public ClienteResponseDTO login(LoginDTO login) {
		Cliente cliente = repository.findByEmail(login.getLogin());
		if(cliente == null || !encoder.matches(login.getSenha(), cliente.getSenha())) throw new ResourceNotFoundException("Login ou senha invalida");
		return new ClienteResponseDTO(cliente);	
		
	}
}
