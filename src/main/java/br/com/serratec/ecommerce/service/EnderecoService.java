package br.com.serratec.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.ecommerce.entity.Endereco;
import br.com.serratec.ecommerce.repository.EnderecoRepository;

@Service

public class EnderecoService {
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public List<Endereco> getAllEnderecos() {
		return enderecoRepository.findAll();
	}
	
	public Endereco getEnderecoById(Integer id) {
		return enderecoRepository.findById(id).orElse(null);
	}
	
	public Endereco saveEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public Endereco updateEndereco(Integer id, Endereco endereco) {
		Endereco enderecoExistenteNoBanco = getEnderecoById(id);
		
		enderecoExistenteNoBanco.setBairro(endereco.getBairro());
		enderecoExistenteNoBanco.setCep(endereco.getCep());
		enderecoExistenteNoBanco.setCidade(endereco.getCidade());
		enderecoExistenteNoBanco.setCliente(endereco.getCliente());
		enderecoExistenteNoBanco.setComplemento(endereco.getComplemento());
		enderecoExistenteNoBanco.setNumero(endereco.getNumero());
		enderecoExistenteNoBanco.setRua(endereco.getRua());
		enderecoExistenteNoBanco.setUf(endereco.getUf());
		
		return enderecoRepository.save(enderecoExistenteNoBanco);
	}
	
	public Endereco deleteEndereco(Integer id) {
		enderecoRepository.deleteById(id);
		return null;
	}
}
