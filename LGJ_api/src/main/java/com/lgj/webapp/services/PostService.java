package com.lgj.webapp.services;


import org.springframework.stereotype.Service;
import com.lgj.webapp.repository.PostsRepository;
import com.lgj.webapp.entities.Post;

import java.util.List;

@Service
public class PostService {
    private PostsRepository postsRepository;
    public PostService(PostsRepository repository){this.postsRepository=repository;}
    public Post createPost(Post post){return postsRepository.save(post);}
    public Post updatePost(Post post){return postsRepository.save(post);}
    public List<Post> getPostByUser(String username) { return postsRepository.findByUsername(username); }
}
