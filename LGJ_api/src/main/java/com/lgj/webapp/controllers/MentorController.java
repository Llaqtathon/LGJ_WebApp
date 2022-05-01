package com.lgj.webapp.controllers;

import java.text.ParseException;
import java.util.List;

import com.lgj.webapp.dto.MentorAreaRequest;
import com.lgj.webapp.dto.MentorAreaResponse;
import com.lgj.webapp.dto.MentorAvailabilitiesRequest;
import com.lgj.webapp.dto.MentorAvailabilityResponse;
import com.lgj.webapp.dto.MentorEditionRequest;
import com.lgj.webapp.dto.MentorEditionResponse;
import com.lgj.webapp.dto.MentorRequest;
import com.lgj.webapp.dto.MentorResponse;
import com.lgj.webapp.entities.Mentor;
import com.lgj.webapp.entities.MentorArea;
import com.lgj.webapp.entities.MentorAvailability;
import com.lgj.webapp.entities.MentorEdition;
import com.lgj.webapp.services.MentorService;
import com.lgj.webapp.util.EntityDtoConverter;

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
@RequestMapping("/mentors")
public class MentorController {
  private MentorService mentorService;
  private EntityDtoConverter converter;

  public MentorController(MentorService mentorService, EntityDtoConverter converter) {
    this.mentorService = mentorService;
    this.converter = converter;
  }
  
  @PostMapping
  public ResponseEntity<MentorResponse> createMentor(@RequestBody Mentor request) throws ParseException {
    Mentor mentor = mentorService.createMentor(request);
    return new ResponseEntity<>(converter.convertMentorToDto(mentor), HttpStatus.CREATED);
  }
  @GetMapping("/{mentorId}")
  public ResponseEntity<MentorResponse> findMentorById(@PathVariable String mentorId) {
    Long mid = Long.parseLong(mentorId);
    Mentor mentor = mentorService.getMentorById(mid);
    return new ResponseEntity<>(converter.convertMentorToDto(mentor), HttpStatus.OK);
  }
  @PutMapping("/{mentorId}")
  public ResponseEntity<MentorResponse> updateMentor(@RequestBody MentorRequest request, @PathVariable String mentorId) {
    Mentor mentor = mentorService.updateMentor(Long.parseLong(mentorId), request);
    return new ResponseEntity<>(converter.convertMentorToDto(mentor), HttpStatus.OK);
  }
  @GetMapping("/{editionId}/{mentorId}")
  public ResponseEntity<MentorEditionResponse> findMentorByIdAndEditionId(
    @PathVariable String editionId, @PathVariable String mentorId) {
    Long ed_id = Long.parseLong(editionId);
    Long mid = Long.parseLong(mentorId);
    MentorEdition mentor = mentorService.findByIdAndEditionId(mid, ed_id);
    return new ResponseEntity<>(converter.convertMentorEditionToDto(mentor), HttpStatus.OK);
  }
  @PostMapping("/user/{userId}")
  public ResponseEntity<MentorResponse> createMentorFromUser(@PathVariable String userId) {
    Mentor mentor = mentorService.mentorFromUserId( Long.parseLong(userId) );
    return new ResponseEntity<>(converter.convertMentorToDto(mentor), HttpStatus.CREATED);
  }

  @GetMapping("/edition/{editionId}")
  public ResponseEntity<List<MentorEditionResponse>> findAllMentors(@PathVariable String editionId) {
    Long ed_id = Long.parseLong(editionId);
    List<MentorEdition> mentors = mentorService.findMentorEditionByEditionId(ed_id);
    return new ResponseEntity<>(converter.convertMentorEditionToMentorDto(mentors), HttpStatus.OK);
  }
  @PostMapping("/edition/{editionId}/{mentorId}")
  public ResponseEntity<MentorEditionResponse> createMentorStatus(
    @PathVariable String editionId, @PathVariable String mentorId, @RequestBody MentorEditionRequest status) {
    Long ed_id = Long.parseLong(editionId);
    Long mid = Long.parseLong(mentorId);
    MentorEdition mentor = mentorService.createMentorEdition(mid, ed_id, status);
    return new ResponseEntity<>(converter.convertMentorEditionToDto(mentor), HttpStatus.CREATED);
  }
  @PutMapping("/edition/{editionId}/{mentorId}")
  public ResponseEntity<MentorEditionResponse> updateMentorStatus(
    @PathVariable String editionId, @PathVariable String mentorId, @RequestBody MentorEditionRequest status) {
    Long ed_id = Long.parseLong(editionId);
    Long mid = Long.parseLong(mentorId);
    MentorEdition mentor = mentorService.updateMentorEdition(mid, ed_id, status);
    return new ResponseEntity<>(converter.convertMentorEditionToDto(mentor), HttpStatus.OK);
  }

  @PostMapping("/areas/{mentorId}")
  public ResponseEntity<List<MentorAreaResponse>> createMentorArea(
    @RequestBody MentorAreaRequest request, @PathVariable String mentorId) {
    List<MentorArea> mentorAreas = mentorService.createMentorAreas(Long.parseLong(mentorId), request);
    return new ResponseEntity<>(converter.convertMentorAreaToDto(mentorAreas), HttpStatus.OK);
  }
  @PutMapping("/areas/{mentorId}")
  public ResponseEntity<List<MentorAreaResponse>> updateMentorArea(
    @RequestBody MentorAreaRequest request, @PathVariable String mentorId) {
    List<MentorArea> mentorAreas = mentorService.updateMentorAreas(Long.parseLong(mentorId), request);
    return new ResponseEntity<>(converter.convertMentorAreaToDto(mentorAreas), HttpStatus.OK);
  }
  
  @GetMapping("/availability/{editionId}/{mentorId}")
  public ResponseEntity<List<MentorAvailabilityResponse>> findMentorAvailability(
      @PathVariable String editionId, @PathVariable String mentorId) {
    List<MentorAvailability> availabilities = mentorService.getMentorAvailabilities(
        Long.parseLong(mentorId), Long.parseLong(editionId)
      );
    return new ResponseEntity<>(converter.convertMentorAvailabilityToDto(availabilities), HttpStatus.OK);
  }
  @PostMapping("/availability")
  public ResponseEntity<List<MentorAvailabilityResponse>> createMentorAvailability(
      @RequestBody MentorAvailabilitiesRequest request) {
    List<MentorAvailability> availability = mentorService.saveMentorAvailability(request);
    return new ResponseEntity<>(converter.convertMentorAvailabilityToDto(availability), HttpStatus.CREATED);
  }
  @PutMapping("/availability") //{editionId}/{mentorId}
  public ResponseEntity<List<MentorAvailabilityResponse>> updateMentorAvailability(
    @RequestBody MentorAvailabilitiesRequest request) {
    List<MentorAvailability> availability = mentorService.saveMentorAvailability(request);
    return new ResponseEntity<>(converter.convertMentorAvailabilityToDto(availability), HttpStatus.OK);
  }
  @DeleteMapping("/availability/{availabilityId}")
  public ResponseEntity<Void> deleteMentorAvailability(@PathVariable String availabilityId) {
    mentorService.deleteMentorAvailability(Long.parseLong(availabilityId));
    return null;
  }
  @DeleteMapping("/availability")
  public ResponseEntity<Void> deleteMentorAvailabilities(@RequestBody List<Long> request) {
    mentorService.deleteMentorAvailabilities(request);
    return null;
  }
}
