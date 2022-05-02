package com.lgj.webapp.services;

import com.lgj.webapp.dto.GameRequest;
import com.lgj.webapp.entities.Game;
import com.lgj.webapp.entities.Group;
import com.lgj.webapp.entities.User;
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

    public GroupService(GroupRepository repository) {
        this.groupRepository = repository;
    }

    public Group createGroup(GroupRequest groupRequest) {
        return groupRepository.save(new Group(groupRequest));
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
            group.setGame(new Game(gameRequest));
            return groupRepository.save(group);
        }).orElseThrow(() -> new GroupNotFoundException("Group not found with id: " + groupId));
    }
}
