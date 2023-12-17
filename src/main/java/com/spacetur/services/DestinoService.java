package com.spacetur.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spacetur.models.DestinoModel;
import com.spacetur.repositories.IDestinoRepository;

@Service
public class DestinoService {
	
	private final IDestinoRepository destinoRepo;
	
	public DestinoService(IDestinoRepository destinoRepo) {
	
		this.destinoRepo = destinoRepo;
	}
	public DestinoModel createDestino (DestinoModel destino){
		if (destino == null) {
			throw new IllegalArgumentException("Destino não existente!");
		} return destinoRepo.save(destino);
	}
	public List<DestinoModel> listDestinos (){
		return destinoRepo.findAll();
	}
	public DestinoModel updateDestino (DestinoModel destinoUpdate) {
		if (destinoUpdate == null || destinoUpdate.getId()== null) {
			throw new IllegalArgumentException("Destino ou Id inválido!");
		}
		Optional <DestinoModel> existingDestino = destinoRepo.findById(destinoUpdate.getId());
		if (existingDestino.isEmpty()) {
			throw new IllegalArgumentException("Destino ou Id inválido!");
		}
		return destinoRepo.save(destinoUpdate);
	}
	
	public void DestinoDelete (String id) {
		if (id == null) {
			throw new IllegalArgumentException("Destino não encontrado!");
			
		}
		destinoRepo.deleteById(id);
	}
}
