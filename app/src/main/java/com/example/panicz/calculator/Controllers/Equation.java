package com.example.panicz.calculator.Controllers;

import com.example.panicz.calculator.Exceptions.IncorrectEquationFormatException;

import java.util.Deque;
import java.util.LinkedList;

public class Equation {
    private Deque<String> equation;
    private static RPNGenerator generator = new RPNGenerator();

    public Equation(String equation){
        try {
            this.equation = generator.parseToRPN(equation);
        } catch (IncorrectEquationFormatException iefe){
            System.out.println(iefe.getMessage());
            this.equation = new LinkedList<>();
        } catch (Exception e){
            System.out.println("Something has gone wrong.");
            this.equation = new LinkedList<>();
        }
    }

    public Equation(){
        this.equation = new LinkedList<>();
    }

    public String toString(){
        StringBuilder equation = new StringBuilder();
        while(!this.equation.isEmpty()) {
            equation.append(this.equation.pop()).append(" ");
        }
        return equation.deleteCharAt(equation.lastIndexOf(" ")).toString();
    }

    public void setEquation(String equation){
        try {
            this.equation = generator.parseToRPN(equation);
        } catch (IncorrectEquationFormatException iefe){
            System.out.println(iefe.getMessage());
            this.equation.clear();
        } catch (Exception e){
            System.out.println("Something has gone wrong.");
            this.equation.clear();
        }
    }
}