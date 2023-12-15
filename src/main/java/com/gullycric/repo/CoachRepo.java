package com.gullycric.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gullycric.model.Coach;

public interface CoachRepo extends JpaRepository<Coach, Integer> {

}
