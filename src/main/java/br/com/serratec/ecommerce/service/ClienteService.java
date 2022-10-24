package br.com.serratec.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.ecommerce.dto.ClienteDTO;
import br.com.serratec.ecommerce.dto.EnderecoDTO;
import br.com.serratec.ecommerce.entity.Cliente;
import br.com.serratec.ecommerce.entity.Endereco;
import br.com.serratec.ecommerce.repository.ClienteRepository;
import br.com.serratec.ecommerce.repository.EnderecoRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	EnderecoService enderecoService;
	
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}
	
	public List<ClienteDTO> getAllClientesDTO(){
		List<Cliente> listaCliente = clienteRepository.findAll();
		List<ClienteDTO> listaClienteDTO = new ArrayList<>();
		
		for(Cliente cliente : listaCliente) {
			ClienteDTO clienteDTO = toDto(cliente);
			listaClienteDTO.add(clienteDTO);
		}
		
		return listaClienteDTO;
	}
	
	public Cliente getClienteById(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public ClienteDTO saveClienteDTO(ClienteDTO clienteDTO) {
		Cliente novoCliente = clienteRepository.save(toEntity(clienteDTO));
		Endereco endereco = enderecoService.saveEnderecoFromApi(clienteDTO.getCep(), clienteDTO.getComplemento(), clienteDTO.getNumero(), novoCliente);

		clienteDTO = toDto(clienteRepository.save(novoCliente));
		clienteDTO.setIdEndereco(endereco.getIdEndereco());

		return clienteDTO;
	}
	
	public ClienteDTO saveClienteTeste(ClienteDTO clienteDTO) {
		clienteDTO.setCpf(clienteDTO.getCpf());
		clienteDTO.setTelefone(clienteDTO.getTelefone());


		Cliente novoCliente = clienteRepository.save(toEntity(clienteDTO));
		EnderecoDTO endereco = enderecoService.saveEnderecoDTO(novoCliente.getIdCliente(), clienteDTO.getCep(),
					clienteDTO.getNumero(), clienteDTO.getComplemento());

		clienteDTO = toDto(clienteRepository.save(novoCliente));
		clienteDTO.setIdEndereco(endereco.getIdEndereco());

			return clienteDTO;
		

	}
	
	//Falta finalizar
	public ClienteDTO updateCliente(ClienteDTO clienteDTO, Integer id) {
		
		Cliente clienteBD = clienteRepository.existsById(clienteDTO.getIdCliente())
				? clienteRepository.findById(clienteDTO.getIdCliente()).get()
				: null;

		Endereco endereco = clienteBD.getEndereco();
		ClienteDTO novoClienteDTO = toDto(saveCliente(toEntity(clienteDTO)));
		enderecoRepository.deleteById(endereco.getIdEndereco());

		return novoClienteDTO;
	}
	
	public Cliente deleteCliente(Integer id) {
		if (getClienteById(id).getEndereco() != null)
			enderecoRepository.deleteById(getClienteById(id).getEndereco().getIdEndereco());
		
		clienteRepository.deleteById(id);
		return null;
	}
	
	private Cliente toEntity(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();

		cliente.setIdCliente(clienteDTO.getIdCliente());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setNomeCompleto(clienteDTO.getNomeCompleto());
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setTelefone(clienteDTO.getTelefone());
		cliente.setDataNascimento(clienteDTO.getDataNascimento());

		return cliente;
	}

	private ClienteDTO toDto(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();

		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setNomeCompleto(cliente.getNomeCompleto());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setTelefone(cliente.getTelefone());
		clienteDTO.setDataNascimento(cliente.getDataNascimento());
//		if (cliente.getEndereco() != null) {
//			clienteDTO.setIdEndereco(cliente.getEndereco().getIdEndereco());
//			clienteDTO.setCep(cliente.getEndereco().getCep());
//			clienteDTO.setNumero(cliente.getEndereco().getNumero());
//			clienteDTO.setComplemento(cliente.getEndereco().getComplemento());
//		}

		return clienteDTO;
	}
}
