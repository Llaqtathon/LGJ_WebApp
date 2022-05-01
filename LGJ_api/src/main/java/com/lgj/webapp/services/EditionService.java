package com.lgj.webapp.services;


import com.lgj.webapp.entities.Edition;
import com.lgj.webapp.repository.EditionRepository;
import org.springframework.stereotype.Service;

@Service
public class EditionService {
    private EditionRepository editionRepository;

    public EditionService(EditionRepository repository){this.editionRepository=repository;}

    public Edition createEdition(Edition edition){return editionRepository.save(edition);}
}
