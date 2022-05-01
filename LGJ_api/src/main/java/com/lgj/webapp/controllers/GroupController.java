package com.lgj.webapp.controllers;

import java.util.List;

import com.lgj.webapp.dto.GroupRequest;
import com.lgj.webapp.entities.Group;
import com.lgj.webapp.services.GroupService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {
    //Get groups by user 
    // Get groups by event
    // Get only empty groups
     
    
private final GroupService groupService;
    /*
 @GetMapping
  public ResponseEntity<List<Group> findAllGroups() {
    List<Group> groups = groupService.getAll();
    return new ResponseEntity<>(groups, HttpStatus.OK);
  }*/
  
  @GetMapping("/{groupId}")
  public ResponseEntity<Group> findGroupById(@PathVariable Long groupId) {
    Group group = groupService.getById(groupId);
    return new ResponseEntity<>(group, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Group> createGroup(@RequestBody GroupRequest request) {
    Group group = groupService.createGroup(request);
    return new ResponseEntity<>(group, HttpStatus.CREATED);
  }

  @PostMapping("/{groupId}/join/{userId}")
  public ResponseEntity<Group> addUser(@PathVariable Long groupId, @PathVariable Long userId) {
    Group group = groupService.addUserToGroup(groupId, userId);
    return new ResponseEntity<>(group, HttpStatus.CREATED);
  }
}