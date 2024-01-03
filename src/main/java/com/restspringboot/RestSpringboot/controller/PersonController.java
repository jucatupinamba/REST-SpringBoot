package com.restspringboot.RestSpringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PersonController {


    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public ResponseEntity<Double> sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo){
    Double result = mathOperations.sum(numberOne, numberTwo);
    return ResponseEntity.ok().body(result);
    }

}
