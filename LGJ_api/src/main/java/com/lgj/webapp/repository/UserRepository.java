package com.lgj.webapp.repository;

import java.util.List;

import com.lgj.webapp.entities.User;
import com.lgj.webapp.util.RolSelection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findParticipantsByRol(RolSelection rol);
    
}
