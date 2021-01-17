package io.psilvab.footballbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.psilvab.footballbackend.model.Player;

public interface PlayerRepository extends MongoRepository<Player, String>{

}
