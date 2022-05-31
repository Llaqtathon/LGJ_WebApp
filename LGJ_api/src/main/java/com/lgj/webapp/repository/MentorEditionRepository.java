package com.lgj.webapp.repository;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lgj.webapp.entities.Mentor;
import com.lgj.webapp.entities.MentorAvailability;
import com.lgj.webapp.entities.MentorEdition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MentorEditionRepository extends JpaRepository<MentorEdition, Long> {
  
  MentorEdition getOneByMentorIdAndEditionId(Long mentorId, Long editionId);
  @JsonIgnore
  List<Mentor> findMentorByEditionId(Long editionId);
  // @JsonIgnore
  // List<MentorEdition> findByEditionId(Long editionId);
  String query_mentor_edition = "SELECT me.* FROM mentor_edition me where me.edition_id = ?1";
  @Query(value = query_mentor_edition, nativeQuery = true)
  List<MentorEdition> findByEditionId(Long editionId);
  @JsonIgnore
  List<MentorAvailability> findMentorAvailabilityByEditionId(Long editionId);
}