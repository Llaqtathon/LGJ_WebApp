package com.lgj.webapp.controllers;

import java.util.List;

import com.lgj.webapp.dto.GameRequest;

import com.lgj.webapp.dto.GroupRequest;
import com.lgj.webapp.dto.GroupResponse;
import com.lgj.webapp.entities.Group;
import com.lgj.webapp.services.GroupService;

import com.lgj.webapp.util.GroupConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

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
    private final GroupConverter groupConverter;

    @GetMapping
    public ResponseEntity<List<GroupResponse>> findAllGroups() {
        List<Group> groups = groupService.findAll();
        return new ResponseEntity<>(groupConverter.convertEntityToDto(groups), HttpStatus.OK);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<GroupResponse> findGroupById(@PathVariable Long groupId) {
        Group group = groupService.getById(groupId);
        return new ResponseEntity<>(groupConverter.convertEntityToDto(group), HttpStatus.OK);
    }

    @GetMapping("edition/{editionId}")
    public ResponseEntity<List<GroupResponse>> findAllGroupsByEditionId(@PathVariable Long editionId) {
        List<Group> groups = groupService.findAllByEditionId(editionId);
        return new ResponseEntity<>(groupConverter.convertEntityToDto(groups), HttpStatus.OK);
    }

    @GetMapping("edition/{editionId}/empty")
    public ResponseEntity<List<GroupResponse>> findAllEmptyGroupsByEditionId(@PathVariable Long editionId) {
        List<Group> groups = groupService.findAllEmptyGroupsByEditionId(editionId);
        return new ResponseEntity<>(groupConverter.convertEntityToDto(groups), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GroupResponse> createGroup(@RequestBody GroupRequest request) {
        Group group = groupService.createGroup(request);
        return new ResponseEntity<>(groupConverter.convertEntityToDto(group), HttpStatus.CREATED);
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<GroupResponse> updateGroup(@PathVariable Long groupId, @RequestBody GroupRequest request) {
        Group group = groupService.updateGroup(groupId, request);
        return new ResponseEntity<>(groupConverter.convertEntityToDto(group), HttpStatus.OK);
    }

    @PatchMapping("/{groupId}/join/{userId}")
    public ResponseEntity<GroupResponse> addUser(@PathVariable Long groupId, @PathVariable Long userId) {
        Group group = groupService.addUserToGroup(groupId, userId);
        return new ResponseEntity<>(groupConverter.convertEntityToDto(group), HttpStatus.CREATED);
    }

    @PatchMapping("/{groupId}/game")
    public ResponseEntity<GroupResponse> updateGame(@PathVariable Long groupId, @RequestBody GameRequest gameRequest) {
        Group group = groupService.updateGame(groupId, gameRequest);
        return new ResponseEntity<>(groupConverter.convertEntityToDto(group), HttpStatus.CREATED);
    }

    @PatchMapping("/{groupId}/leave/{userId}")
    public ResponseEntity<GroupResponse> removeUser(@PathVariable Long groupId, @PathVariable Long userId) {
        Group group = groupService.removeUserFromGroup(groupId, userId);
        return new ResponseEntity<>(groupConverter.convertEntityToDto(group), HttpStatus.CREATED);
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<String> deleteGroup(@PathVariable Long groupId) {
        groupService.deleteGroup(groupId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}