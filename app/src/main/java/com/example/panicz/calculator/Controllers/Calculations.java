package com.example.panicz.calculator.Controllers;

import com.example.panicz.calculator.Interfaces.ICalculations;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculations {
    private int roundingMode;
    private int precision;

    public Calculations(){
        roundingMode = BigDecimal.ROUND_HALF_UP;
        precision = 500;
    }

    public Calculations(int roundingMode, int precision){
        this.roundingMode = roundingMode;
        this.precision = precision;
    }

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
        return first.divide(second, precision+50, roundingMode).setScale(precision,roundingMode);
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
        BigDecimal maxIntVal = new BigDecimal(999);
        BigDecimal powerOfTen = BigDecimal.ZERO;
        while(n.remainder(BigDecimal.TEN).compareTo(BigDecimal.ZERO)==0){
            n=divide(n,BigDecimal.TEN);
            powerOfTen = add(powerOfTen,BigDecimal.ONE);
        }
        System.out.println(powerOfTen);
        BigDecimal result = new BigDecimal(1).setScale(precision+50,roundingMode);
        if(n.compareTo(maxIntVal)==1){
            BigDecimal powResult = method.pow(first, maxIntVal.intValue());
            BigDecimal maxIntValSquare = pow(maxIntVal,2);
            if(n.compareTo(maxIntValSquare)==1){
                BigDecimal powResultSquare = pow(pow(first,2),maxIntVal.intValue());
                while(n.compareTo(maxIntValSquare)==1){
                    result = multiply(powResultSquare,result);
                    n = subtract(n,maxIntValSquare);
                }
            }
            while (n.compareTo(maxIntVal)==1){
                result = multiply(powResult,result);
                n = subtract(n,maxIntVal);
            }
        }
        result = multiply(method.pow(first , n.intValue()), result);
        BigDecimal maxTenPower = new BigDecimal(7);
        while(powerOfTen.compareTo(maxTenPower)==1){
            result = method.pow(result,pow(BigDecimal.TEN,maxTenPower.intValue()).intValue());
            powerOfTen = divide(powerOfTen,maxTenPower);
        }
        result = method.pow(result,pow(BigDecimal.TEN,powerOfTen.intValue()).intValue());
        return result;
    }

    public BigDecimal pow(BigDecimal first, int n) {
        if(n>999999999){
            return multiply(pow(first,subtract(new BigDecimal(n),new BigDecimal(999999999)).intValue()), pow(first,new BigDecimal(999999999).intValue()));
        }
        return first.pow(n, new MathContext(precision, RoundingMode.HALF_UP));
    }

    public String rootI(String first, int n){// do zwracania wartosci z i
        return new String();
    }

    public BigDecimal root(BigDecimal first, int n) {

        first = first.setScale(precision,roundingMode);
        BigDecimal addition = divide(first, BigDecimal.TEN);
        BigDecimal result = addition;
        BigDecimal prevResult;
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
