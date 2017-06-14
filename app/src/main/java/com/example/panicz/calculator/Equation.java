package com.example.panicz.calculator;

import java.util.*;

public class Equation {
    private Deque<String> equation;
    private static RPNGenerator generator = new RPNGenerator();

    public Equation(String equation){
        try {
            this.equation = generator.parseToRPN(equation);
        } catch (IncorrectEquationFormatException iefe){
            System.out.println(iefe.getMessage());
            this.equation = new LinkedList<String>();
        } catch (Exception e){
            System.out.println("Something has gone wrong.");
            this.equation = new LinkedList<String>();
        }
    }

    public String toString(){
        StringBuilder equation = new StringBuilder();
        while(!this.equation.isEmpty()) {
            equation.append(this.equation.pop() + " ");
        }
        return equation.deleteCharAt(equation.lastIndexOf(" ")).toString();
    }

    public void setEquation(String equation){
        try {
            this.equation = generator.parseToRPN(equation);
        } catch (IncorrectEquationFormatException iefe){
            System.out.println(iefe.getMessage());
        } catch (Exception e){
            System.out.println("Something has gone wrong.");
        }
    }
}