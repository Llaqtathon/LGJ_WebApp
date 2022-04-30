package com.lgj.webapp.repository;

import java.util.List;

import com.lgj.webapp.entities.Mentor;
import com.lgj.webapp.entities.MentorEdition;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorEditionRepository extends JpaRepository<MentorEdition, Long> {
  
  List<MentorEdition> findByMentorIdAndEditionId(String mentorId, String editionId);
  List<Mentor> findMentorByEditionId(String editionId);
}