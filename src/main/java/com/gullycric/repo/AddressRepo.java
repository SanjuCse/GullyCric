package com.gullycric.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gullycric.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
