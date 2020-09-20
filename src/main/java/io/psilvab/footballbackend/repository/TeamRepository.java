package io.psilvab.footballbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import io.psilvab.footballbackend.model.Team;

public interface TeamRepository extends MongoRepository<Team, String>{

    @Query(value="{ '_id' : ?0 }", fields="{ '_id' : 1, 'name' : 1}")
    Team findByIdAndExcludeTournament(String id);

}
