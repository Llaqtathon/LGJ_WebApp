package com.lgj.webapp.services;

import com.lgj.webapp.dto.GameRequest;
import com.lgj.webapp.entities.Edition;
import com.lgj.webapp.entities.Game;
import com.lgj.webapp.entities.Group;
import com.lgj.webapp.entities.User;
import com.lgj.webapp.repository.GameRepository;
import com.lgj.webapp.repository.GroupRepository;
import com.lgj.webapp.repository.UserRepository;
import com.lgj.webapp.dto.GroupRequest;
import com.lgj.webapp.exception.GroupNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
//import com.lgj.webapp.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;
    private EditionService editionService;

    public GroupService(GroupRepository repository, EditionService editionService) {
        this.groupRepository = repository;
        this.editionService = editionService;
    }

    public Group createGroup(GroupRequest groupRequest) {
        Group group = new Group(groupRequest);
        Edition edition = editionService.addGroupToEdition(groupRequest.getEditionId(), group);
        group.addEdition(edition);

        if (groupRequest.getGame() != null) {
            group.setGame(new Game(groupRequest.getGame()));
        }

        return groupRepository.save(group);
    }

    public Group getById(Long groupId) {
        return groupRepository.findById(groupId)
                .orElseThrow(() -> new GroupNotFoundException("Game not found with id: " + groupId));
    }

    public Group addUserToGroup(Long groupId, Long userId) {
        return groupRepository.findById(groupId).map(group -> {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new GroupNotFoundException("User not found with id: " + userId));
            group.addUser(user);
            return groupRepository.save(group);
        }).orElseThrow(() -> new GroupNotFoundException("Group not found with id: " + groupId));
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public List<Group> findAllByEditionId(Long editionId) {
        return groupRepository.findAllByEditionId(editionId);
    }

    public List<Group> findAllEmptyGroupsByEditionId(Long editionId) {
        List<Group> groups = groupRepository.findAllByEditionId(editionId);
        return groups
                .stream()
                .filter(group -> group.getUsers().isEmpty())
                .collect(Collectors.toList());
    }

    public Group removeUserFromGroup(Long groupId, Long userId) {
        return groupRepository.findById(groupId)
                .map(group -> groupRepository.save(group.removeUser(userId)))
                .orElseThrow(() -> new GroupNotFoundException("Group not found with id: " + groupId));
    }

    public Group updateGame(Long groupId, GameRequest gameRequest) {
        return groupRepository.findById(groupId).map(group -> {
            gameRepository.delete(group.getGame());
            group.setGame(new Game(gameRequest));
            return groupRepository.save(group);
        }).orElseThrow(() -> new GroupNotFoundException("Group not found with id: " + groupId));
    }

    public String deleteGroup(Long groupId) {
        return groupRepository.findById(groupId).map(group -> {
            Group copy = group;
            groupRepository.delete(group);
            gameRepository.delete(copy.getGame());
            return "Deleted group: " + copy.getName();
        }).orElseThrow(() -> new GroupNotFoundException("Group not found with id: " + groupId));
    }

    public Group updateGroup(Long groupId, GroupRequest groupRequest) {
        return groupRepository.findById(groupId).map(group -> {
            group.setName(groupRequest.getName());
            group.setPhotoUrl(groupRequest.getPhotoUrl());
            return groupRepository.save(group);
        }).orElseThrow(() -> new GroupNotFoundException("Group not found with id: " + groupId));
    }

}
