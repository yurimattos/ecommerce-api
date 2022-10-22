package br.com.serratec.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.ecommerce.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
