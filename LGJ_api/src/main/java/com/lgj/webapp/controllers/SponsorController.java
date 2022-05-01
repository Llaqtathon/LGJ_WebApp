package com.lgj.webapp.controllers;
import com.lgj.webapp.entities.Sponsor;
import com.lgj.webapp.services.SponsorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sponsor")

public class SponsorController {
    private SponsorService sponsorService;

    public SponsorController(SponsorService sponsorService){ this.sponsorService=sponsorService;}

    @PostMapping
    public ResponseEntity<Sponsor> createEdition(@RequestBody Sponsor request){
        return new ResponseEntity<Sponsor>(sponsorService.createEdition(request), HttpStatus.CREATED);
    }
}
