package com.example.panicz.calculator.Controllers.Calculations;

import java.math.BigDecimal;

public class Roots {

    public Roots() {
        super();
    }

    public static BigDecimal root(BigDecimal number, int n) {

        BigDecimal addition = Division.divide(number, BigDecimal.TEN);
        BigDecimal result = addition;
        BigDecimal prevResult;
        BigDecimal resultPow = Exponentiation.pow(result, n);
        int compare;
        int repeating = 0;
        int signum = number.signum();
        while((compare = number.compareTo(resultPow)) !=0 && repeating < 10){
            prevResult = result;
            if(compare!=signum){
                result = Subtraction.subtract(result, addition);
                addition = Division.divide(addition, BigDecimal.TEN);
            } else {
                result = Addition.add(result, addition);
            }
            resultPow = Exponentiation.pow(result, n);
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
        return result;
    }

    public static String rootI(String number, int n){// do zwracania wartosci z i
        return new String();
    }
}
