package com.lgj.webapp.services;
import com.lgj.webapp.controllers.SponsorController;
import com.lgj.webapp.entities.Sponsor;
import com.lgj.webapp.repository.SponsorRepository;
import org.springframework.stereotype.Service;
@Service
public class SponsorService {
    private SponsorRepository sponsorRepository;
    public SponsorService(SponsorRepository repository){this.sponsorRepository=repository;}
    public Sponsor createSponsor(Sponsor sponsor){return sponsorRepository.save(sponsor);}
}
