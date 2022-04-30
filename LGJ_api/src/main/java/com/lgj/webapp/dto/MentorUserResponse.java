package com.lgj.webapp.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MentorUserResponse {
  private String mentorId;
  private String names;
  private String lastNames;
  private String photoUrl;
  private String phone;
  private String email;
  private Date birthDate;
  private List<MentorAreaResponse> areas;
}
