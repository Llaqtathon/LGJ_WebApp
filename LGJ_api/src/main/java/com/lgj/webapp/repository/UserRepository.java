package com.lgj.webapp.repository;

import java.util.List;
// import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lgj.webapp.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
  String query_user_names = "select * from users u "
  + "where u.nombres like %:names% or u.apellidos like %:names%";
  @Query(value = query_user_names, nativeQuery = true)
  List<User> findByNamesOrLastNames(@Param("names") String names);
  
  User findById(String userId);
  @JsonIgnore
  User getOne(Long id);
}
