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
public class Calculator {

    public static final String PATTERN_OF_NUMBER
            = "([-]?[0-9]*\\.?[0-9]+"
            + "|"
            + "[-]?[0-9]+\\.?[0-9]*)";
    public static final String PATTERN_OF_LOGICAL_OPERATOR
            = "(<=|>=|==|!=|>|<)";
    public static final String PATTERN_OF_HIGH_PRIORITY_BINARY_OPERATOR
            = "(\\*|/)";
    public static final String PATTERN_OF_LOW_PRIORITY_BINARY_OPERATOR
            = "(\\+|-)";
    public static final String PATTERN_OF_LOGICAL_EXPRESSION
            = "("
            + PATTERN_OF_NUMBER
            + PATTERN_OF_LOGICAL_OPERATOR
            + PATTERN_OF_NUMBER
            + ")";
    public static final String PATTERN_OF_TERNARY_EXPRESSION
            = "("
            + PATTERN_OF_NUMBER
            + "\\?"
            + PATTERN_OF_NUMBER
            + ":"
            + PATTERN_OF_NUMBER
            + ")";
    public static final String PATTERN_OF_HIGH_PRIORITY_BINARY_EXPRESSION
            = "("
            + PATTERN_OF_NUMBER
            + PATTERN_OF_HIGH_PRIORITY_BINARY_OPERATOR
            + PATTERN_OF_NUMBER
            + ")";
    public static final String PATTERN_OF_LOW_PRIORITY_BINARY_EXPRESSION
            = "("
            + PATTERN_OF_NUMBER
            + PATTERN_OF_LOW_PRIORITY_BINARY_OPERATOR
            + PATTERN_OF_NUMBER
            + ")";
    public static final String PATTERN_OF_SIMPLE_PARENTHESES
            = "("
            + "\\("
            + "[^\\(^\\)]*"
            + PATTERN_OF_NUMBER
            + "[^\\(^\\)]*"
            + "\\)"
            + ")";

    public static String evaluateExpression(String expression) throws ParseException {
        String found = getExpressionInParentheses(expression);
        while (found != null) {
            String simpleExpression = found.substring(1, found.length() - 1);
            expression = expression.replace(
                    found,
                    evaluateSimpleExpression(simpleExpression));
            found = getExpressionInParentheses(expression);
        }
        return evaluateSimpleExpression(expression);
    }

    public static String getExpressionInParentheses(String expression) {
        Scanner sc = new Scanner(expression);
        String found = sc.findInLine(PATTERN_OF_SIMPLE_PARENTHESES);
        sc.close();
        return found;
    }

    public static String evaluateSimpleExpression(String simpleExpression)
            throws ParseException {
        return evaluateAllLowPriorityBinaryInSimpleExpression(simpleExpression);
    }

    public static String evaluateAllLogicInSimpleExpression(String simpleExpression)
            throws ParseException {

        while (true) {
            Scanner sc = new Scanner(simpleExpression);
            String found = sc.findInLine(PATTERN_OF_LOGICAL_EXPRESSION);
            sc.close();
            if (found == null) {
                break;
            }
            simpleExpression = simpleExpression.replace(
                    found,
                    String.valueOf(calculateSimpleLogicalExpression(found))
            );
        }
//        System.out.println("[" + simpleExpression + "]");
        return simpleExpression;
    }

    public static String evaluateAllTernaryInSimpleExpression(String simpleExpression)
            throws ParseException {
        simpleExpression = evaluateAllLogicInSimpleExpression(simpleExpression);
        while (true) {
            Scanner sc = new Scanner(simpleExpression);
            String found = sc.findInLine(PATTERN_OF_TERNARY_EXPRESSION);
            sc.close();
            if (found == null) {
                break;
            }
            simpleExpression = simpleExpression.replace(
                    found,
                    String.valueOf(calculateSimpleTernaryExpression(found))
            );
        }
//        System.out.println("[" + simpleExpression + "]");
        return simpleExpression;
    }

    public static String evaluateAllHighPriorityBinaryInSimpleExpression(String simpleExpression)
            throws ParseException {
        simpleExpression = evaluateAllTernaryInSimpleExpression(simpleExpression);
        while (true) {
            Scanner sc = new Scanner(simpleExpression);
            String found = sc.findInLine(PATTERN_OF_HIGH_PRIORITY_BINARY_EXPRESSION);
            sc.close();
            if (found == null) {
                break;
            }
            simpleExpression = simpleExpression.replace(
                    found,
                    String.valueOf(calculateSimpleHighPriorityBinaryExpression(found))
            );
        }
//        System.out.println("[" + simpleExpression + "]");
        return simpleExpression;
    }

    public static String evaluateAllLowPriorityBinaryInSimpleExpression(String simpleExpression)
            throws ParseException {
        simpleExpression = evaluateAllHighPriorityBinaryInSimpleExpression(simpleExpression);
        while (true) {
            Scanner sc = new Scanner(simpleExpression);
            String found = sc.findInLine(PATTERN_OF_LOW_PRIORITY_BINARY_EXPRESSION);
            sc.close();
            if (found == null) {
                break;
            }
            simpleExpression = simpleExpression.replace(
                    found,
                    String.valueOf(calculateSimpleLowPriorityBinaryExpression(found))
            );
        }
//        System.out.println("[" + simpleExpression + "]");
        return simpleExpression;
    }

    public static double calculateSimpleLogicalExpression(String expression)
            throws ParseException {
        Scanner sc = new Scanner(expression);
        Double leftOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        String operator = sc.findInLine(PATTERN_OF_LOGICAL_OPERATOR);
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
                throw new ParseException("Invalid logical expression", 0);
        }
    }

    public static double calculateSimpleTernaryExpression(String expression)
            throws NumberFormatException {
        Scanner sc = new Scanner(expression);
        Double logicOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        sc.findInLine("\\?");
        Double leftOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        sc.findInLine(":");
        Double rightOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        sc.close();
        System.out.println("[" + logicOperand + "]" + "[" + leftOperand + "]" + "[" + rightOperand + "]");
        return (logicOperand > 0) ? leftOperand : rightOperand;

    }

    public static double calculateSimpleHighPriorityBinaryExpression(String expression)
            throws ParseException, ArithmeticException {
        Scanner sc = new Scanner(expression);
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
                throw new ParseException("Invalid logical expression", 0);
        }
    }

    public static double calculateSimpleLowPriorityBinaryExpression(String expression)
            throws ParseException {
        Scanner sc = new Scanner(expression);
        Double leftOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        String operator = sc.findInLine(PATTERN_OF_LOW_PRIORITY_BINARY_OPERATOR);
        Double rightOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        sc.close();
//        System.out.println("[" + leftOperand + "]" + "[" + operator + "]" + "[" + rightOperand + "]");

        switch (operator) {
            case "+":
                return leftOperand + rightOperand;
            case "-":
                return leftOperand - rightOperand;
            default:
                throw new ParseException("Invalid logical expression", 0);
        }
    }

}
