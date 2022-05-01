package com.lgj.webapp.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.lgj.webapp.entities.MentorArea;

import lombok.Data;

@Data
public class MentorRequest {
  @NotBlank
  @NotNull
  private String nombres;
  @NotBlank
  @NotNull
  private String apellidos;
  private String urlPhoto;
  private String phone;
  private String email;
  private Date birthdate;
  // @NotNull
  // List<MentorAreaResponse> areas;
  private List<MentorArea> areas;
}


// @Data
// public class OrderRequest {
//   @NotBlank
//   @NotNull
//   private String accountId;
//   @NotNull
//   private List<LineItem> items;

// }