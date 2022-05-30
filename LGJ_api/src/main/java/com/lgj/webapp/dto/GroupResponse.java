package com.lgj.webapp.dto;

import lombok.Data;

import java.util.Set;

@Data
public class GroupResponse {
    private Long id;
    private String name;
    private String photoUrl;
    private GameRequest game;
    private Long editionId;
    Set<UserOrgShort> users;
}
