/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import static calculator.Evaluator.PATTERN_OF_LOGICAL_EXPRESSION;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author yuri
 */
public class LogicEvaluator implements Evaluator {

    @Override
    public String evaluate(String expression) throws ParseException {

        while (true) {
            Scanner sc = new Scanner(expression);
            String found = sc.findInLine(PATTERN_OF_LOGICAL_EXPRESSION);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
