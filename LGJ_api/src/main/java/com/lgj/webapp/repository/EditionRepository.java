package com.lgj.webapp.repository;

import com.lgj.webapp.entities.Edition;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EditionRepository extends JpaRepository<Edition, Long> {
  
  Edition findById(String editionId);
  
}
