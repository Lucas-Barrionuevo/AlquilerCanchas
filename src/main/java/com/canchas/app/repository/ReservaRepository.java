package com.canchas.app.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.canchas.app.entity.Reserva;

public interface ReservaRepository extends JpaRepository <Reserva,Integer> {
	Optional<Reserva> findById(int id) ;
	
	Reserva save(Reserva reserva);
	
	void deleteById(int id);
}
