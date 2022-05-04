package com.lgj.webapp.dto;

import lombok.Data;

@Data
public class UserShortResponse {
  private String userId;
  private String names;
  private String lastNames;
  private String photoUrl;
  private String phone;
  private String email;
}
