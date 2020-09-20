package io.psilvab.footballbackend.controller;

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

import io.psilvab.footballbackend.model.Match;
import io.psilvab.footballbackend.repository.MatchRepository;
import io.psilvab.footballbackend.services.MatchService;

@RestController
@RequestMapping("/api")
public class MatchController {

    Logger LOG = LoggerFactory.getLogger(MatchController.class);

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    MatchService matchService;

    @GetMapping("/")
    public String getAll() {
        return "Hello World";
    }

    @PostMapping(value = "/match")
    public ResponseEntity<Match> addMatch(@RequestBody final Match match) {
        LOG.info("Nuevo match {}", match.toString());
        try {
            Match toReturn = matchService.saveMatch(match);
            return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
        } catch (final Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
