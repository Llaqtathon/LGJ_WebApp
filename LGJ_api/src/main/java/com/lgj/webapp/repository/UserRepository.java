package com.lgj.webapp.repository;
import java.util.List;
import com.lgj.webapp.entities.Inscripcion;
import com.lgj.webapp.entities.User;

import com.lgj.webapp.util.RolSelection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findParticipantsByRol(RolSelection rol);
    User findByid(Long id);
}
