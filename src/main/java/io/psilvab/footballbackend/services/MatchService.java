package io.psilvab.footballbackend.services;

import java.util.List;

import io.psilvab.footballbackend.model.Match;

public interface MatchService {
    Match saveMatch(Match match);
    Match getMatch(String idMatch);
	List<Match> getMatchesByTeam(String idTeam);
    
}
