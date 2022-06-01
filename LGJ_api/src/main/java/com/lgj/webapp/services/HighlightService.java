package com.lgj.webapp.services;

import java.util.List;
import java.util.Optional;

import com.lgj.webapp.entities.Highlight;
import com.lgj.webapp.entities.Post;
import com.lgj.webapp.exception.HighlightNotFoundException;
import com.lgj.webapp.repository.HighlightRepository;

import org.springframework.stereotype.Service;
@Service
public class HighlightService {
    private HighlightRepository highlightRepository;
    public HighlightService(HighlightRepository highlightRepository) {
        this.highlightRepository = highlightRepository;
    }

    public List<Highlight> getAll(){
        return highlightRepository.findAll();
    }
    public Highlight get(Long id){
        Optional<Highlight> h=highlightRepository.findById(id);
        return h.isPresent() ? h.get():null;
    }
    public Highlight save(Highlight highlight){
        return highlightRepository.save(highlight);
    }
    public void delete(Long id){
        highlightRepository.deleteById(id);
    }

}