package com.restspringboot.RestSpringboot.model;

import com.restspringboot.RestSpringboot.exception.UnsupportedMathOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.restspringboot.RestSpringboot.model.NumberConverter.convertToDouble;
import static com.restspringboot.RestSpringboot.model.NumberConverter.isNumeric;

@Service
public class MathOperations {

    @Autowired
    private NumberConverter numberConverter;

    public Double sum(String numberOne, String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo) ){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public Double sub(String numberOne, String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo) ){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    public Double mult(String numberOne, String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo) ){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    public Double div(String numberOne, String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo) ){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    public Double mean(String numberOne, String numberTwo, String numberThree){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo) || !isNumeric(numberThree)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo) + convertToDouble(numberThree)) / 3;
    }

    public Double sqrt(String number){
        if(!isNumeric(number)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(convertToDouble(number));
    }
}
