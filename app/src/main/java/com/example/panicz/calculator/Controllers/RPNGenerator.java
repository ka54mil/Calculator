package com.example.panicz.calculator.Controllers;

import com.example.panicz.calculator.Exceptions.IncorrectEquationFormatException;

import java.util.Deque;
import java.util.LinkedList;

public class RPNGenerator {
    private Deque<String> rpn;
    private Deque<String> functions;
    StringBuilder number;
    String equation;

    public RPNGenerator(){
        functions = new LinkedList<String>();
        rpn=new LinkedList<String>();
        number = new StringBuilder();
        equation = new String();
    }

    public Deque<String> parseToRPN(String equation) throws Exception{
        functions = new LinkedList<String>();
        rpn=new LinkedList<String>();
        number = new StringBuilder();
        this.equation = equation;
        char character;
        refactorEquation();

        for(int i=0;i<this.equation.length();i++){
            character=this.equation.charAt(i);
            switch(character){
                case '(':
                    if(number.length() == 1 && number.charAt(0) == '-'){
                        number = new StringBuilder("0");
                        addFunctionToStack("-");
                    }
                    addNumberToOutput();
                    addFunctionToStack("(");
                    break;
                case ')':
                    addNumberToOutput();
                    while(!functions.peekLast().equals("(")){
                        addFunctionToOutput();
                    }
                    functions.removeLast();
                    break;
                case '-':
                    if(number.length()==0 && (i==0 || this.equation.charAt(i-1) != ')')){
                        number.append('-');
                        break;
                    }
                case '+':
                case '/':
                case '*':
                case '^':
                    if(i == 0 || this.equation.charAt(i-1)!=')' && number.length()==0){
                        throw new IncorrectEquationFormatException("Invalid equation");
                    }
                    addNumberToOutput();
                    addFunctionToStack(String.valueOf(character));
                    break;
                default:
                    number.append(character);
            }
        }
        addNumberToOutput();
        while(!functions.isEmpty()){
            addFunctionToOutput();
        }
        return rpn;
    }

    private void addFunctionToStack(String function) throws Exception{
        if(!functions.isEmpty()
                && functions.peekLast().charAt(0) != '('
                && cmpPriorities(functions.peekLast().charAt(0),function.charAt(0)) >= 0
                ){
            addFunctionToOutput();
            addFunctionToStack(function);

        } else {
            functions.add(function);
        }
    }

    private boolean addFunctionToOutput() throws Exception{
        return rpn.add(functions.removeLast());
    }

    private void addNumberToOutput() throws Exception{
        if (number.length() > 0) {
            rpn.add(number.toString());
            number= new StringBuilder();
        }
    }

    private int cmpPriorities(char operator1, char operator2){
        return getPriority(operator1)-getPriority(operator2);
    }

    private int getPriority(char character){
        switch(character){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default :
                return 4;
        }
    }

    public void refactorEquation() throws IncorrectEquationFormatException {
        int lbtc=0;
        char character;
        refactorFunctionsInEquation();
        deleteAllWhiteSpaces();
        String equation = this.equation;
        for(int i=0;i<equation.length();i++){
            character = equation.charAt(i);
            if(character =='('){
                lbtc++;
            } else if(character==')'){
                lbtc--;
                if(lbtc<0) {
                    removeCharacterFromEquation(character, i);
                    lbtc++;
                }
            }
        }
        while(lbtc>0){
            appendCharacterToEquation(')');
            lbtc--;
        }

        character = this.equation.charAt(this.equation.length()-1);
        if(character != ')'){
            if(character < '0' || character > '9') throw new IncorrectEquationFormatException("Invalid equation");
        } else {
            int i = 1;
            while(character == ')' || character == '('){
                character = this.equation.charAt(this.equation.length()-(++i));
            }
            if(character < '0' || character > '9') throw new IncorrectEquationFormatException("Invalid equation");
        }
    }

    private void removeCharacterFromEquation(char character, int index){
        if(index == 0){
            this.equation = this.equation.substring(1);
        } else {
            this.equation = new String(this.equation.substring(0, index) + this.equation.substring(index+1));
        }
    }

    private void appendCharacterToEquation(char character){
        this.equation = new String(this.equation+character);
    }

    private void deleteAllWhiteSpaces(){
        this.equation = this.equation.trim().replaceAll(" ", "");
    }

    private void refactorFunctionsInEquation(){
        this.equation = this.equation.replaceAll(String.valueOf((char)247), "/");
    }
}

