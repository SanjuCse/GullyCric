package com.gullycric.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gullycric.model.Team;

public interface TeamRepo extends JpaRepository<Team, Integer> {

}
