package com.gullycric.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gullycric.model.Religion;

@RestController
public class GeneralController {

	@GetMapping("/religions")
	private ResponseEntity<?> getAllReligion() {
		Religion[] religions = Religion.values();
		if (religions.length != 0) {
			return new ResponseEntity<Religion[]>(religions, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No Religions founfd in database", HttpStatus.BAD_REQUEST);
	}

}
