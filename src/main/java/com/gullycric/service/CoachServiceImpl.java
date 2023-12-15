package com.gullycric.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gullycric.model.Coach;
import com.gullycric.repo.CoachRepo;

@Service
public class CoachServiceImpl implements ICoachService {
	@Autowired
	private CoachRepo coachRepo;

	@Override
	public Boolean addCoach(Coach coach) {
		return coachRepo.save(coach).getCoachId() != null;
	}

}
