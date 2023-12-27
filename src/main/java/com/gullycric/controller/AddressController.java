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

import com.gullycric.model.Address;
import com.gullycric.service.IAddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private IAddressService addressService;

	@PostMapping("/add")
	private ResponseEntity<String> addTeam(@RequestBody Address address) {
		Boolean isAdded = addressService.addAddress(address);
		if (isAdded) {
			return new ResponseEntity<String>("Address Saved Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Unable to Save Address!", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/addresses")
	private ResponseEntity<?> getAllTeams() {
		List<Address> addresses = addressService.getAllAddresses();
		if (addresses.size() != 0) {
			return new ResponseEntity<List<Address>>(addresses, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No Address Present in DB", HttpStatus.BAD_REQUEST);
	}
}
