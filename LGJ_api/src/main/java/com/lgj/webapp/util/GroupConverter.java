package com.lgj.webapp.util;

import com.lgj.webapp.dto.GroupResponse;
import com.lgj.webapp.entities.Group;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupConverter {

    private final ModelMapper modelMapper;

    public GroupConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public GroupResponse convertEntityToDto(Group group) {
        return modelMapper.map(group, GroupResponse.class);
    }

    public List<GroupResponse> convertEntityToDto(List<Group> groups) {
        return groups.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
}
