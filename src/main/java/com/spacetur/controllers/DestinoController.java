package com.spacetur.controllers;

import java.util.List;

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

import com.spacetur.models.DestinoModel;
import com.spacetur.services.DestinoService;

@RestController
@RequestMapping("/destino")
public class DestinoController {

	
	private final DestinoService destinoService;

	  public DestinoController(DestinoService destinoService) {
	        this.destinoService = destinoService;
	  }
	  
	  @PostMapping
	    public ResponseEntity<DestinoModel> createDestino(@RequestBody DestinoModel destino) {
	        DestinoModel createDestino = destinoService.createDestino(destino);
	        return new ResponseEntity<>(createDestino, HttpStatus.CREATED);
	    }

	  @GetMapping
	  public ResponseEntity<List<DestinoModel>> getAllPacotes() {
	      List<DestinoModel> destinos = destinoService.listDestinos();
	      return new ResponseEntity<>(destinos, HttpStatus.OK);
	  }

	  @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePacote(@PathVariable("id") String destinoId) {
	        destinoService.DestinoDelete(destinoId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	     @PutMapping("/{id}")
	    public ResponseEntity<DestinoModel> updateDestino(@PathVariable("id") String destinoId, @RequestBody DestinoModel updatedDestino) {
	        updatedDestino.setId(destinoId);
	        DestinoModel updated = destinoService.updateDestino(updatedDestino);
	        return new ResponseEntity<>(updated, HttpStatus.OK);
	    }
	}