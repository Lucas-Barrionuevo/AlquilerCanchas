package com.canchas.app.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.canchas.app.entity.Cancha;

public interface CanchaRepository extends JpaRepository <Cancha,Integer>{
	Optional<Cancha> findById(int id) ;
	
	Cancha save(Cancha cancha);

	void deleteById(int id);

}

