package com.lgj.webapp.repository;

import java.util.List;

import com.lgj.webapp.dto.UserShortResponse;
import com.lgj.webapp.entities.MicroEvento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MicroeventoRepository extends JpaRepository<MicroEvento, Long>{
  
  String queryMicroeventoAsignados = "select u.id, u.nombres, u.apellidos from microevento m"
    + "join user_microevento um on m.id = um.microevento_id"
    + "join users u on um.user_id = u.id"
    + "where um.responsable and u.rol = 'ORGANIZADOR'"
    + "and m.id = ?1";
  @Query(value = queryMicroeventoAsignados, nativeQuery = true)
  List<UserShortResponse> findAsignadosById(Long microEventoId);

  MicroEvento getOne(Long id);
}
