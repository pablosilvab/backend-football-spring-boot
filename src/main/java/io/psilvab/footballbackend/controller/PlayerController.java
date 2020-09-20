package io.psilvab.footballbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.psilvab.footballbackend.model.Player;
import io.psilvab.footballbackend.services.PlayerService;

@RestController
@RequestMapping("/api")
public class PlayerController {

    Logger LOG = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    PlayerService playerService;

    @GetMapping("/players/{team}")
    public ResponseEntity<List<Player>> getTopScorers(@PathVariable String team) {
        LOG.info("Get top scorers by team {} ", team);
        List<Player> topPlaters = playerService.getTopScorers(team);
        return new ResponseEntity<>(topPlaters, HttpStatus.OK);
    }

}
