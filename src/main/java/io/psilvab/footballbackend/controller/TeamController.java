package io.psilvab.footballbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.psilvab.footballbackend.model.Team;
import io.psilvab.footballbackend.model.Tournament;
import io.psilvab.footballbackend.repository.TeamRepository;
import io.psilvab.footballbackend.services.TournamentService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TeamController {
    
    Logger LOG = LoggerFactory.getLogger(TeamController.class);

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    TournamentService teamService;


    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getAll() {
        try {
            List<Team> teams = teamRepository.findAll();
            return new ResponseEntity<>(teams, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping(value = "/teams")
    public ResponseEntity<Team> addMatch(@RequestBody final Team team) {
        LOG.info("New Team {}", team.toString());
        try {
            Tournament tournament = teamService.tournamentExist(team.getTournament().getId());
            if (tournament.equals(null)){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } else {
                Team newTeam = new Team();
                newTeam.setName(team.getName());
                newTeam.setTournament(tournament);
                teamRepository.save(newTeam);
                return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
            }
        } catch (final Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
