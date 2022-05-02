package com.lgj.webapp.repository;

import com.lgj.webapp.entities.Group;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findAllByEditionId(Long editionId);
}

