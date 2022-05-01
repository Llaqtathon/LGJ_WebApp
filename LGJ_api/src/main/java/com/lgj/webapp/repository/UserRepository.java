package com.lgj.webapp.repository;

import com.lgj.webapp.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findParticipantsByRol(RolSelection rol);

}
