package com.canchas.app.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canchas.app.entity.Predio;
import com.canchas.app.repository.PredioRepository;
@Service
public class PredioService {

	@Autowired
	private PredioRepository predioRepository;
	@Transactional(readOnly=true)
	public Optional<Predio> findById(int id) {
		return predioRepository.findById(id);
	}
	@Transactional(readOnly=true)
	public Iterable<Predio> findAll() {
		return predioRepository.findAll();
	}
	@Transactional
	public Predio save(Predio predio) {
		return predioRepository.save(predio);
	}
	@Transactional
	public void deleteById(int id) {
		predioRepository.deleteById(id);
	}
	
}
