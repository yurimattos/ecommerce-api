package br.com.serratec.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.ecommerce.entity.Categoria;
import br.com.serratec.ecommerce.service.CategoriaService;

@RestController
public class CategoriaController {
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping()
	public ResponseEntity<List<Categoria>> getAllCategorias(){
		return new ResponseEntity<>(categoriaService.getAllCategorias(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable Integer id){
		Categoria categoria = categoriaService.getCategoriaById(id);
		
		if(categoria != null) {
			return new ResponseEntity<>(categoria, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(categoria, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping()
	public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria){
//		try {
			return new ResponseEntity<>(categoriaService.saveCategoria(categoria), HttpStatus.CREATED);
//		} catch (Exception ex) {
//			throw new MethodArgumentNotValidException("Informe o CPF");
//		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria, @PathVariable Integer id) {
		if(categoriaService.getCategoriaById(id) != null) {
			return new ResponseEntity<>(categoriaService.deleteCategoria(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
