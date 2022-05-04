package com.lgj.webapp.services;
import com.lgj.webapp.entities.Sponsor;
import com.lgj.webapp.repository.SponsorRepository;
import java.util.List;
import java.util.Optional;

public class SponsorService {
    private SponsorRepository sponsorRepository;

    public List<Sponsor> getAll(){
        return sponsorRepository.findAll();
    }
    public Sponsor get(Long id){
        Optional<Sponsor> s=sponsorRepository.findById(id);
        return s.isPresent() ? s.get() : null;
    }
    public Sponsor save(Sponsor sponsor){
        return sponsorRepository.save(sponsor);
    }
    public void delete(Long id){
        sponsorRepository.deleteById(id);
    }
}
