package com.spacetur.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spacetur.models.DestinoModel;

public interface IDestinoRepository extends MongoRepository <DestinoModel, String>{

}
