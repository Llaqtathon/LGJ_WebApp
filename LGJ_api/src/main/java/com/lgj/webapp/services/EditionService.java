package com.lgj.webapp.services;


import com.lgj.webapp.dto.EditionRequest;
import com.lgj.webapp.entities.Edition;
import com.lgj.webapp.entities.Group;
import com.lgj.webapp.exception.EditionNotFoundException;
import com.lgj.webapp.exception.GroupNotFoundException;
import com.lgj.webapp.repository.EditionRepository;
import com.lgj.webapp.repository.GroupRepository;
import org.springframework.stereotype.Service;

@Service
public class EditionService {

    private EditionRepository editionRepository;

    public EditionService(EditionRepository repository, GroupRepository groupRepository) {
        this.editionRepository = repository;
    }

    public Edition createEdition(EditionRequest editionRequest) {
        return editionRepository.save(new Edition(editionRequest));
    }

    public Edition addGroupToEdition(Long editionId, Group group) {
        return editionRepository.findById(editionId).map(edition -> {
            edition.addGroup(group);
            return editionRepository.save(edition);
        }).orElseThrow(() -> new EditionNotFoundException("Edition not found with id: " + editionId));
    }
}
