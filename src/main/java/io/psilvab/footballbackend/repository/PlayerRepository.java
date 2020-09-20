package io.psilvab.footballbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.psilvab.footballbackend.model.Player;

public interface PlayerRepository extends MongoRepository<Player, String> {

    Optional<Player> findByName(String name);

}
