package io.psilvab.footballbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.psilvab.footballbackend.model.Match;

public interface MatchRepository extends MongoRepository<Match, String> {
    
}
