package com.lgj.webapp.controllers;
import java.util.List;

import com.lgj.webapp.entities.Proyecto;
import com.lgj.webapp.services.ProyectoServices;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/proyecto")
public class ProyectoController {
    @Autowired
    private ProyectoServices proyectoService;

    @GetMapping
    public ResponseEntity<List<Proyecto>> getAllProyectos(){
        return ResponseEntity.ok(proyectoService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> getProyectoById(@PathVariable Long id){
        Proyecto p = proyectoService.get(id);
        return p!=null ? ResponseEntity.ok(p) : new ResponseEntity<Proyecto>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<Proyecto> saveProyecto(@RequestBody Proyecto proyecto){
        Proyecto p = proyectoService.save(proyecto);
        return p!=null && p.getId()!=null ? ResponseEntity.ok(p) : new ResponseEntity<Proyecto>(HttpStatus.NOT_MODIFIED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> updateProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto){
        if(id!=null && proyecto.getId()!=null){
            Proyecto p = proyectoService.save(proyecto);
            return p!=null && p.getId()!=null ? ResponseEntity.ok(p) : new ResponseEntity<Proyecto>(HttpStatus.NOT_MODIFIED);
        }else{
            return new ResponseEntity<Proyecto>(HttpStatus.NOT_MODIFIED);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProyecto(@PathVariable Long id){
        if(id!=null && proyectoService.get(id)!=null){
            proyectoService.delete(id);
            return ResponseEntity.ok("Proyecto Eliminado");
        }else{
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }


}