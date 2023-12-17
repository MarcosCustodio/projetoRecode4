package com.spacetur.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spacetur.models.DestinoModel;
import com.spacetur.models.UsuarioModel;
import com.spacetur.repositories.IDestinoRepository;
import com.spacetur.repositories.IUsuarioRepository;

@Service 
public class UsuarioService {
 
	private final IUsuarioRepository usuarioRepo;
	private final IDestinoRepository destinoRepo;
	
	public UsuarioService(IUsuarioRepository usuarioRepo, IDestinoRepository destinoRepo) {
		this.usuarioRepo = usuarioRepo;
		this.destinoRepo = destinoRepo;
	}
	public UsuarioModel createUsuario (UsuarioModel usuario){
		if (usuario == null) {
			throw new IllegalArgumentException("Usuário não existente!");
		} return usuarioRepo.save(usuario);
	}
	public List<UsuarioModel> listUsuarios (){
		return usuarioRepo.findAll();
	}
	public UsuarioModel updateUsuario (UsuarioModel usuarioUpdate) {
		if (usuarioUpdate == null || usuarioUpdate.getId()== null) {
			throw new IllegalArgumentException("Usuário ou Id inválido!");
		}
		Optional <UsuarioModel> existingUsuario = usuarioRepo.findById(usuarioUpdate.getId());
		if (existingUsuario.isEmpty()) {
			throw new IllegalArgumentException("Usuário ou Id inválido!");
		}
		return usuarioRepo.save(usuarioUpdate);
	}
	
	public void UsuarioDelete (String id) {
		if (id == null) {
			throw new IllegalArgumentException("Usuário não encontrado!");
			
		}
		usuarioRepo.deleteById(id);
	}
	public List<UsuarioModel> getAllUsers(){
		return null;
	}
	public UsuarioModel buyPacote (String idUsuario, String idDestino) {
		try {
			Optional <UsuarioModel> existingUsuario= usuarioRepo.findById(idUsuario);
			Optional <DestinoModel> existingDestino= destinoRepo.findById(idDestino);
			
			if(existingUsuario.isPresent()&& existingDestino.isPresent()) {
				UsuarioModel existingUsuarioOp = existingUsuario.get();
				DestinoModel existingDestinoOp = existingDestino.get();
				
				existingUsuarioOp.addPacote(existingDestinoOp);
				return usuarioRepo.save(existingUsuarioOp);
			}else {
				throw new IllegalArgumentException("Usuário ou Destino não encontrado!");
			}
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Falha ao realizar a compra", e);
		}
   }
}
