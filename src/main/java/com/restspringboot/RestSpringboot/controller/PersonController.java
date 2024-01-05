package com.restspringboot.RestSpringboot.controller;

import com.restspringboot.RestSpringboot.model.Person;
import com.restspringboot.RestSpringboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices personServices;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> findAll(){
        return ResponseEntity.ok().body(personServices.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> findById(
            @PathVariable(value = "id") Long id){
    return ResponseEntity.ok().body(personServices.findById(id));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> create(
            @RequestBody Person person){
        return ResponseEntity.ok().body(personServices.create(person));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> update(
            @RequestBody Person person){
        return ResponseEntity.ok().body(personServices.update(person));
    }

    @DeleteMapping( value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }

}
