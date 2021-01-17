package io.psilvab.footballbackend.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.psilvab.footballbackend.model.Player;
import io.psilvab.footballbackend.service.PlayerServiceImpl;

@RestController
@RequestMapping("/api")
public class PlayerController {

	Logger LOG = LoggerFactory.getLogger(PlayerController.class);

	@Autowired
	private PlayerServiceImpl playerServiceImpl;

	@PostMapping("/players")
	public ResponseEntity addPlayer(@RequestBody Player player) throws Exception {
		HashMap<String, Object> resp = new HashMap<>();
		playerServiceImpl.createPlayer(player);
		resp.put("player", player);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@GetMapping("/players/{id}")
	public ResponseEntity getPlayerById(@PathVariable String id) throws Exception {
		try {
			Player player = playerServiceImpl.getPlayer(id);
			if (player != null) {
				return new ResponseEntity<>(player, HttpStatus.OK);		
			} else {
				return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);	
			}
		} catch (Exception e) {
			LOG.error(e.toString());
			return new ResponseEntity<>("Error inesperado", HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}

	@GetMapping("/players")
	public ResponseEntity getAllPlayers() throws Exception {
		List<Player> players = playerServiceImpl.getAllPlayers();
		return new ResponseEntity<>(players, HttpStatus.OK);
	}

	@PutMapping(path = "/players/{id}")
	public ResponseEntity updatePlayer(@PathVariable String id, @RequestBody Player player) throws Exception {
		HashMap<String, Object> resp = new HashMap<>();
		Player playerUpdate = playerServiceImpl.updatePlayer(id, player);
		resp.put("player", playerUpdate);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	@DeleteMapping("/players/{id}")
	public ResponseEntity deletePlayer(@PathVariable String id) throws Exception {
		playerServiceImpl.deletePlayer(id);
	    HashMap<String,String> resp = new HashMap<>();
	    resp.put("message", "Player is successfully deleted");
	    return new ResponseEntity<>(resp, HttpStatus.OK);
	}

}
