package br.com.serratec.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.ecommerce.dto.ClienteDTO;
import br.com.serratec.ecommerce.entity.Cliente;
import br.com.serratec.ecommerce.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	ClienteService clienteService;
	
	@GetMapping()
	public ResponseEntity<List<Cliente>> getAllClientes(){
		return new ResponseEntity<>(clienteService.getAllClientes(), HttpStatus.OK);
	}
	
	@GetMapping("/dto")
	public ResponseEntity<List<ClienteDTO>> getAllClientesDTO(){
		return new ResponseEntity<>(clienteService.getAllClientesDTO(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id){
		Cliente cliente = clienteService.getClienteById(id);
		
		if(cliente != null) {
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
		}
	}
	
//	@PostMapping()
//	public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
////		try {
//			return new ResponseEntity<>(clienteService.saveCliente(cliente), HttpStatus.CREATED);
////		} catch (Exception ex) {
////			throw new MethodArgumentNotValidException("        ");
////		}
//	}
	
	@PostMapping()
	public ResponseEntity<ClienteDTO> saveClienteDTO(@RequestBody ClienteDTO clienteDTO){
//		try {
			return new ResponseEntity<>(clienteService.saveClienteDTO(clienteDTO), HttpStatus.CREATED);
//		} catch (Exception ex) {
//			throw new MethodArgumentNotValidException("         ");
//		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> updateCliente(@RequestBody ClienteDTO clienteDTO, @PathVariable Integer id) {
		if(clienteService.getClienteById(id) != null) {
			return new ResponseEntity<>(clienteService.updateCliente(clienteDTO, id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable Integer id) {
		if(clienteService.getClienteById(id) != null) {
			return new ResponseEntity<>(clienteService.deleteCliente(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
