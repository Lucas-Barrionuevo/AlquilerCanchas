package com.canchas.app.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canchas.app.entity.Cliente;
import com.canchas.app.repository.ClienteRepository;
@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Optional<Cliente> findById(int id) {
		return clienteRepository.findById(id);
	}
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	public void deleteById(int id) {
		clienteRepository.deleteById(id);
	}

}
