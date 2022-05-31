package com.lgj.webapp.services;
import java.util.List;

// import com.lgj.webapp.entities.Inscripcion;
import com.lgj.webapp.entities.User;
import com.lgj.webapp.repository.UserRepository;
import com.lgj.webapp.util.RolSelection;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }
  
    public User findById(Long id) {
        return userRepository.findByid(id);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User updateUser(User user){
        return userRepository.save(user);
    }
    public List<User> getParticipantsByRol(RolSelection rol) {
        return userRepository.findParticipantsByRol(rol);
    }
    @Transactional(readOnly = true)
    public List<User> findByPartOfFullName(String text) {
      List<User> users = userRepository.findByNamesOrLastNames(text);
      return users;
    }
}
