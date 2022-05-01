package com.lgj.webapp.services;

import org.springframework.stereotype.Service;
import com.lgj.webapp.repository.PostsRepository;
import com.lgj.webapp.entities.Publicacion;

@Service
public class PostService {
    private PostsRepository postsRepository;
    public PostService(PostsRepository repository){this.postsRepository=repository;}
    public Post createPost(Post post){return postsRepository.save(post);}
}
