package com.lgj.webapp.controllers;

import java.util.List;

import com.lgj.webapp.entities.Area;
import com.lgj.webapp.services.AreaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/areas")
public class AreaController {

    @Autowired
    private AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService; 
    }

    // @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping
    public ResponseEntity<List<Area>> findAllDistritos() {
        List<Area> areas = areaService.getAll();
        return new ResponseEntity<>(areas, HttpStatus.OK);
    }
}
