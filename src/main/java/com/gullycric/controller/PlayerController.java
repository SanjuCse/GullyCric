package com.gullycric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gullycric.model.BattingType;
import com.gullycric.model.BowlingType;
import com.gullycric.model.Player;
import com.gullycric.service.IPlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {
	@Autowired
	private IPlayerService playerService;

	@PostMapping("/add")
	private ResponseEntity<String> addTeam(@RequestBody Player player) {
		Boolean isAdded = playerService.addPlayer(player);
		if (isAdded) {
			return new ResponseEntity<String>("Player Saved Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Unable to Save Player!", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/players")
	private ResponseEntity<?> getAllTeams() {
		List<Player> players = playerService.getAllPlayers();
		if (players.size() != 0) {
			return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No Player Present in DB", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/batting/types")
	private ResponseEntity<?> getBattingTypes() {
		BattingType[] battingTypes = playerService.getBattingTypes();
		if (battingTypes.length != 0) {
			return new ResponseEntity<BattingType[]>(battingTypes, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No Batting Type Present in DB", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/bowling/types")
	private ResponseEntity<?> getCoachTypes() {
		BowlingType[] bowlingTypes = playerService.getBowlingTypes();
		if (bowlingTypes.length != 0) {
			return new ResponseEntity<BowlingType[]>(bowlingTypes, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No Bowling Type Present in DB", HttpStatus.BAD_REQUEST);
	}
}
