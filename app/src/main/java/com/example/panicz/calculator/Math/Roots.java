package com.example.panicz.calculator.Math;

import java.math.BigDecimal;

public class Roots {

    public Roots() {
        super();
    }

    public static BigDecimal root(BigDecimal number, int n, int scale, int roundingMode) {

        int precision = scale+5;
        BigDecimal addition = Division.divide(number, BigDecimal.TEN, precision, roundingMode);
        BigDecimal result = addition;
        BigDecimal prevResult;
        BigDecimal resultPow = Exponentiation.pow(result, n, precision, roundingMode);
        int compare;
        int repeating = 0;
        int signum = number.signum();
        BigDecimal x = new BigDecimal("9999");
        BigDecimal index = BigDecimal.ONE;
        while((compare = number.compareTo(resultPow)) !=0 && repeating < 10){
            index = Addition.increment(index);
            if(Division.canBeDividedBy(index,x ))
            System.out.println(result);
            prevResult = result;
            if(compare!=signum){
                result = Subtraction.subtract(result, addition);
                addition = Division.divide(addition, BigDecimal.TEN, precision, roundingMode);
            } else {
                result = Addition.add(result, addition);
            }
            resultPow = Exponentiation.pow(result, n, precision, roundingMode);
            if (prevResult.compareTo(result)==0){
                repeating++;
            } else {
                repeating = 0;
            }
        }
        if(n % 2 == 1 && number.signum() == -1){
            if (result.signum() == 1) {
                return result.negate();
            }
        }
        return result.setScale(scale,BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal root(BigDecimal number, int n){
        return root(number, n, 550, BigDecimal.ROUND_HALF_UP);
    }

    public static String rootI(String number, int n, int scale, int roundingMode){// do zwracania wartosci z i
        return new String();
    }
}
