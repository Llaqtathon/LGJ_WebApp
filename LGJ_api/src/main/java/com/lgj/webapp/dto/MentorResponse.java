package com.lgj.webapp.dto;

import java.util.List;

import lombok.Builder;

// import com.lgj.webapp.util.GeneralStatus;

import lombok.Data;

@Builder
@Data
public class MentorResponse {
  private Long mentorId;
  private String nombres;
  private String apellidos;
  private String urlPhoto;
  // private GeneralStatus status;
  List<MentorAreaResponse> areas;
  // List<MentorAvailabilityResponse> availabilities;
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
}
