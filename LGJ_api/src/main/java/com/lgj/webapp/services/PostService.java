package com.lgj.webapp.services;


import org.springframework.stereotype.Service;
import com.lgj.webapp.repository.PostsRepository;
import com.lgj.webapp.entities.Post;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostsRepository postsRepository;
    public PostService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public List<Post> getAll(){
        return postsRepository.findAll();
    }
    public Post get(Long id){
        Optional<Post> p = postsRepository.findById(id);
        return p.isPresent() ? p.get() :null;
    }
    public Post save(Post post){
        return postsRepository.save(post);
    }
    public void delete(Long id){
        postsRepository.deleteById(id);
    }
}
