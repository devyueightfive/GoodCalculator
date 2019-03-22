/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.text.ParseException;

/**
 *
 * @author yuri
 */
public class Calculator {

    public double calculate(String userInput) throws ParseException, NumberFormatException {
        if (Expression.isValid(userInput)) {
            return eval(userInput);
        } else {
            throw new ParseException("Invalid expression", 0);

        }
    }


    public double eval(String userInput) throws ParseException, NumberFormatException {

        Expression exprs = Expression.stringToExpression(userInput);
//      Check for Simple Expressions.
//      In Simple case <value> is calculated <value> = <unar>*Double(<expr>)

        System.out.println(exprs);
        for (Value v : exprs) {
            if (Expression.isFloatNumber(v.expr)) {
                int unar = v.unarOperator ? (-1) : 1;
                v.value = unar * Double.parseDouble(v.expr);
                v.expr = String.valueOf(v.value);
                v.unarOperator = false;
                v.isSimple = true;
            }
        }

        for (Value v : exprs) {
            if (Expression.isSimpleLogicalExpression(v.expr)) {
                int unar = v.unarOperator ? (-1) : 1;
                v.value = unar * evalSimpleLogicalExpression(v.expr);
                v.expr = String.valueOf(v.value);
                v.unarOperator = false;
                v.isSimple = true;
            }
        }

        for (Value v : exprs) {
            if (Expression.isSimpleTernaryExpression(v.expr)) {
                int unar = v.unarOperator ? (-1) : 1;
                v.value = unar * evalSimpleTernaryExpression(v.expr);
                v.expr = String.valueOf(v.value);
                v.unarOperator = false;
                v.isSimple = true;
            }
        }

        for (Value v : exprs) {
            if (v.isSimple == false) {
                int unar = v.unarOperator ? (-1) : 1;
                v.value = unar * eval(Expression.removeExternalParentheses(v.expr));
            }
        }

        System.out.println("Before binary operations :\n" + exprs);

        return evalSimpleBinaryExpression(exprs);
    }

    /**
     * *
     *
     * @param simpleExpression represent a Simple Expression (without
     * parentheses). String like "1*2+3" represented as ["1*","2+","3"]
     * @return calculation of the Simple Expression.
     */
    double evalSimpleBinaryExpression(Expression simpleExpression) {
        int bound = simpleExpression.size();

//      Calculate all operators like "*" and "/"
        for (int i = 0; i < bound; i++) {
            Value v = simpleExpression.get(i);
            if (v.binaryOperator == '*' || v.binaryOperator == '/') {
                Value next = simpleExpression.get(i + 1);
                if (v.binaryOperator == '*') {
                    v.value *= next.value;
                } else {
                    if (next.value == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    v.value /= next.value;
                }
                v.binaryOperator = next.binaryOperator;
                simpleExpression.remove(i + 1);
                bound--;
                i--;
            }
        }
//      Calculate all perations like "+" and "-"
        for (int i = 0; i < bound; i++) {
            Value v = simpleExpression.get(i);
            if (v.binaryOperator == '+' || v.binaryOperator == '-') {
                Value next = simpleExpression.get(i + 1);
                if (v.binaryOperator == '+') {
                    v.value += next.value;
                } else {
                    v.value -= next.value;
                }
                v.binaryOperator = next.binaryOperator;
                simpleExpression.remove(i + 1);
                bound--;
                i--;
            }
        }
        System.out.println(simpleExpression.get(0).value);
        return simpleExpression.get(0).value;
    }

    static double evalSimpleTernaryExpression(String input) throws ParseException {

        int positionOfQuestionSign = input.indexOf('?');
        int positionOfColonSign = input.indexOf(':');
        String logic = input.substring(0, positionOfQuestionSign);
        String trueReturn = input.substring(positionOfQuestionSign + 1, positionOfColonSign);
        String falseReturn = input.substring(positionOfColonSign + 1, input.length());
        return (evalSimpleLogicalExpression(logic) > 0)
                ? Double.valueOf(trueReturn)
                : Double.valueOf(falseReturn);
    }

    static double evalSimpleLogicalExpression(String input) throws ParseException {
        String[] operands;
        Double left, right;
        if (input.indexOf("<=") > 0) {
            operands = input.split("<=");
            left = Double.valueOf(operands[0]);
            right = Double.valueOf(operands[1]);
            return (left <= right) ? 1 : 0;

        } else if (input.indexOf(">=") > 0) {
            operands = input.split(">=");
            left = Double.valueOf(operands[0]);
            right = Double.valueOf(operands[1]);
            return (left >= right) ? 1 : 0;
        } else if (input.indexOf("=") > 0) {
            operands = input.split("=");
            left = Double.valueOf(operands[0]);
            right = Double.valueOf(operands[1]);
            return (left == right) ? 1 : 0;
        } else if (input.indexOf(">") > 0) {
            operands = input.split(">");
            left = Double.valueOf(operands[0]);
            right = Double.valueOf(operands[1]);
            return (left > right) ? 1 : 0;
        } else if (input.indexOf("<") > 0) {
            operands = input.split("<");
            left = Double.valueOf(operands[0]);
            right = Double.valueOf(operands[1]);
            return (left < right) ? 1 : 0;
        } else {
            throw new ParseException("Invalid logical expression", 0);
        }

    }

}
