package com.gullycric.service;

import java.util.List;

import com.gullycric.model.Coach;
import com.gullycric.model.CoachType;

public interface ICoachService {
	Boolean addCoach(Coach coach);

	List<Coach> getAllCoaches();

	CoachType[] getCoachTypes();
}
