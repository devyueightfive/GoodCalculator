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
abstract class OperationEvaluator implements Evaluator {

    String pattern = ".";

    public String evaluate(String expression) throws ParseException {
        while (true) {
            Scanner sc = new Scanner(expression);
            String found = sc.findInLine(pattern);
            sc.close();
            if (found == null) {
                break;
            }
            // for every
            expression = expression.replace(
                    found,
                    String.valueOf(calculate(found))
            );
        }
//        System.out.println("[" + simpleExpression + "]");
        return expression;
    }

    public double calculate(String simpleExpression) throws ParseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
