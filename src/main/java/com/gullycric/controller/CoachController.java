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

import com.gullycric.model.Coach;
import com.gullycric.model.CoachType;
import com.gullycric.service.ICoachService;

@RestController
@RequestMapping("/coach")
public class CoachController {
	@Autowired
	private ICoachService coachService;

	@PostMapping("/add")
	private ResponseEntity<String> addCoach(@RequestBody Coach coach) {
		Boolean isAdded = coachService.addCoach(coach);
		if (isAdded) {
			return new ResponseEntity<String>("Coach Saved Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Unable to Save Coach!", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/coaches")
	private ResponseEntity<?> getAllCoaches() {
		List<Coach> coaches = coachService.getAllCoaches();
		if (coaches.size() != 0) {
			return new ResponseEntity<List<Coach>>(coaches, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No Coach Present in DB", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/types")
	private ResponseEntity<?> getCoachTypes() {
		CoachType[] coachTypes = coachService.getCoachTypes();
		if (coachTypes.length != 0) {
			return new ResponseEntity<CoachType[]>(coachTypes, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No Coach Type Present in DB", HttpStatus.BAD_REQUEST);
	}
}
