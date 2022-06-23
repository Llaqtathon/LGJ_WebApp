package com.lgj.webapp.repository;

import java.util.List;

import com.lgj.webapp.entities.Area;
import com.lgj.webapp.entities.Mentor;
import com.lgj.webapp.entities.MentorArea;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorAreaRepository extends JpaRepository<MentorArea, Long> {

  List<Area> findAreaByMentorId(String mentorId);
  List<Mentor> findMentorByAreaId(String areaId);
  MentorArea getOneByMentorIdAndAreaId(Long mentorId, Integer areaId);
  List<MentorArea> findByMentor(Mentor mentor);

}