package com.canchas.app.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.canchas.app.entity.Predio;

public interface PredioRepository extends JpaRepository <Predio,Integer> {
	List<Predio> findAll();
	
	Predio save(Predio predio);
	
	void deleteById(int id);
	
	Optional<Predio> findById(int id) ;
}
