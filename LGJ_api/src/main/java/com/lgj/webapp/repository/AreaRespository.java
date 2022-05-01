package com.lgj.webapp.repository;

import com.lgj.webapp.entities.Area;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRespository extends JpaRepository<Area, Integer> {
  
  Area findById(String areaId);
  Area getOne(Integer id);

}
