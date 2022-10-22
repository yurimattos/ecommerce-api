package br.com.serratec.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.ecommerce.entity.Cliente;
import br.com.serratec.ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}
	
	public Cliente getClienteById(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente updateCliente(Integer id, Cliente cliente) {
		Cliente clienteExistenteNoBanco = getClienteById(id);
		
		clienteExistenteNoBanco.setCpf(cliente.getCpf());
		clienteExistenteNoBanco.setDataNascimento(cliente.getDataNascimento());
		clienteExistenteNoBanco.setEmail(cliente.getEmail());
		clienteExistenteNoBanco.setEndereco(cliente.getEndereco());
		clienteExistenteNoBanco.setNomeCompleto(cliente.getNomeCompleto());
		clienteExistenteNoBanco.setTelefone(cliente.getTelefone());
		
		return clienteRepository.save(clienteExistenteNoBanco);
	}
	
	public Cliente deleteCliente(Integer id) {
		clienteRepository.deleteById(id);
		return null;
	}
}
