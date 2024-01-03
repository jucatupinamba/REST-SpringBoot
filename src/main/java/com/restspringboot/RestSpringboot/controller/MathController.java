package com.restspringboot.RestSpringboot.controller;

import com.restspringboot.RestSpringboot.exception.UnsupportedMathOperationException;
import com.restspringboot.RestSpringboot.model.MathOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    @Autowired
    private MathOperations mathOperations;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public ResponseEntity<Double> sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo){
    Double result = mathOperations.sum(numberOne, numberTwo);
    return ResponseEntity.ok().body(result);
    }


    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public ResponseEntity<Double> sub (
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception{
        Double result = mathOperations.sub(numberOne, numberTwo);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public ResponseEntity<Double> mult (
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception{
        Double result = mathOperations.mult(numberOne, numberTwo);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public ResponseEntity<Double> div (
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception{
       Double result = mathOperations.div(numberOne, numberTwo);
       return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}/{numberThree}", method = RequestMethod.GET)
    public ResponseEntity<Double> mean (
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo,
            @PathVariable(value = "numberThree") String numberThree)
            throws Exception{
        Double result = mathOperations.mean(numberOne, numberTwo, numberThree);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = "/sqrt/{numberOne}", method = RequestMethod.GET)
    public ResponseEntity<Double> sqrt (
            @PathVariable(value = "numberOne") String numberOne)
            throws Exception{
        Double result = mathOperations.sqrt(numberOne);
        return ResponseEntity.ok().body(result);
    }
}
