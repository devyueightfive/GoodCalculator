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
public interface Evaluator {

    /**
     * Evaluates expression.
     *
     * @param expression expression
     *
     * @return evaluated string
     */
    public String evaluate(String expression);
}
