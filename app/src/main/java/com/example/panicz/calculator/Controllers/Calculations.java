package com.example.panicz.calculator.Controllers;

import com.example.panicz.calculator.Interfaces.ICalculations;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

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
        return first.divide(second, 550, BigDecimal.ROUND_HALF_UP).setScale(500,BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal pow(BigDecimal first, BigDecimal n){
        int scale = n.scale();
        BigDecimal fractPart = n.stripTrailingZeros().remainder(BigDecimal.ONE).abs();
        BigDecimal intVal =n.signum()==1?subtract(n, fractPart):add(n, fractPart);
        fractPart = fractPart.movePointRight(scale);

        BigDecimal powScale = pow(BigDecimal.TEN, scale);
        BigDecimal gCD = gCD(fractPart, powScale);

        fractPart = divide(fractPart, gCD);
        powScale = divide(powScale, gCD);

        first = pow(first, powScale, (number, power)-> root(number,power));
        first = pow(first, fractPart, (number, power)-> pow(number,power));

        return first;
    }

    private BigDecimal pow(BigDecimal first, BigDecimal n, ICalculations method) {
        BigDecimal maxIntVal = new BigDecimal(999999);
        BigDecimal result = new BigDecimal(1).setScale(550,BigDecimal.ROUND_HALF_UP);
        if(n.compareTo(maxIntVal)==1){
            BigDecimal powResult = method.pow(first, maxIntVal.intValue());
            while (n.compareTo(maxIntVal)==1){
                result = multiply(powResult,result);
                n = subtract(n,maxIntVal);
            }
        }
        result =  multiply(method.pow(first , n.intValue()), result);
        return result;
    }

    public BigDecimal pow(BigDecimal first, int n) {
        return first.pow(n, new MathContext(500, RoundingMode.HALF_UP));
    }

    public String rootI(String first, int n){// do zwracania wartosci z i
        return new String();
    }

    public BigDecimal root(BigDecimal first, int n) {

        first = first.setScale(500,BigDecimal.ROUND_HALF_UP);
        BigDecimal addition = divide(first, BigDecimal.TEN);
        BigDecimal result = addition;
        BigDecimal prevResult = first;
        BigDecimal resultPow = pow(result, n);
        int compare;
        int repeating = 0;
        int signum = first.signum();
        while((compare = first.compareTo(resultPow)) !=0 && repeating < 10){
            prevResult = result;
            if(compare!=signum){
                result = subtract(result, addition);
                addition = divide(addition, BigDecimal.TEN);
            } else {
                result = add(result, addition);
            }
            resultPow = pow(result, n);
            if (prevResult.compareTo(result)==0){
                repeating++;
            } else {
                repeating = 0;
            }
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
