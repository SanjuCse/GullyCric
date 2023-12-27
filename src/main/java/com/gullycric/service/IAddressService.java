package com.gullycric.service;

import java.util.List;

import com.gullycric.model.Address;

public interface IAddressService {
	Boolean addAddress(Address address);

	List<Address> getAllAddresses();
}
