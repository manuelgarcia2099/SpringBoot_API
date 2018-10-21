package br.com.gmp.springbootgmp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gmp.springbootgmp.model.Cliente;
import br.com.gmp.springbootgmp.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired //CDI
	private ClienteRepository repoCliente;
	
	public List<Cliente> clientes(){
		return repoCliente.findAll();
	} 
	
	public Cliente salvar(Cliente fornecedor) {
		return fornecedor = repoCliente.save(fornecedor);
	}
	
	public Cliente cliente(Long id) {
		return repoCliente.findById(id).orElse(null);
	}
	
	public void deletar(Long id) {
		repoCliente.deleteById(id);
	}


}
