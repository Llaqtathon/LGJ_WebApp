package com.lgj.webapp.services;


import com.lgj.webapp.entities.Edition;
import com.lgj.webapp.entities.Group;
import com.lgj.webapp.entities.User;
import com.lgj.webapp.exception.EditionNotFoundException;
import com.lgj.webapp.exception.GroupNotFoundException;
import com.lgj.webapp.repository.EditionRepository;
import com.lgj.webapp.repository.GroupRepository;
import org.springframework.stereotype.Service;

@Service
public class EditionService {

    private final EditionRepository editionRepository;
    private final GroupRepository groupRepository;

    public EditionService(EditionRepository repository, GroupRepository groupRepository) {
        this.editionRepository = repository;
        this.groupRepository = groupRepository;
    }

    public Edition createEdition(Edition edition) {
        return editionRepository.save(edition);
    }

    public Edition addGroupToEdition(Long editionId, Long groupId) {
        return editionRepository.findById(editionId).map(edition -> {
            Group group = groupRepository.findById(groupId)
                    .orElseThrow(() -> new GroupNotFoundException("Group not found with id: " + groupId));
            edition.addGroup(group);
            return editionRepository.save(edition);
        }).orElseThrow(() -> new EditionNotFoundException("Edition not found with id: " + editionId));
    }
}
