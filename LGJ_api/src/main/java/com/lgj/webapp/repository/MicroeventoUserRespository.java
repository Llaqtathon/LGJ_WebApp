package com.lgj.webapp.repository;

import java.util.List;

import com.lgj.webapp.entities.UserMicroE;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MicroeventoUserRespository  extends JpaRepository<UserMicroE, Long> {
  List<UserMicroE> findByMicroeventoId(Long microEventoId);
  List<UserMicroE> findByUserId(Long userId);
  UserMicroE getOneByUserIdAndMicroeventoId(Long userId, Long microEventoId);
  // List<UserMicroE> findByUserIdAndEditionId(Long userId, Long editionId);
}
