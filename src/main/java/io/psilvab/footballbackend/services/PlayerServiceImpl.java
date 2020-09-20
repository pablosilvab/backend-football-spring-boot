package io.psilvab.footballbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.psilvab.footballbackend.model.Player;
import io.psilvab.footballbackend.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public List<Player> getTopScorers(String team) {
        List<Player> topScorers = playerRepository.findByTeam(team, Sort.by("goals").descending());
        // Sort.by("goals").descending()
        return topScorers;
    }
    
}
