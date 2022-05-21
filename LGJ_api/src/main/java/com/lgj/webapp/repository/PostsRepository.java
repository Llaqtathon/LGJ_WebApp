package com.lgj.webapp.repository;


import com.lgj.webapp.entities.Post;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PostsRepository extends JpaRepository<Post, Long>{
    
}
