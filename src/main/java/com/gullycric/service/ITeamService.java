package com.gullycric.service;

import java.util.List;

import com.gullycric.model.Team;

public interface ITeamService {
	Boolean addTeam(Team team);

	List<Team> getAllTeams();
}
