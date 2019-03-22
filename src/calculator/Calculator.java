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
 * Evaluate expression with selected operations:
 *  comparison (<,>,<=,>=,==,!=),
 *  ternary (logic?trueReturn:falseReturn),
 *  binary operators (+,-,*,/).
 * Expression can consist of parentheses.
 * 
 * Algorithm.
 * The expression is divided on simple expressions by parentheses.
 * Each step look for simple expression inside only pair of parentheses.
 * Evaluate this simple expression. Then found parentheses replace with
 * evaluated expression. So we evaluate all available parentheses to simple expression.
 * On last step evaluate this simple expression.
 * 
 * Evaluations performed in order inside simple expression.
 * The first evaluation is evaluation of all comparison operations.
 * The second is evaluation of all ternary operations.
 * The third is evaluation with multiply and division.
 * The last evaluation in order is evaluation with plus and minus operators.
 * 
 *
 * @author yuri
 */
public class Calculator {
    /**
     * Pattern represents a float number like 0.123 .
     */

    public static final String PATTERN_OF_NUMBER
            = "([-]?[0-9]*\\.?[0-9]+"
            + "|"
            + "[-]?[0-9]+\\.?[0-9]*)";
    
    
    /**
     * Pattern represents comparison operators.
     */
    public static final String PATTERN_OF_LOGICAL_OPERATOR
            = "(&|\\|)";
    
    /**
     * Pattern represents comparison operators.
     */
    public static final String PATTERN_OF_COMPARISON_OPERATOR
            = "(<=|>=|==|!=|>|<)";
    
    /**
     * Pattern represents two binary operators: multiply and division.
     */
    public static final String PATTERN_OF_HIGH_PRIORITY_BINARY_OPERATOR
            = "(\\*|/)";
    
    /**
     * Pattern represents two binary operators: plus and minus.
     */
    public static final String PATTERN_OF_LOW_PRIORITY_BINARY_OPERATOR
            = "(\\+|-)";
    
    /**
     * Pattern represents simple comparison expression like 1>2 .
     */
    public static final String PATTERN_OF_LOGICAL_EXPRESSION
            = "("
            + PATTERN_OF_NUMBER
            + PATTERN_OF_COMPARISON_OPERATOR
            + PATTERN_OF_NUMBER
            + ")";
    /**
     * Pattern represents simple ternary expression like 1?2:3
     */
    public static final String PATTERN_OF_TERNARY_EXPRESSION
            = "("
            + PATTERN_OF_NUMBER
            + "\\?"
            + PATTERN_OF_NUMBER
            + ":"
            + PATTERN_OF_NUMBER
            + ")";
    
    /**
     * Pattern represents simple binary expression with multiply
     * and division operators.
     */
    public static final String PATTERN_OF_HIGH_PRIORITY_BINARY_EXPRESSION
            = "("
            + PATTERN_OF_NUMBER
            + PATTERN_OF_HIGH_PRIORITY_BINARY_OPERATOR
            + PATTERN_OF_NUMBER
            + ")";
    /**
     * Pattern represents simple binary expression with plus and minus operators.
     */
    public static final String PATTERN_OF_LOW_PRIORITY_BINARY_EXPRESSION
            = "("
            + PATTERN_OF_NUMBER
            + PATTERN_OF_LOW_PRIORITY_BINARY_OPERATOR
            + PATTERN_OF_NUMBER
            + ")";
    /**
     * Pattern represents simple expression. 
     * The expression with only one pair of parentheses.
     */
    public static final String PATTERN_OF_SIMPLE_PARENTHESES
            = "("
            + "\\("
            + "[^\\(^\\)]*"
            + PATTERN_OF_NUMBER
            + "[^\\(^\\)]*"
            + "\\)"
            + ")";

