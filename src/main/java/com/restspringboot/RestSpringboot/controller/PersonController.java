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

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> findAll(){
        return ResponseEntity.ok().body(personServices.findAll());
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> findById(
            @PathVariable(value = "id") String id){
    return ResponseEntity.ok().body(personServices.findById(id));
    }

    @RequestMapping( method = RequestMethod.POST,
                     produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> create(
            @RequestBody Person person){
        return ResponseEntity.ok().body(personServices.create(person));
    }

    @RequestMapping( method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> update(
            @RequestBody Person person){
        return ResponseEntity.ok().body(personServices.update(person));
    }

    @RequestMapping( value = "/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id){
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }

}
