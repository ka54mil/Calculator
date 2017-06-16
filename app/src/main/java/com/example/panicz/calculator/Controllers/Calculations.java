package com.example.panicz.calculator.Controllers;

import java.math.BigDecimal;

public class Calculations {

    public BigDecimal add(BigDecimal first, BigDecimal second) {
        return first.add(second);
    }

    public BigDecimal subtract(BigDecimal first, BigDecimal second) {
        return first.subtract(second);
    }

    public BigDecimal multiply(BigDecimal first, BigDecimal second) {
        return first.multiply(second);
    }

    public BigDecimal divide(BigDecimal first, BigDecimal second) throws ArithmeticException {
        if (second.equals(new BigDecimal(0))) {
            throw new ArithmeticException("Dividing by 0");
        }
        return first.divide(second, 350, BigDecimal.ROUND_HALF_UP).setScale(300,BigDecimal.ROUND_HALF_UP);
    }

//    public BigDecimal pow(BigDecimal first, BigDecimal n){
//        BigDecimal bigDecimalToN = n.stripTrailingZeros().remainder(BigDecimal.ONE).movePointRight(first.scale()); //Muszę zamienic np. 22312.4312 na ulamek i dodac potege i pierwiastek
//        int powPart = n.intValue();
//        if (n.subtract(n.int).compareTo(powPart))
//        return first.pow().add(root(first,));
//    }

    public BigDecimal pow(BigDecimal first, int n) {
        return first.pow(n);
    }

    public String rootI(String first, int n){// do zwracania wartosci z i
        return new String();
    }

    public BigDecimal root(BigDecimal first, int n) {

        first = first.setScale(300,BigDecimal.ROUND_HALF_UP);
        BigDecimal addition = divide(first, BigDecimal.TEN);
        BigDecimal result = addition;
        BigDecimal resultPow = pow(result, n);
        int compare;

        while((compare = first.compareTo(resultPow))!=0){
            if(compare!=first.signum()){
                result = result.subtract(addition);
                addition = divide(addition, BigDecimal.TEN);
            } else {
                result = add(result, addition);
            }
            resultPow = pow(result, n);
        }

        if(n % 2 == 1 && first.signum() == -1){
            if (result.signum() == 1) {
                return result.negate();
            }
        }
        return result;
    }

    public BigDecimal gCD(BigDecimal first, BigDecimal second){
        BigDecimal rest;
        while((rest = first.remainder(second)).compareTo(BigDecimal.ZERO)!=0){
            first = second;
            second = rest;
        }
        return second.abs();
    }
}
