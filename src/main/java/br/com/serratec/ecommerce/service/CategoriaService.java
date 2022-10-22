package br.com.serratec.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.ecommerce.entity.Categoria;
import br.com.serratec.ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> getAllCategorias(){
		return categoriaRepository.findAll();
	}
	
	public Categoria getCategoriaById(Integer id) {
		return categoriaRepository.findById(id).orElse(null);
	}
	
	public Categoria saveCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public Categoria updateCategoria(Integer id, Categoria categoria) {
		Categoria categoriaExistenteNoBanco = getCategoriaById(id);

		categoriaExistenteNoBanco.setDescricao(categoria.getDescricao());
		categoriaExistenteNoBanco.setNome(categoria.getNome());
		categoriaExistenteNoBanco.setProdutos(categoria.getProdutos());
		
		return categoriaRepository.save(categoriaExistenteNoBanco);
	}
	
	public Categoria deleteCategoria(Integer id) {
		categoriaRepository.deleteById(id);
		return null;
	}
}
