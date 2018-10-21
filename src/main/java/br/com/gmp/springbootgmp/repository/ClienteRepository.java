package br.com.gmp.springbootgmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gmp.springbootgmp.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
