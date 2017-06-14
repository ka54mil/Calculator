package com.example.panicz.calculator.Controllers;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;

public class Calculator {
    private Deque<String> numbers;
    private Equation equation;

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

    public BigDecimal calculate(String equation)
    {
        numbers.clear();
        setEquation(equation);

        String first,second;
        for(int i=0; i<equation.length(); i++)
        {
            char z=equation.charAt(i);

//			switch(co(i))
//			{
//				case 0:
//				{
//					String liczby="";
//					while(z!=' ')
//					{
//						z=equation.charAt(i);
//						if(z!=' ')
//						{
//							liczby=liczby+z;
//							i++;
//						}
//
//					}
//					numbers.push(liczby);
//					break;
//				}
//
//
//				case 1:
//				{
//					first=numbers.pop();
//					second=numbers.pop();
//					numbers.push(second+first);
//					break;
//				}
//
//				case 2:
//				{
//					first=numbers.pop();
//					second=numbers.pop();
//					numbers.push(second-first);
//					break;
//				}
//				case 3:
//				{
//					first=numbers.pop();
//					second=numbers.pop();
//					numbers.push(second*first);
//					break;
//				}
//
//				case 4:
//				{
//					first=numbers.pop();
//					second=numbers.pop();
//					numbers.push(secondfirst);
//					break;
//				}
//			}
        }

        return new BigDecimal(numbers.pop());
    }

}