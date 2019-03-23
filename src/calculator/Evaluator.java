/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 * To evaluate strings by operations.
 * Implemented classes are operations divided by
 * priority.
 *
 * @author yuri
 */
interface Evaluator {
    /**
     * Pattern represents a float number like 0.123 .
     */

    String PATTERN_OF_NUMBER
            = "([-]?[0-9]*\\.?[0-9]+"
            + "|"
            + "[-]?[0-9]+\\.?[0-9]*)";
    
    
    /**
     * Pattern represents comparison operators.
     */
    String PATTERN_OF_LOGICAL_OPERATOR
            = "(&|\\|)";
    
    /**
     * Pattern represents comparison operators.
     */
    String PATTERN_OF_COMPARISON_OPERATOR
            = "(<=|>=|==|!=|>|<)";
    
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
     * Pattern represents simple comparison expression like 1>2 .
     */
    String PATTERN_OF_LOGICAL_EXPRESSION
            = "("
            + PATTERN_OF_NUMBER
            + PATTERN_OF_COMPARISON_OPERATOR
            + PATTERN_OF_NUMBER
            + ")";
    /**
     * Pattern represents simple ternary expression like 1?2:3
     */
    String PATTERN_OF_TERNARY_EXPRESSION
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
    String PATTERN_OF_HIGH_PRIORITY_BINARY_EXPRESSION
            = "("
            + PATTERN_OF_NUMBER
            + PATTERN_OF_HIGH_PRIORITY_BINARY_OPERATOR
            + PATTERN_OF_NUMBER
            + ")";
    /**
     * Pattern represents simple binary expression with plus and minus operators.
     */
    String PATTERN_OF_LOW_PRIORITY_BINARY_EXPRESSION
            = "("
            + PATTERN_OF_NUMBER
            + PATTERN_OF_LOW_PRIORITY_BINARY_OPERATOR
            + PATTERN_OF_NUMBER
            + ")";
    /**
     * Pattern represents simple expression. 
     * The expression with only one pair of parentheses.
     */
    String PATTERN_OF_SIMPLE_PARENTHESES
            = "("
            + "\\("
            + "[^\\(^\\)]*"
            + PATTERN_OF_NUMBER
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
    String evaluate(String expression);
}
