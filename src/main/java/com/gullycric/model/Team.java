package com.gullycric.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Team {
	@Id
	@GeneratedValue(generator = "teamIdGen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "teamIdGen", sequenceName = "teamIdGen", initialValue = 100, allocationSize = 1)
	private Integer teamId;

	private String name;

	private String owner;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "team", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Player> players;

	private Integer playerCount;

	private String sponsorship;

	private String history;

	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "playerId", referencedColumnName = "playerId")
	private Player captain;

	@JsonManagedReference
	@OneToMany(mappedBy = "team", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Coach> coachs;

	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId", referencedColumnName = "addressId")
	private Address address;

	private LocalDate formationDate;
}
