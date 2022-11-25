package com.canchas.app.controler;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canchas.app.entity.Cancha;
import com.canchas.app.entity.Predio;
import com.canchas.app.entity.Reserva;
import com.canchas.app.service.CanchaService;
import com.canchas.app.service.PredioService;
import com.canchas.app.service.ReservaService;

@RestController
@RequestMapping("/api/reserva")
public class ReservaControler {
	@Autowired
	private ReservaService reservaService;
	@Autowired
	private CanchaService canchaService;
	@Autowired
	private PredioService predioService;
	
	//create a new reserva
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Reserva reserva){
		Optional<Cancha> canchaOp = canchaService.findById(reserva.getCanchaReservada().getId());
		if(!canchaOp.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Optional<Predio> predioOp = predioService.findById(reserva.getPredioReservado().getIdPredio());
		if(!predioOp.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.save(reserva));
	}
	
	//read an reserva
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id")int reservaId){
		Optional<Reserva> oReserva = reservaService.findById(reservaId);
		if (!oReserva.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oReserva);
	}
	
	// update an user
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Reserva reservaDetails, @PathVariable(value = "id") int reservarId){
		Optional<Predio> predioOp = predioService.findById(reservaDetails.getPredioReservado().getIdPredio());
		if(!predioOp.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Optional<Cancha> canchaOp = canchaService.findById(reservaDetails.getCanchaReservada().getId());
		if(!canchaOp.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Optional<Reserva> reserva = reservaService.findById(reservarId);
		if (!reserva.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		reserva.get().setAño(reservaDetails.getAño());
		reserva.get().setPredioReservado(reservaDetails.getPredioReservado());
		reserva.get().setCanchaReservada(reservaDetails.getCanchaReservada());
		reserva.get().setDia(reservaDetails.getDia());
		reserva.get().setHsReservadas(reservaDetails.getHsReservadas());
		reserva.get().setIdReserva(reservaDetails.getIdReserva());
		reserva.get().setMes(reservaDetails.getMes());
		reservaService.save(reserva.get());
		return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.save(reserva.get()));
	}
	
	//Delete an user 
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") int reservaId){
		if(!reservaService.findById(reservaId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		reservaService.deleteById(reservaId);
		return ResponseEntity.ok().build();
	}

}
