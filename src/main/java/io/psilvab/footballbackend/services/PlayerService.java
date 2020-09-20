package io.psilvab.footballbackend.services;

import java.util.List;

import io.psilvab.footballbackend.model.Player;

public interface PlayerService {

    List<Player> getTopScorers(String team);
}
