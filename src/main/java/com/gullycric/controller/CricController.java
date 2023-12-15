package com.gullycric.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gullycric.service.ITeamService;

@Controller
public class CricController {
	@Autowired
	private ITeamService teamService;

	@GetMapping("/team")
	private String team(Map<String, Object> map) {
		map.put("teams", teamService.getAllTeams());
		return "team";
	}
}
