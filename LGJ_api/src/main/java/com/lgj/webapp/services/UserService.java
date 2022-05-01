package com.lgj.webapp.services;

import com.lgj.webapp.entities.User;
import com.lgj.webapp.repository.UserRepository;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }
    
    
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllParticipantByRol(RolSelection rol) {
        return userRepository.findParticipantsByRol(rol);
    }
}
