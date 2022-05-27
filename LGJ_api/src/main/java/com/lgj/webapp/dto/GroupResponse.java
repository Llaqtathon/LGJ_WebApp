package com.lgj.webapp.dto;

import com.lgj.webapp.entities.Game;
import lombok.Data;

import java.util.Set;

@Data
public class GroupResponse {
    private Long id;
    private String name;
    private String photoUrl;
    private Game game;
    Set<UserOrgShort> users;
}
