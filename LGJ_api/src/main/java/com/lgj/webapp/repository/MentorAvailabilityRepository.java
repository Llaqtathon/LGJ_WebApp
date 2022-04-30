package com.lgj.webapp.repository;

import java.util.List;

import com.lgj.webapp.entities.MentorAvailability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; 

public interface MentorAvailabilityRepository extends JpaRepository<MentorAvailability, Long> {
  
  String query_mentor_edition = "select * from mentor_availability ma where mentor_id = ?1 and edition_id = ?2";
  @Query(value = query_mentor_edition, nativeQuery = true)
  List<MentorAvailability> findByMentorIdAndEditionId(String mentorId, String editionId);

  MentorAvailability findById(String id);

}
  