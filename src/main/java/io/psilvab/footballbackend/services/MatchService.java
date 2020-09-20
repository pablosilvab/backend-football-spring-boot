package io.psilvab.footballbackend.services;

import org.springframework.http.ResponseEntity;

import io.psilvab.footballbackend.model.Match;

public interface MatchService {
    Match saveMatch(Match match);
    
}
