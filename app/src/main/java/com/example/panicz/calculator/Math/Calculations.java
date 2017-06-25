package com.example.panicz.calculator.Math;

import java.math.BigDecimal;

public class Calculations extends SimpleCalculations {
    public Calculations(){
        super();
    }

    public Calculations(int roundingMode, int scale){
        super(roundingMode, scale);
    }

    public BigDecimal pow(BigDecimal number, BigDecimal n){
        return Exponentiation.pow(number,n, this.scale,this.roundingMode);
    }

    public BigDecimal pow(BigDecimal number, int n){
        return Exponentiation.pow(number, n, this.scale,this.roundingMode);
    }
    public String rootI(String number, int n){
        return Roots.rootI(number, n, this.scale,this.roundingMode);
    }

    public BigDecimal root(BigDecimal number, int n){
        return Exponentiation.root(number, n, this.scale,this.roundingMode);
    }

    public BigDecimal gCD(BigDecimal first, BigDecimal second){
        return GreatestCommonDivisor.gCD(first,second);
    }


}
