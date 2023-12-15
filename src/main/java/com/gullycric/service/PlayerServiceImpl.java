package com.gullycric.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gullycric.model.Player;
import com.gullycric.repo.PlayerRepo;
@Service
public class PlayerServiceImpl implements IPlayerService {
	@Autowired
	private PlayerRepo playerRepo;

	@Override
	public Boolean addPlayer(Player player) {
		return playerRepo.save(player).getPlayerId() != null;
	}

}
