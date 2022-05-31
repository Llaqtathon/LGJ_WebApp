package com.lgj.webapp.repository;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lgj.webapp.dto.UserShortResponse;

import com.lgj.webapp.entities.MicroEvento;
import com.lgj.webapp.util.GeneralStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MicroeventoRepository extends JpaRepository<MicroEvento, Long>{

    @Query("SELECT i FROM MicroEvento i WHERE i.status = :status")
    List<MicroEvento> findMicroEventoByStatus(GeneralStatus status);

  
  String queryMicroeventoAsignados = "select u.id, u.nombres, u.apellidos from microevento m "
    + "join user_microevento um on m.id = um.microevento_id "
    + "join users u on um.user_id = u.id "
    + "where um.responsable and u.rol = 'ORGANIZADOR' "
    + "and m.id = ?1";
  @Query(value = queryMicroeventoAsignados, nativeQuery = true)
  List<UserShortResponse> findAsignadosById(Long microEventoId);

  
  @JsonIgnore
  MicroEvento getOne(Long id);

  // List<MicroEvento> findByTipo(TipoMicroEvento tipo);

  // List<MicroEvento> findByStatus(GeneralStatus status);

  List<MicroEvento> findByEditionId(Long editionId);

}
