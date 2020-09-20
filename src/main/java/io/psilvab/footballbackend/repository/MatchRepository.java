package io.psilvab.footballbackend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import io.psilvab.footballbackend.model.Match;

public interface MatchRepository extends MongoRepository<Match, String> {

    @Query(value = "{'$or':[ { 'teamLocal._id' : ObjectId(?0) }, { 'teamVisit._id' : ObjectId(?0) } ] }")
    List<Match> findByTeam(String idTeam);

}
