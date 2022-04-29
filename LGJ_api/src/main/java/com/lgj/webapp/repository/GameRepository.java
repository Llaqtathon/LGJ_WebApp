package com.lgj.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.lgj.webapp.entities.Game; 

public interface GameRepository extends JpaRepository<Game, Long> {
    @Query("SELECT o FROM Order o WHERE o.accountId = ?1")//jpql
    List<Game> findGameByUserId(String accountId);

    List<Game> findGamesByPlatformsId(String accountId); // native query
    //List<Game> findGamesByPlatformIdNative(String accountId); // native query
    // Check documentation for more info
  
    Game findGameById(String gameId);
    
    @Query(value = "SELECT  * FROM orders o WHERE o.order_id = ?1", nativeQuery = true)//sql
    Game findGameByOrderIdNative(String gameId);
}

