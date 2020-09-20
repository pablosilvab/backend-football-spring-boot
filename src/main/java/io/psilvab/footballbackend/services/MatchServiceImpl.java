package io.psilvab.footballbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.psilvab.footballbackend.model.Match;
import io.psilvab.footballbackend.model.Player;
import io.psilvab.footballbackend.repository.MatchRepository;
import io.psilvab.footballbackend.repository.PlayerRepository;

@Service
public class MatchServiceImpl implements MatchService {

    private static final int NEW_GOAL = 1;

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Match saveMatch(Match match) {

        List<String> playersLocal = match.getScorersLocal();
        saveMatchGoals(playersLocal, match.getTeamLocal());
        
        List<String> playersVisit = match.getScorersVisit();
        saveMatchGoals(playersVisit, match.getTeamVisit());
        

        Match newMatch = matchRepository.save(match);
 

        return newMatch;
    }

    private void saveMatchGoals(List<String> players, String team) {
        players.forEach(playerName -> {
            Optional<Player> playerData = playerRepository.findByName(playerName);
            if (!playerData.isPresent()) {
                Player newPlayer = new Player();
                newPlayer.setName(playerName);
                newPlayer.setTeam(team);
                newPlayer.setGoals(NEW_GOAL);
                playerRepository.save(newPlayer);
            } else {
                int goalsPlayerData = playerData.get().getGoals();
                playerData.get().setGoals(goalsPlayerData + NEW_GOAL);
                playerRepository.save(playerData.get());
            }
        });

    }

}
