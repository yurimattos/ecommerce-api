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

import br.com.serratec.ecommerce.entity.Produto;
import br.com.serratec.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping()
	public ResponseEntity<List<Produto>> getAllProdutos(){
		return new ResponseEntity<>(produtoService.getAllProdutos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getProdutoById(@PathVariable Integer id){
		Produto produto = produtoService.getProdutoById(id);
		
		if(produto != null) {
			return new ResponseEntity<>(produto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(produto, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping()
	public ResponseEntity<Produto> saveProduto(@RequestBody Produto produto){
//		try {
			return new ResponseEntity<>(produtoService.saveProduto(produto), HttpStatus.CREATED);
//		} catch (Exception ex) {
//			throw new MethodArgumentNotValidException("Informe o CPF");
//		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto, @PathVariable Integer id) {
		if(produtoService.getProdutoById(id) != null) {
			return new ResponseEntity<>(produtoService.updateProduto(produto, id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> deleteProduto(@PathVariable Integer id) {
		if(produtoService.getProdutoById(id) != null) {
			return new ResponseEntity<>(produtoService.deleteProduto(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
