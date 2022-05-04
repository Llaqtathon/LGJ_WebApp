package com.lgj.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.lgj.webapp.entities.Game; 

public interface GameRepository extends JpaRepository<Game, Long> {
    /*Query for getting all games by user id, user is in a group and the group has a game
    @Query("""
        SELECT g
        FROM Game g
        WHERE g.group.id = ?1
        ORDER BY g.name
    """)//jpql
    List<Game> findGameByUserId(String accountId);*/

    List<Game> findGamesByPlatformsId(String accountId); 
    // Check documentation for more info
  
    Game findGameById(String gameId);
}

