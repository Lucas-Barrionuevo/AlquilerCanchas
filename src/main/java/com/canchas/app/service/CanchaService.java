package com.canchas.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canchas.app.entity.Cancha;
import com.canchas.app.entity.Cliente;
import com.canchas.app.entity.Predio;
import com.canchas.app.repository.CanchaRepository;
import com.canchas.app.repository.PredioRepository;
@Service
public class CanchaService {
	@Autowired
	private CanchaRepository canchaRepository;
	//private PredioRepository predioRepository;
	public Cancha save(Cancha cancha) {
		return canchaRepository.save(cancha);
	}
	/*@Override
	public Iterable<Cancha> canchasPorPredio(int predioId) {
		Optional<Predio> predio = predioRepository.findById(predioId);
		Iterable <Cancha> canchas = canchaRepository.findbyPredio(predio);
		return canchas;
	}*/
	public Optional<Cancha> findById(int id) {
		return canchaRepository.findById(id);
	}
	public void deleteById(int id) {
		canchaRepository.deleteById(id);
		
	}

}
