package com.example.panicz.calculator.Controllers.Calculations;

import java.math.BigDecimal;

public class Calculations extends SimpleCalculations {
    public Calculations(){
        super();
    }

    public Calculations(int roundingMode, int precision){
        super(roundingMode, precision);
    }

    public BigDecimal pow(BigDecimal number, BigDecimal n){
        return Exponentiation.pow(number,n);
    }

    public BigDecimal pow(BigDecimal number, int n){
        return Exponentiation.pow(number, n);
    }
    public String rootI(String number, int n){
        return Roots.rootI(number, n);
    }

    public BigDecimal root(BigDecimal number, int n){
        return Exponentiation.root(number, n);
    }

    public BigDecimal gCD(BigDecimal first, BigDecimal second){
        return GreatestCommonDivisor.gCD(first,second);
    }


}
