package com.example.panicz.calculator.Controllers;

import java.math.BigDecimal;

public class Calculations {

    public BigDecimal add(BigDecimal first, BigDecimal second){
        return first.add(second);
    }

    public BigDecimal subtract(BigDecimal first, BigDecimal second){
        return first.subtract(second);
    }

    public BigDecimal multiply(BigDecimal first, BigDecimal second){
        return first.multiply(second);
    }

    public BigDecimal divide(BigDecimal first, BigDecimal second) throws ArithmeticException{
        if(second.equals(0)) {
            throw new ArithmeticException("Dividing by 0");
        }
        return first.divide(second);
    }

    public BigDecimal pow(BigDecimal first, int second){
        return first.pow(second);
    }
}