    /**
     * Evaluate all available expressions in given input.
     *
     * @param expression complicated expression (with parentheses and all
     * operators)
     * @return result of evaluation
     * @throws ParseException
     */
    public static String evaluateExpression(String expression) throws ParseException {
        String found = getExpressionInParentheses(expression);
        //while we find simple expressions in parentheses
        while (found != null) {
            //remove outside parentheses 
            String simpleExpression = found.substring(1, found.length() - 1);
            expression = expression.replace(
                    found,
                    evaluateSimpleExpression(simpleExpression));
            found = getExpressionInParentheses(expression);
        }
        return evaluateSimpleExpression(expression);
    }

    /**
     * Find next simple parentheses (no parentheses inside).
     *
     * @param expression any expression
     * @return simple expression with only parentheses ( and ).
     */
    public static String getExpressionInParentheses(String expression) {
        Scanner sc = new Scanner(expression);
        String found = sc.findInLine(PATTERN_OF_SIMPLE_PARENTHESES);
        sc.close();
        return found;
    }

    /**
     * Evaluate simple expression (without parentheses). Expression is evaluated
     * with low priority binary operators(LPBO). Before LPBO evaluation the
     * expression is evaluated by high priority binary operators (HPBO). Before
     * HPBO evaluation the expression is evaluated by ternary operators. Before
     * ternary evaluation the expression is evaluated by comparison operators.
     * So expression is fully evaluated.
     *
     * @param simpleExpression expression without parentheses
     * @return result of evaluations
     * @throws ParseException
     */
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

    /**
     * Evaluate expression as expression with ternary operators.
     *
     * @param simpleExpression simple expression withoout parentheses
     * @return result of evaluations.
     * @throws ParseException
     */
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

    /**
     * Evaluate expression as expression with high priority binary operators
     * (HPBO). Before ternary evaluation the expression is evaluated by
     * comparison operators. Before HPBO evaluation the expression is evaluated
     * by ternary operators.
     *
     * See javadoc for evaluateAllLowPriorityBinaryInSimpleExpression.
     *
     * @param simpleExpression simple expression without parentheses
     * @return result of evaluations
     * @throws ParseException
     */
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

    /**
     * Evaluate expression as expression with low priority binary
     * operators(LPBO). Before evaluation the expression is evaluated by high
     * priority binary operators (HPBO). Before HPBO evaluation the expression
     * is evaluated by ternary operators. Before ternary evaluation the
     * expression is evaluated by comparison operators. So expression is fully
     * evaluated.
     *
     * @param simpleExpression simple expression without parentheses
     * @return result of evaluations
     * @throws ParseException
     */
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

    /**
     * Calculate simple comparison expression (without parentheses).
     *
     * @param expression simple comparison expression like 100>5
     * @return value of the expression
     * @throws ParseException
     */
    public static double calculateSimpleLogicalExpression(String expression)
            throws ParseException {
        Scanner sc = new Scanner(expression);
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
                throw new ParseException("Invalid logical expression", 0);
        }
    }

    /**
     * Calculate simple ternary expression (without parentheses).
     *
     * @param expression simple ternary expression like 2?1:3. The example will
     * return 1 thus 2 is greater than 0.
     * @return value of the ternary expression
     * @throws NumberFormatException
     */
    public static double calculateSimpleTernaryExpression(String expression)
            throws NumberFormatException {
        Scanner sc = new Scanner(expression);
        Double logicOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        sc.findInLine("\\?");
        Double leftOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        sc.findInLine(":");
        Double rightOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        sc.close();
//        System.out.println("[" + logicOperand + "]" + "[" + leftOperand + "]" + "[" + rightOperand + "]");
        return (logicOperand > 0) ? leftOperand : rightOperand;

    }

    /**
     * Calculate binary operations with high priority (multiply and division)
     * within simple expression (without parentheses).
     *
     * @param expression simple binary expression like 10.2*3 or 10.2*-3
     * @return value of the expression
     * @throws ParseException
     * @throws ArithmeticException
     */
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

    /**
     * Calculate binary operations with low priority (plus and minus) within
     * simple expression (without parentheses).
     *
     * @param expression simple binary expression like 5.5+2.3 or 5.5+-2.3
     * @return value of expression
     * @throws ParseException
     */
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
