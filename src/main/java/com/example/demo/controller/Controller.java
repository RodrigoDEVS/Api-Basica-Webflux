package com.example.demo.controller;

import com.example.demo.collections.Dato;
import com.example.demo.services.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/datos")
public class Controller {

    @Autowired
    Servicio servicio;

    @PostMapping("/crear")
    public ResponseEntity<Mono<Dato>> guardar(@RequestBody Dato dato){
        return new ResponseEntity(servicio.crear(dato), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Flux<Dato>> traerTodos(){
        return new ResponseEntity(servicio.buscarTodos(), HttpStatus.OK);
    }
}
