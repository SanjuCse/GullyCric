package com.gullycric.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gullycric.model.Team;
import com.gullycric.repo.TeamRepo;

@Service
public class TeamServiceImpl implements ITeamService {
	@Autowired
	private TeamRepo teamRepo;

	@Override
	public Boolean addTeam(Team team) {
		return teamRepo.save(team).getTeamId() != null;
	}

	@Override
	public List<Team> getAllTeams() {
		return teamRepo.findAll();
	}

}
