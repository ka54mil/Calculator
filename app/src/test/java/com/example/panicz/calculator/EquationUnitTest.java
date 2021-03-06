package com.example.panicz.calculator;

import com.example.panicz.calculator.Controllers.Equation;

import junit.framework.Assert;

import org.junit.Test;

public class EquationUnitTest {
    @Test
    public void toStringTest(){
        Equation equation = new Equation("2+    3+4 +5");
        Assert.assertEquals("2 3 + 4 + 5 +", equation.toString());

        equation.setEquation("2*3+4+5");
        Assert.assertEquals("2 3 * 4 + 5 +", equation.toString());

        equation.setEquation("2^3+4+5");
        Assert.assertEquals("2 3 ^ 4 + 5 +", equation.toString());

        equation.setEquation("- 2+3+4+5");
        Assert.assertEquals("-2 3 + 4 + 5 +", equation.toString());

        equation.setEquation("-(2*3)+4+5");
        Assert.assertEquals("0 2 3 * - 4 + 5 +", equation.toString());

        equation.setEquation("(2 - 3)*4+5");
        Assert.assertEquals("2 3 - 4 * 5 +", equation.toString());

        equation.setEquation("22^32)*3/4^3+(12)+(-10)+(-2)");
        Assert.assertEquals("22 32 ^ 3 * 4 3 ^ / 12 + -10 + -2 +", equation.toString());
        equation.setEquation("22^32)*3/4^3+(12)+-10+(-2)");
        Assert.assertEquals("22 32 ^ 3 * 4 3 ^ / 12 + -10 + -2 +", equation.toString());

        equation.setEquation("22^32)*3/4^3+(12)+(-(10))+(-2)");
        Assert.assertEquals("22 32 ^ 3 * 4 3 ^ / 12 + 0 10 - + -2 +", equation.toString());
    }
}
