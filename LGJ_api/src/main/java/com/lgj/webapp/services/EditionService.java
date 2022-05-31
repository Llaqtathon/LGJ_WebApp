package com.lgj.webapp.services;


import com.lgj.webapp.dto.EditionRequest;
import com.lgj.webapp.entities.Edition;
import com.lgj.webapp.entities.Game;
import com.lgj.webapp.entities.Group;
import com.lgj.webapp.exception.EditionNotFoundException;
import com.lgj.webapp.repository.EditionRepository;
import com.lgj.webapp.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditionService {

    private EditionRepository editionRepository;
    private GroupRepository groupRepository;

    public EditionService(EditionRepository repository, GroupRepository groupRepository) {
        this.editionRepository = repository;
        this.groupRepository = groupRepository;
    }

    public Edition createEdition(EditionRequest editionRequest) {
        return editionRepository.save(new Edition(editionRequest));
    }
    // public Edition updateEdition(Long id, EditionRequest editionRequest) {
    //     Edition edition = editionRepository.getOne(id);
    //     edition.builder()
    //             .name(editionRequest.getName())
    //             .description(editionRequest.getDescription())
    //             .dateStart(editionRequest.getDateStart())
    //             .dateEnd(editionRequest.getDateEnd())
    //             .description(editionRequest.getDescription())
    //             .location(editionRequest.getLocation())
    //             .locationUrlGmaps(editionRequest.getLocationUrlGmaps())
    //             .theme(editionRequest.getTheme())
    //             .build();
    //     return editionRepository.save(edition);
    // }

    public Edition closeEdition(Long id) {
        Edition edition = editionRepository.getOne(id);
        edition.setDateEndPostproduction(new Date());
        edition.setIsActive(false);
        return editionRepository.save(edition);
    }
    // mentorEdition.setStatus(request.getStatus());
    // return mentorEditionRepository.save(mentorEdition);

    public Edition addGroupToEdition(Long editionId, Group group) {
        return editionRepository.findById(editionId).map(edition -> {
            edition.addGroup(group);
            return editionRepository.save(edition);
        }).orElseThrow(() -> new EditionNotFoundException("Edition not found with id: " + editionId));
    }
    
    public List<Edition> getAll() {
        return editionRepository.findAll();
    }

    public List<Edition> getAllActive() {
        return editionRepository.findByIsActive(true);
    }

    public List<Game> findAllGamesByEditionId(Long editionId) {
        List<Group> groups = groupRepository.findAllByEditionId(editionId);
        
        return groups.stream()
                .map(group -> group.getGame())
                .filter(game -> game != null)
                .collect(Collectors.toList());
    }
}
