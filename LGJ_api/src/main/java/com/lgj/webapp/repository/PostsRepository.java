package com.lgj.webapp.repository;
import java.util.List;

import com.lgj.webapp.entities.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostsRepository extends JpaRepository<Post, Long>{
    String query_posts_usernames = " select * from posts p "
        + "where p.username like %:username% ";
    @Query(value = query_posts_usernames, nativeQuery = true)
    List<Post> findByUsername(@Param("username") String username);
}
