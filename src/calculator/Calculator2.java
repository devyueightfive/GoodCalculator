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
public class Calculator2 {

    public static final String PATTERN_OF_NUMBER
            = "([-]?[0-9]*\\.?[0-9]+"
            + "|"
            + "[-]?[0-9]+\\.?[0-9]*)";
    public static final String PATTERN_OF_LOGICAL_OPERATOR
            = "(<=|>=|==|!=|>|<)";
    public static final String PATTERN_OF_BINARY_OPERATOR
            = "(*|/|+|-)";
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
    public static final String PATTERN_OF_BINARY_EXPRESSION
            = "("
            + PATTERN_OF_NUMBER
            + PATTERN_OF_BINARY_OPERATOR
            + PATTERN_OF_NUMBER
            + ")";

    public static String evaluateSimpleExpression(String simpleExpression) throws ParseException {
        return simpleExpression;
    }

    public static String evaluateAllLogicInSimpleExpression(String simpleExpression) throws ParseException {

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
        System.out.println("[" + simpleExpression + "]");
        return simpleExpression;
    }

    public static String evaluateAllTernaryInSimpleExpression(String simpleExpression) throws ParseException {
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
        System.out.println("[" + simpleExpression + "]");
        return simpleExpression;
    }

    public static double calculateSimpleLogicalExpression(String expression) throws ParseException {
        Scanner sc = new Scanner(expression);
        Double leftOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        String operator = sc.findInLine(PATTERN_OF_LOGICAL_OPERATOR);
        Double rightOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        sc.close();

        System.out.println("["+leftOperand+"]"+"["+operator+"]"+"["+rightOperand+"]");
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

    public static double calculateSimpleTernaryExpression(String expression) throws ParseException {
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

    public static double calculateSimpleBinaryExpression(String expression) throws ParseException {
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

}
