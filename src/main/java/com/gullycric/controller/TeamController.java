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

import com.gullycric.model.Team;
import com.gullycric.service.ITeamService;

@RestController
@RequestMapping("/team")
public class TeamController {
	@Autowired
	private ITeamService teamService;

	@PostMapping("/add")
	private ResponseEntity<String> addTeam(@RequestBody Team team) {
		Boolean isAdded = teamService.addTeam(team);
		if (isAdded) {
			return new ResponseEntity<String>("Team Saved Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Unable to Save Team!", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/teams")
	private ResponseEntity<?> getAllTeams() {
		List<Team> teams = teamService.getAllTeams();
		if (teams.size() != 0) {
			return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No Team Present in DB", HttpStatus.BAD_REQUEST);
	}
}
