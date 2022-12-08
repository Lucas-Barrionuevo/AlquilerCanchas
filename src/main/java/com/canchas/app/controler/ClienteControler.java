package com.canchas.app.controler;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.canchas.app.entity.Cliente;
import com.canchas.app.service.ClienteService;
@RestController
@RequestMapping("/api/cliente")
public class ClienteControler {
	@Autowired
	private ClienteService clienteService;
	
	//Evita que pasen a la base de datos campos vacios
	@InitBinder
	public void miBinder (WebDataBinder binder) {
		StringTrimmerEditor recortarEspaciosBlaco = new StringTrimmerEditor(true);
		
		binder.registerCustomEditor(String.class, recortarEspaciosBlaco);
	}
	
	//create a new cliente
	@PostMapping
	public ResponseEntity<?> create (@Valid @RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}	
	
	//read an cliente
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id")int clienteId){
		Optional<Cliente> oCliente = clienteService.findById(clienteId);
		
		if (!oCliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oCliente);
	}
	
	// update an cliente
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Cliente clienteDetails, @PathVariable(value = "id") int clienteId){
		Optional<Cliente> cliente = clienteService.findById(clienteId);
		if (!cliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		cliente.get().setNombre(clienteDetails.getNombre());
		cliente.get().setApellido(clienteDetails.getApellido());
		cliente.get().setDni(clienteDetails.getDni());
		cliente.get().setCelular(clienteDetails.getCelular());
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente.get()));
	}
	
	//Delete an cliente 
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") int clienteId){
		if(!clienteService.findById(clienteId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		clienteService.deleteById(clienteId);
		return ResponseEntity.ok().build();
	}
	

}
