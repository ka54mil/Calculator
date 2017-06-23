package com.example.panicz.calculator.Math;

import java.math.BigDecimal;

public final class Division {

    private Division(){
        super();
    }

    public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor, int scale, int roundingMode){
        if (divisor.equals(new BigDecimal(0))) {
            throw new ArithmeticException("Dividing by 0");
        }
        return dividend.divide(divisor, scale+50, roundingMode).setScale(scale, roundingMode);
    }

    public static boolean isEven(BigDecimal number){
        return canBeDividedBy(number, new BigDecimal(2));
    }

    public static boolean canBeDividedBy(BigDecimal number, BigDecimal divisor){
        return number.remainder(divisor).compareTo(BigDecimal.ZERO)==0;
    }
}
