package com.lgj.webapp.repository;

import com.lgj.webapp.entities.Mentor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
  
  Mentor findById(String mentorId);

  //TIMELINE
  //muestro: nombres, apellidos, areas, disponibilidad, status
  // String query_timeline = "select u.id, u.nombres, u.apellidos, a.name, "
  // + "me.status, mav.date_start, mav.date_end "
  // + "from mentor m join users u on m.mentor_id = u.id join"
  // + "mentor_area ma on m.mentor_id = ma.mentor_id join"
  // + "area a on ma.area_id = a.id join"
  // + "mentor_edition me on me.mentor_id = m.mentor_id join"
  // + "mentor_availability mav on m.mentor_id = mav.mentor_id"
  // + "where me.edition_id = ?1";
  // String query_mentor_edition = "select u.*, m.url_photo from mentor m"
  //                             + "join users u on m.mentor_id = u.id"
  //                             + "join mentor_edition me on m.mentor_id = me.mentor_id"
  //                             + "where me.edition_id = ?1";
  // @Query(value = query_mentor_edition, nativeQuery = true)
  // //siempre recibirá el id de la última edicion
  // List<Mentor> findMentorByEditionId(String editionId);
  // AHORA EN MENTOR EDITION

  // List<Mentor> findMentorByAreaId(String areaId);

  
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