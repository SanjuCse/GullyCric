package com.gullycric.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Player {
	@Id
	@GeneratedValue(generator = "playerIdGen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "playerIdGen", sequenceName = "playerIdGen", initialValue = 200, allocationSize = 1)
	private Integer playerId;

	private String name;

	private String nickName;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	private LocalDate dob;

	private Double height;

	@Enumerated(EnumType.STRING)
	private BattingType battingType;

	@Enumerated(EnumType.STRING)
	private BowlingType bowlingType;
	
	@Enumerated(EnumType.STRING)
	private Religion religion;
	
	private Boolean isCaptain = false;
	
	@ManyToOne(cascade = CascadeType.ALL) //{ CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH }
	@JoinColumn(name = "teamId") //, nullable = false
	private Team team;
}