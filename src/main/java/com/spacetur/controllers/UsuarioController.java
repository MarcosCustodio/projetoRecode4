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

import com.spacetur.models.UsuarioModel;
import com.spacetur.services.UsuarioService;



@RestController
@RequestMapping("/users")
public class UsuarioController {

	
	 private final UsuarioService usuarioService;
	 


	    public UsuarioController(UsuarioService usuarioService) {
	        this.usuarioService = usuarioService;
	    }

	    @PostMapping
	    public ResponseEntity<UsuarioModel> createUsuario(@RequestBody UsuarioModel usuario) {
	        UsuarioModel createdUsuario = usuarioService.createUsuario(usuario);
	        return new ResponseEntity<>(createdUsuario, HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<UsuarioModel>> getAllUsers() {
	        List<UsuarioModel> users = usuarioService.listUsuarios();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteUsuario(@PathVariable("id") String Id) {
	        usuarioService.UsuarioDelete(Id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<UsuarioModel> updateUsuario(@PathVariable("id") String usuarioId, @RequestBody UsuarioModel updatedUsuario) {
	        updatedUsuario.setId(usuarioId);
	        UsuarioModel updated = usuarioService.updateUsuario(updatedUsuario);
	        return new ResponseEntity<>(updated, HttpStatus.OK);
	    }

	    @PostMapping("/{idUsuario}/{idPacote}")
	    public ResponseEntity<UsuarioModel> buyPacote(@PathVariable("idUsuario") String idUsuario, @PathVariable("idPacote") String idPacote) {
	        try {
	            if (idUsuario != null && idPacote != null) {
	                var compra = usuarioService.buyPacote(idUsuario, idPacote);
	                return ResponseEntity.status(HttpStatus.OK).body(compra);
	            } else {
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	            }
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	    

	}
