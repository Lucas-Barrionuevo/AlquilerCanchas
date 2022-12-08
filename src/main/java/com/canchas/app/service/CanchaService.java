package com.canchas.app.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canchas.app.entity.Cancha;
import com.canchas.app.repository.CanchaRepository;
@Service
public class CanchaService {
	@Autowired
	private CanchaRepository canchaRepository;
	@Transactional
	public Cancha save(Cancha cancha) {
		return canchaRepository.save(cancha);
	}
	@Transactional (readOnly = true)
	public Optional<Cancha> findById(int id) {
		return canchaRepository.findById(id);
	}
	@Transactional
	public void deleteById(int id) {
		canchaRepository.deleteById(id);
		
	}

}
