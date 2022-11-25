package com.canchas.app.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.canchas.app.entity.Cliente;
public interface ClienteRepository extends JpaRepository <Cliente,Integer>{
	Optional<Cliente> findById(int id) ;
	
	Cliente save(Cliente cliente);
	
	void deleteById(int id);
}
