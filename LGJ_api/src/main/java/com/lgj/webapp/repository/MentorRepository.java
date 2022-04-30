package com.lgj.webapp.repository;

import java.util.List;

import com.lgj.webapp.entities.Mentor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
  
  Mentor findById(String mentorId);

  String query_mentor_names = "select u.*, m.url_photo from mentor m"
  + "join users u on m.mentor_id = u.id"
  + "where u.nombres like %:names% or u.apellidos like %:names%";
  @Query(value = query_mentor_names, nativeQuery = true)
  List<Mentor> findByNamesOrLastNames(@Param("names") String names);

  //crear mentor que no era participante:
  //nombres, apellidos, url_photo, areas
  //Defaults: status = en_consulta, rol = mentor, dni = 8x8,
  //telefono = si null 9x9, nacimiento = 1990/01/01 si null,
  //email = nombre@confirmar.com si null, username = combinacion nombre apellidos
  //password = actualizarLGJ, foto_perfil_url = null
  // Mentor findMentorByMentorId(String mentorId);

  //agregar horario de disponibilidad

  //editar horario de disponibilidad

  //eliminar horario de disponibilidad

  //editar status
  
  //dar rol de mentor a un usuario si USUARIO FUE MENTOR ANTES

  //dar rol de mentor a un usuario si USUARIO NO FUE MENTOR ANTES

}