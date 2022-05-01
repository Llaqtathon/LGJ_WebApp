package com.lgj.webapp.repository;

import java.util.List;
import java.util.Optional;

import com.lgj.webapp.entities.Inscripcion;
import com.lgj.webapp.util.GeneralStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long>{
    
    @Query("SELECT i FROM Inscripcion i WHERE i.user.id = ?1")//jpql
    List<Inscripcion> findInscripcionsbyUserId(Long user_id);

    Inscripcion findByid(Long id);

    @Query("SELECT i FROM Inscripcion i WHERE i.user.id = :user_id AND i.status = :status")
    List<Inscripcion> findInscripcionsByuserIdAndStatus(Long user_id, GeneralStatus status);

}
