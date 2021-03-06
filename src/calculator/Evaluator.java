/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.text.ParseException;

/**
 * To evaluate strings by operations.
 *
 * @author yuri
 */
interface Evaluator {

    /**
     * Pattern represents a float number like 0.123 .
     */
    String PATTERN_OF_FLOAT_NUMBER
            = "([-]?[0-9]*\\.?[0-9]+"
            + "|"
            + "[-]?[0-9]+\\.?[0-9]*)";

    /**
     * Pattern represents logic high priority operator.
     */
    String PATTERN_OF_HIGH_PRIORITY_LOGICAL_OPERATOR
            = "(&)";
    /**
     * Pattern represents logic low priority operator.
     */
    String PATTERN_OF_LOW_PRIORITY_LOGICAL_OPERATOR
            = "(\\|)";

    /**
     * Pattern represents comparison operators.
     */
    String PATTERN_OF_COMPARISON_OPERATOR
            = "(<=|>=|>|<|==|!=)";

    /**
     * Pattern represents two binary operators: multiply and division.
     */
    String PATTERN_OF_HIGH_PRIORITY_BINARY_OPERATOR
            = "(\\*|/)";

    /**
     * Pattern represents two binary operators: plus and minus.
     */
    String PATTERN_OF_LOW_PRIORITY_BINARY_OPERATOR
            = "(\\+|-)";

    /**
     * Pattern represents simple comparison expression.
     */
    String PATTERN_OF_COMPARISON_EXPRESSION
            = "("
            + PATTERN_OF_FLOAT_NUMBER
            + PATTERN_OF_COMPARISON_OPERATOR
            + PATTERN_OF_FLOAT_NUMBER
            + ")";
    /**
     * Pattern represents simple expression with low logical operator.
     */
    String PATTERN_OF_LOW_PRIORITY_LOGICAL_EXPRESSION
            = "("
            + PATTERN_OF_FLOAT_NUMBER
            + PATTERN_OF_LOW_PRIORITY_LOGICAL_OPERATOR
            + PATTERN_OF_FLOAT_NUMBER
            + ")";
    /**
     * Pattern represents simple expression with low logical operator.
     */
    String PATTERN_OF_HIGH_PRIORITY_LOGICAL_EXPRESSION
            = "("
            + PATTERN_OF_FLOAT_NUMBER
            + PATTERN_OF_HIGH_PRIORITY_LOGICAL_OPERATOR
            + PATTERN_OF_FLOAT_NUMBER
            + ")";
    /**
     * Pattern represents simple ternary expression.
     */
    String PATTERN_OF_TERNARY_EXPRESSION
            = "("
            + PATTERN_OF_FLOAT_NUMBER
            + "\\?"
            + PATTERN_OF_FLOAT_NUMBER
            + ":"
            + PATTERN_OF_FLOAT_NUMBER
            + ")";

    /**
     * Pattern represents simple binary expression with multiply and division
     * operators.
     */
    String PATTERN_OF_HIGH_PRIORITY_BINARY_EXPRESSION
            = "("
            + PATTERN_OF_FLOAT_NUMBER
            + PATTERN_OF_HIGH_PRIORITY_BINARY_OPERATOR
            + PATTERN_OF_FLOAT_NUMBER
            + ")";
    /**
     * Pattern represents simple binary expression with plus and minus
     * operators.
     */
    String PATTERN_OF_LOW_PRIORITY_BINARY_EXPRESSION
            = "("
            + PATTERN_OF_FLOAT_NUMBER
            + PATTERN_OF_LOW_PRIORITY_BINARY_OPERATOR
            + PATTERN_OF_FLOAT_NUMBER
            + ")";
    /**
     * Pattern represents simple expression. The expression with only one pair
     * of parentheses.
     */
    String PATTERN_OF_SIMPLE_PARENTHESES
            = "("
            + "\\("
            + "[^\\(^\\)]*"
            + PATTERN_OF_FLOAT_NUMBER
            + "[^\\(^\\)]*"
            + "\\)"
            + ")";

    /**
     * Evaluates expression.
     *
     * @param expression expression
     *
     * @return evaluated string
     */
    String evaluate(String expression) throws ParseException;

    /**
     * Calculate simple expression.
     *
     * @param simpleExpression simple expression that can be calculated
     * @return result of calculation
     * @throws ParseException in case of bad input simpleExpression
     */
    double calculate(String simpleExpression) throws ParseException;
}
