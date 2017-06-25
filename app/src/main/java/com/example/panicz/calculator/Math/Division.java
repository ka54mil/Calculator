package com.example.panicz.calculator.Math;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class Division {

    private Division(){
        super();
    }


    public static BigInteger divide(BigInteger dividend, BigInteger divisor){
        if (divisor.equals(new BigDecimal(0))) {
            throw new ArithmeticException("Dividing by 0");
        }
        return dividend.divide(divisor);
    }

    public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor, int scale, int roundingMode){
        if (divisor.equals(new BigDecimal(0))) {
            throw new ArithmeticException("Dividing by 0");
        }
        int precised = scale;
        if(Integer.MAX_VALUE-5<scale){
            precised = Integer.MAX_VALUE;
        } else {
            precised += 50;
        }
        return dividend.divide(divisor, precised, roundingMode).setScale(scale, roundingMode);
    }

    public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor, int scale){
        return divide(dividend, divisor, scale, BigDecimal.ROUND_HALF_UP);
    }

    public static boolean isEven(BigDecimal number){
        return canBeDividedBy(number, new BigDecimal(2));
    }

    public static boolean canBeDividedBy(BigDecimal number, BigDecimal divisor){
        return number.remainder(divisor).compareTo(BigDecimal.ZERO)==0;
    }
}
