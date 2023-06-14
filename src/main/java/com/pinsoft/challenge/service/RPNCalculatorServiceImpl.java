package com.pinsoft.challenge.service;

import com.pinsoft.challenge.dto.ExpressionDTO;
import com.pinsoft.challenge.dto.RPNCalculatorDTO;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

@Service
public class RPNCalculatorServiceImpl implements RPNCalculatorService{
    private final static String ADD = "+";
    private final static String SUBTRACT = "-";
    private final static String MULTIPLY = "*";
    private final static String DIVIDE = "/";
    @Override
    public RPNCalculatorDTO calculateRPN(ExpressionDTO expression) {
        String[] elements = expression.getExpression().split(" ");
        double result = calculateRPN(elements);
        return  new RPNCalculatorDTO(result);

    }

    private double calculateRPN(String[] expression){
        Set<String> operations = new HashSet<>(){{
            add(ADD);
            add(SUBTRACT);
            add(MULTIPLY);
            add(DIVIDE);
        }};

        Stack<Double> stack = new Stack<>();
        for(String element: expression){
            if(operations.contains(element)){
                double val2 = stack.pop();
                double val1 = stack.pop();
                stack.push(performOperation(val1,val2,element));
            }else{
                stack.push(Double.valueOf(element));
            }
        }
        return stack.pop();
    }
    
    private double performOperation(double val1, double val2, String operation) {
        double result = 0;
        switch (operation) {
            case "+":
                result = val1+val2;
                break;
            case "-":
                result = val1-val2;
                break;
            case "*":
                result = val1*val2;
                break;
            case "/":
                result = val1/val2;
                break;
        }
        return  result;
    }
}
