/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author yuri
 */
public class TernaryEvaluator extends OperationEvaluator {

    public TernaryEvaluator() {
        pattern = PATTERN_OF_TERNARY_EXPRESSION;
    }

    @Override
    public double calculate(String simpleExpression) throws ParseException {
        Scanner sc = new Scanner(simpleExpression);
        Double logicOperand = Double.valueOf(sc.findInLine(PATTERN_OF_FLOAT_NUMBER));
        sc.findInLine("\\?");
        Double leftOperand = Double.valueOf(sc.findInLine(PATTERN_OF_FLOAT_NUMBER));
        sc.findInLine(":");
        Double rightOperand = Double.valueOf(sc.findInLine(PATTERN_OF_FLOAT_NUMBER));
        sc.close();
//        System.out.println("[" + logicOperand + "]" + "[" + leftOperand + "]" + "[" + rightOperand + "]");
        return (logicOperand > 0) ? leftOperand : rightOperand;
    }

}
