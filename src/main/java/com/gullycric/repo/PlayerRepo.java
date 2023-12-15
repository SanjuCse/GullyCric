package com.gullycric.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gullycric.model.Player;

public interface PlayerRepo extends JpaRepository<Player, Integer>{

}