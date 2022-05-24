package com.lgj.webapp.repository;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lgj.webapp.entities.Proyecto;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

}
