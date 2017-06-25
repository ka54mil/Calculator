package com.example.panicz.calculator.Math;

import java.math.BigDecimal;

public class Constants{
    public static BigDecimal e;

    public static BigDecimal getE(){
        if(e==null){
            setE();
        }
        return e;
    }

    public static BigDecimal getE(int scale){
        setE(scale);
        return e;
    }

    public static void setE(){
        setE(500);
    }
    public static void setE(int scale){
        try{
            int precised = scale;
            if(Integer.MAX_VALUE-5<precised){
                precised = Integer.MAX_VALUE;
            } else {
                precised +=5;
            }
            e = Factorial.sumInvertedFactorial(precised, BigDecimal.ROUND_HALF_UP).setScale(scale,BigDecimal.ROUND_HALF_UP);
        }catch(Exception e){
            System.out.println(scale+" is not a valid input");
        }
    }
}
