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
import com.canchas.app.entity.Cliente;
import com.canchas.app.entity.Predio;
import com.canchas.app.service.CanchaService;
import com.canchas.app.service.PredioService;
@RestController
@RequestMapping("/api/cancha")
public class CanchaControler {
	@Autowired
	private CanchaService canchaService;
	
	@Autowired
	private PredioService predioService;
	
	//create a new cancha
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Cancha cancha){
		Optional <Predio> predioOp = predioService.findById(cancha.getPredio().getId());
		if (!predioOp.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(canchaService.save(cancha));
	}

	// update an cancha
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Cancha canchaDetails, @PathVariable(value = "id") int canchaId){
		Optional <Predio> predioOp = predioService.findById(canchaDetails.getPredio().getId());
		if (!predioOp.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Optional<Cancha> cancha = canchaService.findById(canchaId);
		if (!cancha.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		cancha.get().setValorXHora(canchaDetails.getValorXHora());
		cancha.get().setPredio(canchaDetails.getPredio());
		return ResponseEntity.status(HttpStatus.CREATED).body(canchaService.save(cancha.get()));
	}
	
	//Delete an cancha 
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") int canchaId){
		if(!canchaService.findById(canchaId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		canchaService.deleteById(canchaId);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> predioPorCancha (@PathVariable (value= "id") int predioId){
		Optional <Predio> predioOp = predioService.findById(predioId);
		if (!predioOp.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(predioOp);
		
		
	}
}
