package com.example.panicz.calculator;

import com.example.panicz.calculator.Controllers.RPNGenerator;
import com.example.panicz.calculator.Exceptions.IncorrectEquationFormatException;

import junit.framework.Assert;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RPNGeneratorUnitTest {
    @Test
    public void rpnGeneratesCorrect() throws Exception {
        RPNGenerator test = new RPNGenerator();
        Deque<String> rpn = new LinkedList<String>();
        rpn.add("2");
        rpn.add("2");
        rpn.add("-");
        Assert.assertEquals(rpn, test.parseToRPN("2-2"));
        Assert.assertEquals(rpn, test.parseToRPN("(2-2)"));
        Assert.assertEquals(rpn, test.parseToRPN("2-(2)"));
        Assert.assertEquals(rpn, test.parseToRPN("2 -2"));
        Assert.assertEquals(rpn, test.parseToRPN("(2-2 )"));
        Assert.assertEquals(rpn, test.parseToRPN("2-(   2)"));
        rpn.clear();
        rpn.add("-2");
        rpn.add("2");
        rpn.add("-");
        Assert.assertEquals(rpn, test.parseToRPN("-2-2"));
        Assert.assertEquals(rpn, test.parseToRPN("(-2-2)"));
        Assert.assertEquals(rpn, test.parseToRPN("-2-(2)"));
        rpn.push("0");
        rpn.add("-");
        Assert.assertEquals(rpn, test.parseToRPN("-(-2-2)"));
        rpn.clear();
        rpn.add("2");
        rpn.add("-2");
        rpn.add("+");
        Assert.assertEquals(rpn, test.parseToRPN("(2+-2)"));
        Assert.assertEquals(rpn, test.parseToRPN("2+(-2)"));
        rpn.clear();
        rpn.add("2");
        rpn.add("2");
        rpn.add("3");
        rpn.add("*");
        rpn.add("+");
        Assert.assertEquals(rpn, test.parseToRPN("2+2*3"));
        Assert.assertEquals(rpn, test.parseToRPN("2+(2*3)"));
        Assert.assertEquals(rpn, test.parseToRPN(")2+(2*3)"));
        Assert.assertEquals(rpn, test.parseToRPN("(2+(2*3)"));
        Assert.assertEquals(rpn, test.parseToRPN("2+(2*3)("));
        rpn.clear();
        rpn.add("2");
        rpn.add("2");
        rpn.add("+");
        rpn.add("3");
        rpn.add("*");
        Assert.assertEquals(rpn, test.parseToRPN("(2+2)*3"));
        rpn.clear();
        rpn.add("22");
        rpn.add("32");
        rpn.add("^");
        rpn.add("3");
        rpn.add("*");
        rpn.add("4");
        rpn.add("3");
        rpn.add("^");
        rpn.add("/");
        rpn.add("12");
        rpn.add("+");
        rpn.add("-10");
        rpn.add("+");
        rpn.add("-2");
        rpn.add("+");
        Assert.assertEquals(rpn, test.parseToRPN("22^32)*3/4^3+(12)+(-10)+(-2)"));
        Assert.assertEquals(rpn, test.parseToRPN("22^32)*3/4^3+(12)+-10+(-2)"));
        Assert.assertEquals(rpn, test.parseToRPN("(22^32*3/4^3)+(12)+(-10)+(-2)"));
        rpn.removeLast();
        rpn.removeLast();
        rpn.removeLast();
        rpn.removeLast();
        rpn.add("0");
        rpn.add("10");
        rpn.add("-");
        rpn.add("+");
        rpn.add("-2");
        rpn.add("+");
        Assert.assertEquals(rpn, test.parseToRPN("22^32)*3/4^3+(12)+(-(10))+(-2)"));
        rpn.removeLast();
        rpn.removeLast();
        rpn.removeLast();
        rpn.add("-2");
        rpn.add("+");
        rpn.remove("0");
        Assert.assertEquals(rpn, test.parseToRPN("22^32)*3/4^3+(12)-(10)+(-2)"));
        }

    @Test
    public void rpnGeneratesCorrectException() throws Exception{
        RPNGenerator test = new RPNGenerator();
        try{
            test.parseToRPN("+2+3");
            Assert.fail();
        } catch(IncorrectEquationFormatException iefe){

        }

        try{
            test.parseToRPN("*2+3");
            Assert.fail();
        } catch(IncorrectEquationFormatException iefe){

        }

        try{
            test.parseToRPN("/2+3");
            Assert.fail();
        } catch(IncorrectEquationFormatException iefe){

        }

        try{
            test.parseToRPN("^2+3");
            Assert.fail();
        } catch(IncorrectEquationFormatException iefe){

        }

        try{
            test.parseToRPN("2/+3");
            Assert.fail();
        } catch(IncorrectEquationFormatException iefe){

        }

        try{
            test.parseToRPN("2+3+");
            Assert.fail();
        } catch(IncorrectEquationFormatException iefe){

        }

        try{
            test.parseToRPN("2+3/");
            Assert.fail();
        } catch(IncorrectEquationFormatException iefe){

        }

        try{
            test.parseToRPN("2+3*");
            Assert.fail();
        } catch(IncorrectEquationFormatException iefe){

        }

        try{
            test.parseToRPN("2+3^");
            Assert.fail();
        } catch(IncorrectEquationFormatException iefe){

        }

        try{
            test.parseToRPN("2+3-");
            Assert.fail();
        } catch(IncorrectEquationFormatException iefe){

        }

        try{
            test.parseToRPN("2+3+)");
            Assert.fail();
        } catch(IncorrectEquationFormatException iefe){

        }

        try{
            test.parseToRPN("(2+3+)");
            Assert.fail();
        } catch(IncorrectEquationFormatException iefe){

        }

        try{
            test.parseToRPN("2-+3-");
            Assert.fail();
        } catch(IncorrectEquationFormatException iefe){

        }
    }
}