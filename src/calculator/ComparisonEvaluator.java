/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.text.ParseException;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author yuri
 */
public class ComparisonEvaluator implements Evaluator {

    @Override
    public String evaluate(String expression) throws ParseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calculate(String simpleExpression) throws ParseException {
        Scanner sc = new Scanner(simpleExpression);
        Double leftOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        String operator = sc.findInLine(PATTERN_OF_COMPARISON_OPERATOR);
        Double rightOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        sc.close();

//        System.out.println("[" + leftOperand + "]" + "[" + operator + "]" + "[" + rightOperand + "]");
        switch (operator) {
            case ">=":
                return leftOperand >= rightOperand ? 1.0 : 0.0;
            case "<=":
                return leftOperand <= rightOperand ? 1.0 : 0.0;
            case "==":
                return Objects.equals(leftOperand, rightOperand) ? 1.0 : 0.0;
            case "!=":
                return !Objects.equals(leftOperand, rightOperand) ? 1.0 : 0.0;
            case "<":
                return leftOperand < rightOperand ? 1.0 : 0.0;
            case ">":
                return leftOperand > rightOperand ? 1.0 : 0.0;
            default:
                throw new ParseException("Bad parsing : " + simpleExpression, 0);
        }
    }

}
