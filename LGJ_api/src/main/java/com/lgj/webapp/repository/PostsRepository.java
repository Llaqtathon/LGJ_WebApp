package com.lgj.webapp.repository;

import com.lgj.webapp.entities.Publicacion;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PostsRepository extends JpaRepository<Publicacion, Long>{
}
