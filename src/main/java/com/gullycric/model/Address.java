package com.gullycric.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Address {
	@Id
	@GeneratedValue(generator = "addressIdGen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "addressIdGen", sequenceName = "addressIdGen", initialValue = 300, allocationSize = 1)
	private Integer addressId;
	
	@Nonnull
	private String country;
	
	@Nonnull
	private String state;
	
	@Nonnull
	private String city;
	
	@Nonnull
	private Integer pinCode;
	
	@OneToOne(mappedBy = "address")
	private Player player;
	
	@OneToOne(mappedBy = "address")
	private Coach coach;
	
	@OneToOne(mappedBy = "address")
	private Team team;
}