package com.lgj.webapp.controllers;

import java.util.List;

import com.lgj.webapp.entities.Highlight;
import com.lgj.webapp.services.HighlightService;

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

@RestController
@RequestMapping("/highlight")
public class HighlightController {
    @Autowired
    private HighlightService highlightService;
    public HighlightController(HighlightService highlightService) {
        this.highlightService = highlightService;
    }
    @GetMapping
    public ResponseEntity<List<Highlight>> getAllHighlights(){
        List<Highlight> highlights = highlightService.getAll();
        return new ResponseEntity<>(highlights, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Highlight> getHighlightById(@PathVariable Long id){
        Highlight s = highlightService.get(id);
        return s!=null ? ResponseEntity.ok(s) : new ResponseEntity<Highlight>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/register")
    public ResponseEntity<Highlight> saveHightlight(@RequestBody Highlight highlight){
        Highlight s = highlightService.save(highlight);
        return s!=null && s.getId()!=null ? ResponseEntity.ok(s) : new ResponseEntity<Highlight>(HttpStatus.NOT_MODIFIED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Highlight> updateHighlight(@PathVariable Long id, @RequestBody Highlight highlight){
        if(id!=null && highlight.getId()!=null){
            Highlight s = highlightService.save(highlight);
            return s!=null && s.getId()!=null ? ResponseEntity.ok(s) : new ResponseEntity<Highlight>(HttpStatus.NOT_MODIFIED);
        }else{
            return new ResponseEntity<Highlight>(HttpStatus.NOT_MODIFIED);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSponsor(@PathVariable Long id){
        if(id!=null && highlightService.get(id)!=null){
            highlightService.delete(id);
            return ResponseEntity.ok("Highlight Eliminado");
        }else{
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }
}

