package br.com.serratec.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.ecommerce.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	Optional<User> findByUserEmail(String email);
}