package com.canchas.app.repository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canchas.app.entity.Cancha;
import com.canchas.app.entity.Predio;
import com.canchas.app.entity.Reserva;

public interface ReservaRepository extends JpaRepository <Reserva,Integer> {
	Optional<Reserva> findById(int id) ;
	
	Reserva save(Reserva reserva);
	
	void deleteById(int id);
	
	Optional <Reserva> findByfechaHoraAndCanchaReservada(LocalDateTime fechaHora, Cancha canchaReservada);
	
}
