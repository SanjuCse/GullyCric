package com.gullycric.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
import lombok.Data;

@Entity
@Data
public class Coach {
	@Id
	@GeneratedValue(generator = "coachIdGen", strategy = GenerationType.SEQUENCE)
	private Integer coachId;

	@Enumerated(EnumType.STRING)
	private CoachType coachType;

	private String name;
	
	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	private LocalDate dob;

	private Double height;
	
//	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH })
//	@JoinColumn(name = "teamId") //, nullable = false , , referencedColumnName = "coachs"
//	private Team team;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL) //{ CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH }
	@JoinColumn(name = "teamId") //, nullable = false
	private Team team;
	
	@Enumerated(EnumType.STRING)
	private Religion religion;
}