package io.psilvab.footballbackend.service;

public interface PlayerService<ID, PLAYER> {
	
	PLAYER createPlayer(PLAYER player) throws Exception;
	PLAYER getPlayer(ID playerId) throws Exception;
	PLAYER updatePlayer(ID playerId,PLAYER player) throws Exception;
	void deletePlayer(ID playerId) throws Exception;

}
