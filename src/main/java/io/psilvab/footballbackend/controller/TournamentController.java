package io.psilvab.footballbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.psilvab.footballbackend.model.Tournament;
import io.psilvab.footballbackend.repository.TournamentRepository;

@RestController
@RequestMapping("/api")
public class TournamentController {

    Logger LOG = LoggerFactory.getLogger(TournamentController.class);

    @Autowired
    TournamentRepository tournamentRepository;

    @GetMapping("/tournaments")
    public ResponseEntity<List<Tournament>> getAll() {
        try {
            List<Tournament> tournaments = tournamentRepository.findAll();
            return new ResponseEntity<>(tournaments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping(value = "/tournaments")
    public ResponseEntity<Tournament> addTournament(@RequestBody final Tournament tournament) {
        LOG.info("New tournaments {}", tournament.toString());
        try {
            Tournament toReturn = tournamentRepository.save(tournament);
            return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
        } catch (final Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
