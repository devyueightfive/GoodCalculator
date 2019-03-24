/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.text.ParseException;
import java.util.Objects;
import java.util.Scanner;
import static calculator.Evaluator.PATTERN_OF_FLOAT_NUMBER;

/**
 *
 * @author yuri
 */
public class LogicHighPriorityEvaluator extends OperationEvaluator {

    public LogicHighPriorityEvaluator() {
        pattern = PATTERN_OF_HIGH_PRIORITY_LOGICAL_EXPRESSION;
    }

    @Override
    public double calculate(String simpleExpression) throws ParseException {
        Scanner sc = new Scanner(simpleExpression);
        Double leftOperand = Double.valueOf(sc.findInLine(PATTERN_OF_FLOAT_NUMBER));
        String operator = sc.findInLine(PATTERN_OF_HIGH_PRIORITY_LOGICAL_OPERATOR);
        Double rightOperand = Double.valueOf(sc.findInLine(PATTERN_OF_FLOAT_NUMBER));
        sc.close();

//        System.out.println("[" + leftOperand + "]" + "[" + operator + "]" + "[" + rightOperand + "]");
        switch (operator) {
            case "&": {
                if (leftOperand == 0) {
                    return 0;
                }
                if (rightOperand == 0) {
                    return 0;
                }
                return 1;
            }
            default:
                throw new ParseException("Bad parsing : " + simpleExpression, 0);
        }
    }

}
