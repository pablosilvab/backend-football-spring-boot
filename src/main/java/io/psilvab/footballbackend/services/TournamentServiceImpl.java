package io.psilvab.footballbackend.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.psilvab.footballbackend.model.Tournament;
import io.psilvab.footballbackend.repository.TournamentRepository;

@Service
public class TournamentServiceImpl implements TournamentService {

    Logger LOG = LoggerFactory.getLogger(TournamentServiceImpl.class);

    @Autowired
    TournamentRepository tournamentRepository;

    @Override
    public Tournament tournamentExist(String idTournament) {
        LOG.info("ID Tournament: {}", idTournament);
        Optional<Tournament> tournament = tournamentRepository.findById(idTournament);
        return tournament.isPresent() ? tournament.get() : null;
    }

}
