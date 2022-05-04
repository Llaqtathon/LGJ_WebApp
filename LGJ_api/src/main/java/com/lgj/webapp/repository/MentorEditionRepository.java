package com.lgj.webapp.repository;

import java.util.List;

import com.lgj.webapp.entities.Mentor;
import com.lgj.webapp.entities.MentorAvailability;
import com.lgj.webapp.entities.MentorEdition;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorEditionRepository extends JpaRepository<MentorEdition, Long> {
  
  MentorEdition getOneByMentorIdAndEditionId(Long mentorId, Long editionId);
  List<Mentor> findMentorByEditionId(Long editionId);
  List<MentorEdition> findByEditionId(Long editionId);
  List<MentorAvailability> findMentorAvailabilityByEditionId(Long editionId);
}