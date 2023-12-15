package com.gullycric.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gullycric.model.Address;
import com.gullycric.repo.AddressRepo;

@Service
public class AddressServiceImpl implements IAddressService {
	@Autowired
	private AddressRepo addressRepo;

	@Override
	public Boolean addAddress(Address address) {
		return addressRepo.save(address).getAddressId() != null;
	}

}
