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

import br.com.serratec.ecommerce.entity.Endereco;
import br.com.serratec.ecommerce.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping()
	public ResponseEntity<List<Endereco>> getAllEnderecos(){
		return new ResponseEntity<>(enderecoService.getAllEnderecos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> getEnderecoById(@PathVariable Integer id){
		Endereco endereco = enderecoService.getEnderecoById(id);
		
		if(endereco != null) {
			return new ResponseEntity<>(endereco, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(endereco, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping()
	public ResponseEntity<Endereco> saveEndereco(@RequestBody Endereco endereco){
//		try {
			return new ResponseEntity<>(enderecoService.saveEndereco(endereco), HttpStatus.CREATED);
//		} catch (Exception ex) {
//			throw new MethodArgumentNotValidException("Informe o CPF");
//		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Endereco> updateEndereco(@RequestBody Endereco endereco, @PathVariable Integer id) {
		if(enderecoService.getEnderecoById(id) != null) {
			return new ResponseEntity<>(enderecoService.updateEndereco(id, endereco), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Endereco> deleteEndereco(@PathVariable Integer id) {
		if(enderecoService.getEnderecoById(id) != null) {
			return new ResponseEntity<>(enderecoService.deleteEndereco(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
//	@GetMapping("/cep/{cep}")
//	public ResponseEntity<Endereco> saveEnderecoFromApi(@PathVariable String cep){
//		return new ResponseEntity<>(enderecoService.saveEnderecoFromApi(cep), HttpStatus.CREATED);
//	}
}
