package com.lgj.webapp.repository;

import java.util.Date;

import com.lgj.webapp.entities.Edition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EditionRepository extends JpaRepository<Edition, Long> {
  
  Edition findById(String editionId);
  Edition getOne(Long id);

  String query_current_event = "select * from edicion e"
  + "where e.date_start_preproduction < ?1"
  + "and e.date_end_postproduction is null or e.date_end_postproduction > ?1";
  // format 2012-01-12
  @Query(value = query_current_event, nativeQuery = true)
  Edition findCurrentEvent(Date date);

}
