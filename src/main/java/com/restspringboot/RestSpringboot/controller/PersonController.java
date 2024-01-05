package com.restspringboot.RestSpringboot.controller;

import com.restspringboot.RestSpringboot.data.vo.v1.PersonVO;
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
    public ResponseEntity<List<PersonVO>> findAll(){
        return ResponseEntity.ok().body(personServices.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVO> findById(
            @PathVariable(value = "id") Long id){
    return ResponseEntity.ok().body(personServices.findById(id));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVO> create(
            @RequestBody PersonVO personVO){
        return ResponseEntity.ok().body(personServices.create(personVO));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVO> update(
            @RequestBody PersonVO personVO){
        return ResponseEntity.ok().body(personServices.update(personVO));
    }

    @DeleteMapping( value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }

}
