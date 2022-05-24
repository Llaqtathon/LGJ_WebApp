package com.lgj.webapp.services;

import java.util.List;
import java.util.Optional;

import com.lgj.webapp.entities.Proyecto;
import com.lgj.webapp.repository.ProyectoRepository;
import org.springframework.stereotype.Service; //constructor con param proyecto service
@Service
public class ProyectoServices {

    private ProyectoRepository proyectoRepository;
    public ProyectoServices(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public List<Proyecto> getAll(){
        return proyectoRepository.findAll();
    }
    public Proyecto get(Long id){
        Optional<Proyecto> p = proyectoRepository.findById(id);
        return p.isPresent() ? p.get() :null;
    }
    public Proyecto save(Proyecto proyecto){
        return proyectoRepository.save(proyecto);
    }
    public void delete(Long id){
        proyectoRepository.deleteById(id);
    }
}
