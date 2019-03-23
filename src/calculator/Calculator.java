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
 * Text calculator.
 *
 * @author yuri
 */
public class Calculator implements Evaluator {

    @Override
    public String evaluate(String expression) throws ParseException {
        //find simple expressions in parentheses
        while (true) {
            Scanner sc = new Scanner(expression);
            String found = sc.findInLine(PATTERN_OF_SIMPLE_PARENTHESES);
            sc.close();
            if (found == null) {
                break;
            }
            //remove outside parentheses 
            String simpleExpression = found.substring(1, found.length() - 1);
            expression = expression.replace(
                    found,
                    evaluateSimpleExpression(simpleExpression));
        }
        return evaluateSimpleExpression(expression);
    }

    @Override
    public double calculate(String simpleExpression) throws ParseException {
        return Double.valueOf(evaluate(simpleExpression));
    }

    private String evaluateSimpleExpression(String simpleExpression) throws ParseException {
        return simpleExpression;
    }

}
