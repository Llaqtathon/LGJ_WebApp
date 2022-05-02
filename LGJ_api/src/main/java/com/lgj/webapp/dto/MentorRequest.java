package com.lgj.webapp.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.lgj.webapp.entities.MentorArea;

import lombok.Data;
import java.time.LocalDate;

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
  private LocalDate birthdate;
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