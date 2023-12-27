package com.gullycric.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gullycric.model.BattingType;
import com.gullycric.model.BowlingType;
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

	@Override
	public List<Player> getAllPlayers() {
		return playerRepo.findAll();
	}

	@Override
	public BattingType[] getBattingTypes() {
		return BattingType.values();
	}

	@Override
	public BowlingType[] getBowlingTypes() {
		return BowlingType.values();
	}
}
