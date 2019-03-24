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
public class BinaryHighPriorityEvaluator extends OperationEvaluator {

    BinaryHighPriorityEvaluator() {
        pattern = PATTERN_OF_HIGH_PRIORITY_BINARY_EXPRESSION;
    }

    @Override
    public double calculate(String simpleExpression) throws ParseException {
        Scanner sc = new Scanner(simpleExpression);
        Double leftOperand = Double.valueOf(sc.findInLine(PATTERN_OF_FLOAT_NUMBER));
        String operator = sc.findInLine(PATTERN_OF_HIGH_PRIORITY_BINARY_OPERATOR);
        Double rightOperand = Double.valueOf(sc.findInLine(PATTERN_OF_FLOAT_NUMBER));
        sc.close();
//        System.out.println("[" + leftOperand + "]" + "[" + operator + "]" + "[" + rightOperand + "]");
        switch (operator) {
            case "/": {
                if (rightOperand == 0) {
                    throw new ArithmeticException("Division by zero");
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
