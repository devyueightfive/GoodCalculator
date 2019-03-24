/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.text.ParseException;
import java.util.ArrayList;
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

    /**
     * Evaluate simple expression with all available evaluators.
     * <pre>Evaluators according priority =[
     *      BinaryHighPriorityEvaluator,
     *      BinaryLowPriorityEvaluator,
     *      ComparisonEvaluator,
     *      TernaryEvaluator     *      ]
     * </pre>
     *
     * @param simpleExpression expression without parentheses
     * @return result of evaluations
     * @throws ParseException
     */
    private String evaluateSimpleExpression(String simpleExpression) throws ParseException {
        ArrayList<Evaluator> evaluators = new ArrayList();
        // adding according priority
        evaluators.add(new BinaryHighPriorityEvaluator());
        evaluators.add(new BinaryLowPriorityEvaluator());
        evaluators.add(new ComparisonEvaluator());
        evaluators.add(new LogicHighPriorityEvaluator());
        evaluators.add(new LogicLowPriorityEvaluator());
        evaluators.add(new TernaryEvaluator());

        for (Evaluator e : evaluators) {
            simpleExpression = e.evaluate(simpleExpression);
        }

        return simpleExpression;
    }

}
