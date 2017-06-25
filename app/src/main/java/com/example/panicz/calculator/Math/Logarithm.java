package com.example.panicz.calculator.Math;

import java.math.BigDecimal;

public final class Logarithm {
    private Logarithm(){
        super();
    }

    public BigDecimal log(BigDecimal number, BigDecimal x){
        BigDecimal result = new BigDecimal(1);
        return result;
    }

    public BigDecimal log(BigDecimal number){
        return log(number, BigDecimal.TEN);
    }

//    public BigDecimal ln(BigDecimal number){
//        return log(number, e);
//    }
}
