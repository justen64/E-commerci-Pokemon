package br.com.rocketStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.rocketStore.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	Endereco findByCep(String cep);
}
