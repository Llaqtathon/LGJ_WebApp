package com.lgj.webapp.repository;

import java.util.List;

import com.lgj.webapp.entities.Mentor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
  
  Mentor findById(String mentorId);

  String query_mentor = "select u.*, m.* from mentor m "
  + "join users u on m.mentor_id = u.id "
  + "where u.id = ?1";
  @Query(value = query_mentor, nativeQuery = true)
  Mentor getOne(Long id);

  String query_mentor_names = "select u.*, m.* from mentor m "
  + "join users u on m.mentor_id = u.id "
  + "where u.nombres like %:names% or u.apellidos like %:names%";
  @Query(value = query_mentor_names, nativeQuery = true)
  List<Mentor> findByNamesOrLastNames(@Param("names") String names);

  @Modifying
  @Query(value = "INSERT INTO mentor (url_photo, mentor_id) VALUES (:url_photo, :mentor_id)",
        nativeQuery = true)
  Integer saveOnlyMentor(@Param("url_photo") String urlPhoto, @Param("mentor_id") Long mentorId);

  //agregar horario de disponibilidad

  //editar horario de disponibilidad

  //eliminar horario de disponibilidad

  //editar status
  
  //dar rol de mentor a un usuario si USUARIO FUE MENTOR ANTES

  //dar rol de mentor a un usuario si USUARIO NO FUE MENTOR ANTES

}