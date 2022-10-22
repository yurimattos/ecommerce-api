package br.com.serratec.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.ecommerce.entity.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
