package com.lgj.webapp.controllers;
import java.util.List;

import com.lgj.webapp.entities.Sponsor;
import com.lgj.webapp.services.SponsorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/sponsor")
public class SponsorController {

    @Autowired
    private SponsorService sponsorService;

    public SponsorController(SponsorService sponsorService) {
        this.sponsorService=sponsorService; 
    }
    
    @GetMapping
    public ResponseEntity<List<Sponsor>> getAllSponsors(){
        List<Sponsor> sponsors = sponsorService.getAll();
        return new ResponseEntity<>(sponsors, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Sponsor> getSponsorById(@PathVariable Long id){
        Sponsor s = sponsorService.get(id);
        return s!=null ? ResponseEntity.ok(s) : new ResponseEntity<Sponsor>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/register")
    public ResponseEntity<Sponsor> saveSponsor(@RequestBody Sponsor sponsor){
        Sponsor s = sponsorService.save(sponsor);
        return s!=null && s.getId()!=null ? ResponseEntity.ok(s) : new ResponseEntity<Sponsor>(HttpStatus.NOT_MODIFIED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Sponsor> updateSponsor(@PathVariable Long id, @RequestBody Sponsor sponsor){
        if(id!=null && sponsor.getId()!=null){
            Sponsor s = sponsorService.save(sponsor);
            return s!=null && s.getId()!=null ? ResponseEntity.ok(s) : new ResponseEntity<Sponsor>(HttpStatus.NOT_MODIFIED);
        }else{
            return new ResponseEntity<Sponsor>(HttpStatus.NOT_MODIFIED);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSponsor(@PathVariable Long id){
        if(id!=null && sponsorService.get(id)!=null){
            sponsorService.delete(id);
            return ResponseEntity.ok("Sponsor Eliminado");
        }else{
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }
}

