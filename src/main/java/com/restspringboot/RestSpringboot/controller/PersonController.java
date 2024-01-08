package com.restspringboot.RestSpringboot.controller;

import com.restspringboot.RestSpringboot.data.vo.v1.PersonVO;
import com.restspringboot.RestSpringboot.data.vo.v2.PersonVOV2;
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

    @PostMapping(value = "v2",produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVOV2> createV2(
            @RequestBody PersonVOV2 personVOV2){
        return ResponseEntity.ok().body(personServices.createV2(personVOV2));
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
