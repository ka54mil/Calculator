package com.example.panicz.calculator.Math;


import com.example.panicz.calculator.Interfaces.ICalculations;

import java.math.BigDecimal;

public final class Exponentiation extends Roots{

    private Exponentiation(){
        super();
    }

    public static BigDecimal pow(BigDecimal number, BigDecimal n, int scale, int roundingMode){
        if(number.compareTo(BigDecimal.ZERO)==0 || number.compareTo(BigDecimal.ONE)==0){
            return number;
        }
        int nScale = n.scale();
        BigDecimal result;
        BigDecimal fractPart = n.stripTrailingZeros().remainder(BigDecimal.ONE).abs();
        BigDecimal intVal =n.signum()==1?Subtraction.subtract(n, fractPart):Addition.add(n, fractPart);
        fractPart = fractPart.movePointRight(nScale);

        BigDecimal powScale = pow(BigDecimal.TEN, nScale, scale, roundingMode);
        BigDecimal gCD = GreatestCommonDivisor.gCD(fractPart, powScale);

        fractPart = Division.divide(fractPart, gCD, scale, roundingMode);
        powScale = Division.divide(powScale, gCD, scale, roundingMode);

        result = pow(number, powScale, (a, power)-> root(a,power, scale, roundingMode), scale, roundingMode);
        result = pow(result, fractPart, (a, power)-> pow(a,power, scale, roundingMode), scale, roundingMode);
        result = Multiplication.multiply(result,pow(number, intVal, (a, power)-> pow(a,power, scale, roundingMode), scale, roundingMode), scale, roundingMode);

        return result;
    }

    private static BigDecimal pow(BigDecimal number, BigDecimal n, ICalculations method, int scale, int roundingMode) {
        if(number.compareTo(BigDecimal.ZERO)==0 || number.compareTo(BigDecimal.ONE)==0){
            return number;
        }

        BigDecimal maxIntVal = new BigDecimal(999);
        BigDecimal result = new BigDecimal(1);
        if(n.compareTo(maxIntVal)==1){
            BigDecimal powResult = method.calculate(number, maxIntVal.intValue());
            BigDecimal maxIntValSquare = pow(maxIntVal,2, scale, roundingMode);
            if(n.compareTo(maxIntValSquare)==1){
                BigDecimal powResultSquare = pow(powResult,2, scale, roundingMode);
                while(n.compareTo(maxIntValSquare)==1){
                    result = Multiplication.multiply(powResultSquare,result, scale, roundingMode);
                    n = Subtraction.subtract(n,maxIntValSquare);
                }
            }
            while (n.compareTo(maxIntVal)==1){
                result = Multiplication.multiply(powResult,result, scale, roundingMode);
                n = Subtraction.subtract(n,maxIntVal);
            }
        }
        result = Multiplication.multiply(method.calculate(number , n.intValue()), result, scale, roundingMode);
        return result;
    }

    public static BigDecimal pow(BigDecimal number, int n, int scale, int roundingMode) {
        if(number.compareTo(BigDecimal.ZERO)==0 || number.compareTo(BigDecimal.ONE)==0){
            return number;
        }

        if(n>999999999){
            return Multiplication.multiply(
                    pow(
                            number,
                            Subtraction.subtract(
                                    new BigDecimal(n),
                                    new BigDecimal(
                                            999999999
                                    )
                            ).intValue(),
                            scale,
                            roundingMode
                    ),
                    pow(
                            number,
                            999999999,
                            scale,
                            roundingMode
                    ),
                    scale,
                    roundingMode
            );
        }
        return number.pow(n).setScale(scale,roundingMode);
    }
}
