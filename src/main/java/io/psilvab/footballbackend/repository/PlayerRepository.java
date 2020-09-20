package io.psilvab.footballbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import io.psilvab.footballbackend.model.Player;

public interface PlayerRepository extends MongoRepository<Player, String> {

    Optional<Player> findByName(String name);
    List<Player> findByTeam(String team, Sort sort);

}
