package com.lgj.webapp.repository;
import java.util.List;
// import java.util.Optional;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lgj.webapp.entities.User;

import com.lgj.webapp.util.RolSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findParticipantsByRol(RolSelection rol);

    String query_user_names = "select * from users u "
            + "where u.nombres like %:names% or u.apellidos like %:names%";
    @Query(value = query_user_names, nativeQuery = true)
    List<User> findByNamesOrLastNames(@Param("names") String names);

    User findByid(Long id);
    @JsonIgnore
    User getOne(Long id);
    Optional<User> findByUsername(String username);
}
