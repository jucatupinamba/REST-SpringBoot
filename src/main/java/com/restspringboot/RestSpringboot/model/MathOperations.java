package com.restspringboot.RestSpringboot.model;

import com.restspringboot.RestSpringboot.exception.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathOperations {

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


    private Double convertToDouble(String strNumber) {
        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
}
