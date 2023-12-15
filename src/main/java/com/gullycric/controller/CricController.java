package com.gullycric.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gullycric.model.Team;
import com.gullycric.service.ITeamService;

@Controller
public class CricController {
	@Autowired
	private ITeamService teamService;

	@GetMapping("/")
	private String team(Map<String, Object> map) {
		map.put("teams", teamService.getAllTeams());
		return "team";
	}

	@PostMapping("/")
	private String teamPost(@ModelAttribute Team team, Map<String, Object> map, RedirectAttributes attributes) {
		map.put("teams", teamService.getAllTeams());

		if (teamService.addTeam(team)) {
			attributes.addAttribute("success", "Team Added Successfully.");
		} else {
			attributes.addAttribute("failure", "Unable to add Team!");
		}
		
		return "/";
	}
}
