/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author yuri
 */
public class BinaryHighPriorityEvaluator implements Evaluator {

    @Override
    public String evaluate(String expression) throws ParseException {
        while (true) {
            Scanner sc = new Scanner(expression);
            String found = sc.findInLine(PATTERN_OF_HIGH_PRIORITY_BINARY_EXPRESSION);
            sc.close();
            if (found == null) {
                break;
            }
            // for every
            expression = expression.replace(
                    found,
                    String.valueOf(calculate(found))
            );
        }
//        System.out.println("[" + simpleExpression + "]");
        return expression;
    }

    @Override
    public double calculate(String simpleExpression) throws ParseException {
        Scanner sc = new Scanner(simpleExpression);
        Double leftOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        String operator = sc.findInLine(PATTERN_OF_HIGH_PRIORITY_BINARY_OPERATOR);
        Double rightOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        sc.close();
//        System.out.println("[" + leftOperand + "]" + "[" + operator + "]" + "[" + rightOperand + "]");
        switch (operator) {
            case "/": {
                if (rightOperand == 0) {
                    throw new ArithmeticException("Division on zero");
                }
                return leftOperand / rightOperand;
            }
            case "*":
                return leftOperand * rightOperand;
            default:
                throw new ParseException("Bad parsing : " + simpleExpression, 0);
        }
    }

}
