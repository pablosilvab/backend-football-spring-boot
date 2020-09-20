package io.psilvab.footballbackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.psilvab.footballbackend.model.Match;
import io.psilvab.footballbackend.model.Player;
import io.psilvab.footballbackend.model.Team;
import io.psilvab.footballbackend.repository.MatchRepository;
import io.psilvab.footballbackend.repository.PlayerRepository;
import io.psilvab.footballbackend.repository.TeamRepository;

@Service
public class MatchServiceImpl implements MatchService {

    Logger LOG = LoggerFactory.getLogger(MatchServiceImpl.class);

    private static final int NEW_GOAL = 1;

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    @Override
    public Match saveMatch(final Match match) {

        // Optional<Team> teamLocal =
        // teamRepository.findById(match.getTeamLocal().getId());
        // Optional<Team> teamVisit =
        // teamRepository.findById(match.getTeamVisit().getId());

        final List<String> playersLocal = match.getScorersLocal();
        saveMatchGoals(playersLocal, match.getTeamLocal().getName());

        final List<String> playersVisit = match.getScorersVisit();
        saveMatchGoals(playersVisit, match.getTeamVisit().getName());

        final Match newMatch = matchRepository.save(match);
        return newMatch;
    }

    private void saveMatchGoals(final List<String> players, final String team) {
        players.forEach(playerName -> {
            final Optional<Player> playerData = playerRepository.findByName(playerName);
            if (!playerData.isPresent()) {
                final Player newPlayer = new Player();
                newPlayer.setName(playerName);
                newPlayer.setTeam(team);
                newPlayer.setGoals(NEW_GOAL);
                playerRepository.save(newPlayer);
            } else {
                final int goalsPlayerData = playerData.get().getGoals();
                playerData.get().setGoals(goalsPlayerData + NEW_GOAL);
                playerRepository.save(playerData.get());
            }
        });
    }

    @Override
    public Match getMatch(final String idMatch) {
        final Match match = matchRepository.findById(idMatch).get();
        final Team teamLocal = teamRepository.findByIdAndExcludeTournament(match.getTeamLocal().getId());
        match.setTeamLocal(teamLocal);
        final Team teamVisit = teamRepository.findByIdAndExcludeTournament(match.getTeamVisit().getId());
        match.setTeamVisit(teamVisit);
        return match;
    }

    @Override
    public List<Match> getMatchesByTeam(final String idTeam) {
        LOG.info("ID Team: {}", idTeam);
        List<Match> matches = new ArrayList<Match>();
        matches = matchRepository.findByTeam(idTeam);
        for (Match match : matches) {
            match = getTeamsDetail(match);
        }
        return matches;
    }

    private Match getTeamsDetail(final Match match) {
        final Team teamLocal = teamRepository.findByIdAndExcludeTournament(match.getTeamLocal().getId());
        final Team teamVisit = teamRepository.findByIdAndExcludeTournament(match.getTeamVisit().getId());
        match.setTeamLocal(teamLocal);
        match.setTeamVisit(teamVisit);
        return match;

    }

}
