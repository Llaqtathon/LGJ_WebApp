package com.lgj.webapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lgj.webapp.entities.Role;
import com.lgj.webapp.util.RolSelection;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RolSelection name);
}
