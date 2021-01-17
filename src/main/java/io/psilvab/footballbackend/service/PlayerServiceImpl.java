package io.psilvab.footballbackend.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.psilvab.footballbackend.model.Player;
import io.psilvab.footballbackend.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService<String, Player> {

	Logger LOG = LoggerFactory.getLogger(PlayerServiceImpl.class);

	@Autowired
	PlayerRepository playerRepository;

	@Override
	public Player createPlayer(Player player) throws Exception {
		player = playerRepository.save(player);
		return player;
	}

	@Override
	public Player getPlayer(String playerId) throws Exception {
		Optional<Player> player = playerRepository.findById(playerId);
		if (player.isPresent()) {
			return player.get();	
		} else {
			return null;
		}
	}

	@Override
	public Player updatePlayer(String id, Player player) throws Exception {
		Optional<Player> playerDB = playerRepository.findById(id);
		if (playerDB.isPresent()) {
			Player toReturn = playerDB.get();
			toReturn.setName(player.getName());
			toReturn.setTeam(player.getTeam());
			playerRepository.save(toReturn);
			return toReturn;
		} else {
			throw new Exception("player not exists");
		}
	}

	@Override
	public void deletePlayer(String playerId) throws Exception {
		if (playerId == null) {
			throw new Exception("player id null");
		} else {
			playerRepository.deleteById(playerId);
		}
	}

	public List<Player> getAllPlayers() throws Exception {
		List<Player> players = playerRepository.findAll();
		return players;
	}

}
