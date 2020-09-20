package io.psilvab.footballbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.psilvab.footballbackend.model.Match;
import io.psilvab.footballbackend.model.Tournament;
import io.psilvab.footballbackend.repository.MatchRepository;
import io.psilvab.footballbackend.services.MatchService;
import io.psilvab.footballbackend.services.TournamentService;

@RestController
@RequestMapping("/api")
public class MatchController {

    Logger LOG = LoggerFactory.getLogger(MatchController.class);

    @Autowired
    TournamentService teamService;

    @Autowired
    MatchService matchService;

    @Autowired
    MatchRepository matchRepository;

    @PostMapping(value = "/matches")
    public ResponseEntity<Match> addMatch(@RequestBody final Match match) {
        LOG.info("Nuevo match: {}", match.toString());
        try {
            // Validamos que existe el torneo
            Tournament tournament = teamService.tournamentExist(match.getTournament().getId());
            if (tournament == null) {
                LOG.info("No existe torneo.");
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            match.setTournament(tournament);

            Match newMatch = matchService.saveMatch(match);
            return new ResponseEntity<>(newMatch, HttpStatus.CREATED);
        } catch (final Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/matches/{idMatch}")
    public ResponseEntity<Match> getMatch(@PathVariable final String idMatch) {
        LOG.info("Get match: {}", idMatch);
        try {
            Match match = matchService.getMatch(idMatch);
            return new ResponseEntity<>(match, HttpStatus.OK);
        } catch (final Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/matches/team/{idTeam}")
    public ResponseEntity<List<Match>> getMatchesByTeam(@PathVariable final String idTeam) {
        LOG.info("Get match by Team: {}", idTeam);
        try {
            List<Match> match = matchService.getMatchesByTeam(idTeam);
            if (match.isEmpty())
                return new ResponseEntity<>(match, HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(match, HttpStatus.OK);
        } catch (final Exception e) {
            LOG.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
