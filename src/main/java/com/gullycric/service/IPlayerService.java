package com.gullycric.service;

import java.util.List;

import com.gullycric.model.BattingType;
import com.gullycric.model.BowlingType;
import com.gullycric.model.Player;

public interface IPlayerService {
	Boolean addPlayer(Player player);

	List<Player> getAllPlayers();

	BattingType[] getBattingTypes();

	BowlingType[] getBowlingTypes();
}
