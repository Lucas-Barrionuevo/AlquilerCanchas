package com.canchas.app.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.canchas.app.entity.Cancha;
import com.canchas.app.entity.Predio;

public interface CanchaRepository extends JpaRepository <Cancha,Integer>{

//	public Iterable<Cancha> findbyPredio(Optional<Predio> predio);
	Optional<Cancha> findById(int id) ;
	
	Cancha save(Cancha cancha);
		
	//public Iterable<Cancha> canchasPorPredio(int id);

	void deleteById(int id);
}
