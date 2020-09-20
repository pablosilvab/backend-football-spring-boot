package io.psilvab.footballbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.psilvab.footballbackend.model.Tournament;

public interface TournamentRepository extends MongoRepository<Tournament,String>{
    
}
