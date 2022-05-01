package com.lgj.webapp.controllers;

import java.text.ParseException;
import java.util.List;

import com.lgj.webapp.dto.MentorAreaRequest;
import com.lgj.webapp.dto.MentorAreaResponse;
import com.lgj.webapp.dto.MentorAvailabilitiesRequest;
import com.lgj.webapp.dto.MentorAvailabilityResponse;
import com.lgj.webapp.dto.MentorEditionResponse;
import com.lgj.webapp.dto.MentorResponse;
import com.lgj.webapp.entities.Mentor;
import com.lgj.webapp.entities.MentorArea;
import com.lgj.webapp.entities.MentorAvailability;
import com.lgj.webapp.entities.MentorEdition;
import com.lgj.webapp.services.MentorService;
import com.lgj.webapp.util.EntityDtoConverter;
import com.lgj.webapp.util.GeneralStatus;

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
  public ResponseEntity<MentorResponse> updateMentor(@RequestBody Mentor request, @PathVariable String mentorId) {
    Mentor mentor = mentorService.updateMentor(Long.parseLong(mentorId), request);
    return new ResponseEntity<>(converter.convertMentorToDto(mentor), HttpStatus.OK);
  }
  @PostMapping("/user/{userId}")
  public ResponseEntity<MentorResponse> createMentorFromUser(@PathVariable String userId) {
    Mentor mentor = mentorService.mentorFromUserId( Long.parseLong(userId) );
    return new ResponseEntity<>(converter.convertMentorToDto(mentor), HttpStatus.CREATED);
  }

  @GetMapping("/edition/{editionId}")
  public ResponseEntity<List<MentorResponse>> findAllMentors(@PathVariable String editionId) {
    Long ed_id = Long.parseLong(editionId);
    List<Mentor> mentors = mentorService.findByEditionId(ed_id);
    return new ResponseEntity<>(converter.convertMentorToDto(mentors), HttpStatus.OK);
  }
  @PutMapping("/edition/{editionId}/{mentorId}/status")
  public ResponseEntity<MentorEditionResponse> updateMentorStatus(
    @PathVariable String editionId, @PathVariable String mentorId, @RequestBody GeneralStatus status) {
    Long ed_id = Long.parseLong(editionId);
    Long mid = Long.parseLong(mentorId);
    MentorEdition mentor = mentorService.updateStatus(ed_id, mid, status);
    return new ResponseEntity<>(converter.convertMentorEditionToDto(mentor), HttpStatus.OK);
  }

  @PostMapping("areas/{mentorId}/mentorArea")
  public ResponseEntity<List<MentorAreaResponse>> createMentorArea(
    @RequestBody MentorAreaRequest request, @PathVariable String mentorId) {
    List<MentorArea> mentorAreas = mentorService.saveMentorAreas(Long.parseLong(mentorId), request);
    return new ResponseEntity<>(converter.convertMentorAreaToDto(mentorAreas), HttpStatus.OK);
  }
  @PutMapping("areas/{mentorId}/mentorArea")
  public ResponseEntity<List<MentorAreaResponse>> updateMentorArea(
    @RequestBody MentorAreaRequest request, @PathVariable String mentorId) {
    List<MentorArea> mentorAreas = mentorService.saveMentorAreas(Long.parseLong(mentorId), request);
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
  @PostMapping("/availability/{editionId}/{mentorId}/availabilities")
  public ResponseEntity<List<MentorAvailabilityResponse>> createMentorAvailability(
      @RequestBody MentorAvailabilitiesRequest request,
      @PathVariable String editionId,
      @PathVariable String mentorId) {
    List<MentorAvailability> availability = mentorService.saveMentorAvailability(
        Long.parseLong(editionId), Long.parseLong(mentorId), request
      );
    return new ResponseEntity<>(converter.convertMentorAvailabilityToDto(availability), HttpStatus.CREATED);
  }
  @DeleteMapping("/availability/{availabilityId}")
  public ResponseEntity<Void> deleteMentorAvailability(@PathVariable String availabilityId) {
    mentorService.deleteMentorAvailability(Long.parseLong(availabilityId));
    return null;
  }
  @PutMapping("/availability/{editionId}/{mentorId}")
  public ResponseEntity<List<MentorAvailabilityResponse>> updateMentorAvailability(
    @RequestBody MentorAvailabilitiesRequest request,
    @PathVariable String editionId,
    @PathVariable String mentorId) {
  List<MentorAvailability> availability = mentorService.saveMentorAvailability(
      Long.parseLong(editionId), Long.parseLong(mentorId), request
    );
    return new ResponseEntity<>(converter.convertMentorAvailabilityToDto(availability), HttpStatus.OK);
  }
}
