package com.example.panicz.calculator.Controllers;

import com.example.panicz.calculator.Controllers.Calculations.Calculations;
import com.example.panicz.calculator.Exceptions.IncorrectEquationFormatException;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;

public class Calculator {
    private Deque<String> numbers;
    private Equation equation;
    private static Calculations calculations;

    public Calculator()
    {
        super();
        equation = new Equation();
        numbers= new LinkedList<>();
    }

    public Calculator(String equation)
    {
        numbers= new LinkedList<>();
        this.equation=new Equation(equation);
    }

    public Equation getEquation(){
        return equation;
    }

    public void setEquation(String equation){
        this.equation=new Equation(equation);
    }

    public String calculate(String equation) throws IncorrectEquationFormatException {
        numbers.clear();
        setEquation(equation);

        while(!this.equation.isEmpty()){
            which(this.equation.getElement());
        }

        if(numbers.isEmpty()){
            throw new IncorrectEquationFormatException("There is missing argument in your equation");
        }

        StringBuilder result = new StringBuilder(numbers.pop());
        while(!numbers.isEmpty()){
            result.append(numbers.pop());
        }

        return result.toString();
    }

    private void which(String z){

        switch (z){
            case "+":
                numbers.add(
                        calculations.add(
                                new BigDecimal(numbers.pop()),
                                new BigDecimal(numbers.pop())
                        ).toString()
                );
                break;
            default:
                numbers.add(z);//a co robic gdy mamy np. 3+a albo 2*a? i nie znamy wartosci a?
        }
    }
}