package com.canchas.app.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.canchas.app.entity.Reserva;
import com.canchas.app.repository.ReservaRepository;
@Service
public class ReservaService{
	@Autowired
	private ReservaRepository reservaRepository;
	public Optional<Reserva> findById(int id) {
		return reservaRepository.findById(id);
	}
	public Reserva save(Reserva reserva) {
		return reservaRepository.save(reserva);
	}
	public void deleteById(int id) {
		reservaRepository.deleteById(id);
	}

}
