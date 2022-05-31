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
  String query_mentor_edition = "SELECT u.nombres, u.apellidos, u.rol, u.username, "
    + "m.url_photo, e.name, e.date_start, e.date_end, "
    + "e.date_start_preproduction, e.date_end_postproduction, "
    + "ma.date_start, ma.date_end, me.* "
    + "FROM mentor_edition me "
    + "join mentor m on me.mentor_id = m.mentor_id "
    + "join edicion e on me.edition_id = e.id "
    + "join users u on m.mentor_id = u.id "
    + "join mentor_availability ma "
    + "on me.edition_id = ma.edition_id and me.mentor_id = ma.edition_id "
    +" where me.edition_id = ?1";
  @Query(value = query_mentor_edition, nativeQuery = true)
  List<MentorEdition> findByEditionId(Long editionId);
  @JsonIgnore
  List<MentorAvailability> findMentorAvailabilityByEditionId(Long editionId);
}