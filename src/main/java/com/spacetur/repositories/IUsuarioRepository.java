package com.spacetur.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spacetur.models.UsuarioModel;

public interface IUsuarioRepository extends MongoRepository <UsuarioModel, String>{

}
