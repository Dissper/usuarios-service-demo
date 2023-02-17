package com.example.microservicos.app.usuarios.controllers;

import com.example.microservicos.app.usuarios.models.entity.Alumno;
import com.example.microservicos.app.usuarios.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver (@PathVariable Long id){

        Optional<Alumno> o = service.findById(id);
        if (!o.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(o.get());
    }
}
