package com.lgj.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.lgj.webapp.entities.Post;
import com.lgj.webapp.services.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping
    public ResponseEntity<List<Post>> getAllHighlights(){
        List<Post> highlights = postService.getAll();
        return new ResponseEntity<>(highlights, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Post> getHighlightById(@PathVariable Long id){
        Post s = postService.get(id);
        return s!=null ? ResponseEntity.ok(s) : new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/register")
    public ResponseEntity<Post> saveHightlight(@RequestBody Post highlight){
        Post s = postService.save(highlight);
        return s!=null && s.getId()!=null ? ResponseEntity.ok(s) : new ResponseEntity<Post>(HttpStatus.NOT_MODIFIED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Post> updateHighlight(@PathVariable Long id, @RequestBody Post highlight){
        if(id!=null && highlight.getId()!=null){
            Post s = postService.save(highlight);
            return s!=null && s.getId()!=null ? ResponseEntity.ok(s) : new ResponseEntity<Post>(HttpStatus.NOT_MODIFIED);
        }else{
            return new ResponseEntity<Post>(HttpStatus.NOT_MODIFIED);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSponsor(@PathVariable Long id){
        if(id!=null && postService.get(id)!=null){
            postService.delete(id);
            return ResponseEntity.ok("Post Eliminado");
        }else{
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }
}
