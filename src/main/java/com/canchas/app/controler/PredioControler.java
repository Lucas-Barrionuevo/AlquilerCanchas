package com.canchas.app.controler;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
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
import com.canchas.app.entity.Predio;
import com.canchas.app.service.PredioService;
@RestController
@RequestMapping("/api/predio")
public class PredioControler {
	@Autowired
	private PredioService predioService;
	
	//create a new predio
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Predio predio){
		return ResponseEntity.status(HttpStatus.CREATED).body(predioService.save(predio));
	}
	
	// update an predio
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Predio predioDetails, @PathVariable(value = "id") int predioId){
		Optional<Predio> predio = predioService.findById(predioId);
		if (!predio.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		predio.get().setZona(predioDetails.getZona());
		return ResponseEntity.status(HttpStatus.CREATED).body(predioService.save(predio.get()));
	}
	
	//Delete an predio 
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") int predioId){
		if(!predioService.findById(predioId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		predioService.deleteById(predioId);
		return ResponseEntity.ok().build();
	}
	
	//Read all predio
	@GetMapping
	public List<Predio> readAll(){
		List<Predio> predio = StreamSupport
				.stream(predioService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return predio;
	}
}
