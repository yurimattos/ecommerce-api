package br.com.serratec.ecommerce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.serratec.ecommerce.dto.EnderecoDTO;
import br.com.serratec.ecommerce.entity.Cliente;
import br.com.serratec.ecommerce.entity.Endereco;
import br.com.serratec.ecommerce.repository.ClienteRepository;
import br.com.serratec.ecommerce.repository.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired 
	ClienteRepository clienteRepository;
	
	public List<Endereco> getAllEnderecos() {
		return enderecoRepository.findAll();
	}
	
	public Endereco getEnderecoById(Integer id) {
		return enderecoRepository.findById(id).orElse(null);
	}
	
	public Endereco saveEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public EnderecoDTO saveEnderecoDTO(Integer idCliente, String cep, Integer numero, String complemento) {
		Endereco endereco = new Endereco();
		endereco.setNumero(numero);
		endereco.setComplemento(complemento);
		endereco.setCep(cep);
		
		EnderecoDTO enderecoNovo = toDto(enderecoRepository.save(endereco));

		Cliente cliente = clienteRepository.findById(idCliente).get();
		cliente.setEndereco(endereco);
		cliente.getEndereco().setIdEndereco(endereco.getIdEndereco());
		
		return enderecoNovo;
	}
	
	public EnderecoDTO saveEnderecoTeste(Integer idCliente, String cep, String numero, String complemento) {
		Endereco endereco = cepDTOParaEndereco(consultaCepApi(cep));
		endereco.setComplemento(complemento);
		endereco.setCep(cep);

		EnderecoDTO novoEndereco = toDto(enderecoRepository.save(endereco));

		Cliente cliente = clienteRepository.findById(idCliente).get();
		cliente.setEndereco(endereco);
		cliente.getEndereco().setIdEndereco(endereco.getIdEndereco());

		return novoEndereco;
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
	
	public EnderecoDTO consultaCepApi(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://viacep.com.br/ws/{cep}/json/";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("cep", cep); //Primeiro o nome da chave, depois a variavel
		
		
		EnderecoDTO enderecoDTO = restTemplate.getForObject(uri, EnderecoDTO.class, params);
		
		return enderecoDTO;
	}
	
	public Endereco saveEnderecoFromApi (String cep, String complemento, Integer numero, Cliente cliente) {
		EnderecoDTO enderecoDTO = consultaCepApi(cep);
		
		Endereco endereco = new Endereco();
		endereco.setCep(enderecoDTO.getCep());
		endereco.setRua(enderecoDTO.getLogradouro());
		endereco.setBairro(enderecoDTO.getBairro());
		endereco.setCidade(enderecoDTO.getLocalidade());
		endereco.setUf(enderecoDTO.getUf());
		endereco.setNumero(numero);
		endereco.setComplemento(complemento);
		endereco.setCliente(cliente);
		
		return enderecoRepository.save(endereco);
	}
	
	private Endereco cepDTOParaEndereco(EnderecoDTO enderecoDTO) {
		Endereco endereco = new Endereco();
		endereco.setBairro(enderecoDTO.getBairro());
		endereco.setCep(enderecoDTO.getCep());
		endereco.setCidade(enderecoDTO.getLocalidade());
		endereco.setRua(enderecoDTO.getLogradouro());
		endereco.setUf(enderecoDTO.getUf());

		return endereco;
	}
	
	private Endereco toEntity(EnderecoDTO enderecoDTO) {
		Endereco endereco = new Endereco();

		endereco.setBairro(enderecoDTO.getBairro());
		endereco.setCep(enderecoDTO.getCep());
		endereco.setCidade(enderecoDTO.getLocalidade());
		endereco.setComplemento(enderecoDTO.getComplemento());
		endereco.setNumero(enderecoDTO.getNumero());
		endereco.setRua(enderecoDTO.getLogradouro());

		return endereco;
	}

	private EnderecoDTO toDto(Endereco endereco) {
		EnderecoDTO enderecoDTO = new EnderecoDTO();

		enderecoDTO.setIdEndereco(endereco.getIdEndereco());
		enderecoDTO.setBairro(endereco.getBairro());
		enderecoDTO.setCep(endereco.getCep());
		enderecoDTO.setLocalidade(endereco.getCidade());
		enderecoDTO.setComplemento(endereco.getComplemento());
		enderecoDTO.setNumero(endereco.getNumero());
		enderecoDTO.setLogradouro(endereco.getRua());

		return enderecoDTO;
	}
}