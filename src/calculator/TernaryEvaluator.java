/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import static calculator.Calculator.evaluateAllLogicInSimpleExpression;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author yuri
 */
public class TernaryEvaluator implements Evaluator {

    @Override
    public String evaluate(String expression) throws ParseException {
        expression = evaluateAllLogicInSimpleExpression(expression);
        while (true) {
            Scanner sc = new Scanner(expression);
            String found = sc.findInLine(PATTERN_OF_TERNARY_EXPRESSION);
            sc.close();
            if (found == null) {
                break;
            }
            expression = expression.replace(
                    found,
                    String.valueOf(calculate(found))
            );
        }
//        System.out.println("[" + simpleExpression + "]");
        return expression;
    }

    @Override
    public double calculate(String simpleExpression) throws ParseException {
        Scanner sc = new Scanner(simpleExpression);
        Double logicOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        sc.findInLine("\\?");
        Double leftOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        sc.findInLine(":");
        Double rightOperand = Double.valueOf(sc.findInLine(PATTERN_OF_NUMBER));
        sc.close();
//        System.out.println("[" + logicOperand + "]" + "[" + leftOperand + "]" + "[" + rightOperand + "]");
        return (logicOperand > 0) ? leftOperand : rightOperand;
    }

}
