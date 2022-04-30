package com.lgj.webapp.services;

import com.lgj.webapp.entities.Group;
import com.lgj.webapp.entities.User;
import com.lgj.webapp.repository.GroupRepository;
import com.lgj.webapp.repository.UserRepository;
import com.lgj.webapp.dto.GroupRequest;
import com.lgj.webapp.exception.GroupNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
//import com.lgj.webapp.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

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

    public Group addUserToGroup(Long userId, Long groupId) {
        return groupRepository.findById(groupId).map(group -> {
            User user = userRepository.findById(userId)
                .orElseThrow(() -> new GroupNotFoundException("User not found with id: " + userId));
            group.addUser(user);
            return groupRepository.save(group);
        }).orElseThrow(() -> new GroupNotFoundException("Group not found with id: " + groupId));
    }
}
