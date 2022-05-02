package com.lgj.webapp.repository;

import java.util.List;

import com.lgj.webapp.entities.MicroEvento;
import com.lgj.webapp.util.GeneralStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MicroeventoRepository extends JpaRepository<MicroEvento, Long>{
    @Query("SELECT i FROM MicroEvento i WHERE i.status = :status")
    List<MicroEvento> findMicroEventoByStatus(GeneralStatus status);
}
