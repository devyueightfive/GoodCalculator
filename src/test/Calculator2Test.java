/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import static calculator.Calculator.calculateSimpleHighPriorityBinaryExpression;
import static calculator.Calculator.calculateSimpleLogicalExpression;
import static calculator.Calculator.calculateSimpleTernaryExpression;
import static calculator.Calculator.evaluateAllHighPriorityBinaryInSimpleExpression;
import static calculator.Calculator.evaluateAllLogicInSimpleExpression;
import static calculator.Calculator.evaluateAllLowPriorityBinaryInSimpleExpression;
import static calculator.Calculator.evaluateAllTernaryInSimpleExpression;
import static calculator.Calculator.evaluateExpression;

/**
 *
 * @author yuri
 */
public class Calculator2Test {

    static boolean testCalculateLogicalExpressions() {
        boolean result = true;
        System.out.println("Tests on calculateSimpleLogicalExpression");
        ArrayList<String> tests = new ArrayList<>();
        ArrayList<Double> expectedResults = new ArrayList<>();
        //#0
        tests.add("1>2");
        expectedResults.add(new Double(0));
        //#1
        tests.add("1.5<2");
        expectedResults.add(new Double(1));
        //#2
        tests.add("1.5<-2");
        expectedResults.add(new Double(0));
        //#3
        tests.add("10.5<=10.5");
        expectedResults.add(new Double(1));
        //#4
        tests.add("10.5>=10.5");
        expectedResults.add(new Double(1));
        //#5
        tests.add("2.51==2.51");
        expectedResults.add(new Double(1));
        //#6
        tests.add("-10.5==-10.5");
        expectedResults.add(new Double(1));
        //#7
        tests.add("-5!=3");
        expectedResults.add(new Double(1));
        //#8
        tests.add("-10.5<=-10.5");
        expectedResults.add(new Double(1));
        //#9
        tests.add("-10.5<=-2");
        expectedResults.add(new Double(1));
        //#10
        tests.add("-10.5<=-.2");
        expectedResults.add(new Double(1));
        //#11
        tests.add("10.5==10.5");
        expectedResults.add(new Double(1));

        if (tests.size() == expectedResults.size()) {
            for (int i = 0; i < tests.size(); i++) {
                try {
                    if (expectedResults.get(i).doubleValue()
                            == calculateSimpleLogicalExpression(
                                    tests.get(i))) {
                        System.out.println("OK #" + i);
                    } else {
                        System.out.println("FAIL #" + i);
                        result = false;
                    }

                } catch (Exception ex) {
                    System.out.println("Exception on #" + i);
                }
            }
        }
        if (result) {
            System.out.println("------------------------------------------------");
            System.out.println("OK\n");
        } else {
            System.out.println("------------------------------------------------");
            System.out.println("FAIL\n");
        }
        return result;
    }

    static boolean testEvaluateAllLogicInSimpleExpression() {
        boolean result = true;
        System.out.println("Tests on evaluateAllLogicInSimpleExpressions");
        ArrayList<String> tests = new ArrayList<>();
        ArrayList<String> expectedResults = new ArrayList<>();
        //#0
        tests.add("2.5==3?6.7:8.8+1.9>0?-3.4:8.6");
        expectedResults.add("0.0?6.7:8.8+1.0?-3.4:8.6");
        //#1
        tests.add("2.5>3?6.7:8.8");
        expectedResults.add("0.0?6.7:8.8");
        //#2
        tests.add("-2.7<=3.6+-18*3<4");
        expectedResults.add("1.0+-18*1.0");
        //#3
        tests.add("-2.7<=3.6+1.0+-3>4");
        expectedResults.add("1.0+1.0+0.0");
        //#4
        tests.add("-2.7<=3.6+1.0");
        expectedResults.add("1.0+1.0");
        //#5
        tests.add("2.0>3");
        expectedResults.add("0.0");
        //#6
        tests.add("2<=3");
        expectedResults.add("1.0");
        //#7
        tests.add("-2.7<=3.6");
        expectedResults.add("1.0");

        if (tests.size() == expectedResults.size()) {
            for (int i = 0; i < tests.size(); i++) {
                try {
                    if (expectedResults.get(i).equals(evaluateAllLogicInSimpleExpression(
                            tests.get(i)))) {
                        System.out.println("OK #" + i);
                    } else {
                        System.out.println("FAIL #" + i);
                        result = false;
                    }

                } catch (Exception ex) {
                    System.out.println("Exception on #" + i);
                }
            }
        }
        if (result) {
            System.out.println("------------------------------------------------");
            System.out.println("OK\n");
        } else {
            System.out.println("------------------------------------------------");
            System.out.println("FAIL\n");
        }
        return result;

    }

    static boolean testCalculateSimpleTernaryExpression() {
        boolean result = true;
        System.out.println("Tests on calculateSimpleTernaryExpression");
        ArrayList<String> tests = new ArrayList<>();
        ArrayList<Double> expectedResults = new ArrayList<>();
        //#0
        tests.add("1?2:3");
        expectedResults.add(new Double(2));
        //#1
        tests.add("-1?-2:-3.5");
        expectedResults.add(new Double(-3.5));
        //#2
        tests.add("0?-4.5:-10.99");
        expectedResults.add(new Double(-10.99));

        if (tests.size() == expectedResults.size()) {
            for (int i = 0; i < tests.size(); i++) {
                try {
                    if (expectedResults.get(i).doubleValue()
                            == calculateSimpleTernaryExpression(
                                    tests.get(i))) {
                        System.out.println("OK #" + i);
                    } else {
                        System.out.println("FAIL #" + i);
                        result = false;
                    }

                } catch (Exception ex) {
                    System.out.println("Exception on #" + i);
                }
            }
        }
        if (result) {
            System.out.println("------------------------------------------------");
            System.out.println("OK\n");
        } else {
            System.out.println("------------------------------------------------");
            System.out.println("FAIL\n");
        }
        return result;
    }

    static boolean testEvaluateAllTernaryInSimpleExpression() {
        boolean result = true;
        System.out.println("Tests on evaluateAllTernaryInSimpleExpression");
        ArrayList<String> tests = new ArrayList<>();
        ArrayList<String> expectedResults = new ArrayList<>();
        //#0
        tests.add("2.5==3?6>7:8>-9.8+1.9>0?-3.4:8.6");
        expectedResults.add("1.0+-3.4");
        //#0
        tests.add("2.5==3?67:8.8+1.9>0?-3.4:8.6");
        expectedResults.add("8.8+-3.4");
        //#0
        tests.add("2.5==3?6.7:8.8+1.9>0?-3.4:8.6");
        expectedResults.add("8.8+-3.4");
        //#1
        tests.add("2.5>3?6.7:8.8");
        expectedResults.add("8.8");
        //#2
        tests.add("-2.7<=3.6+-18*3<4");
        expectedResults.add("1.0+-18*1.0");
        //#3
        tests.add("-2.7<=3.6+1.0+-3>4");
        expectedResults.add("1.0+1.0+0.0");
        //#4
        tests.add("-2.7<=3.6+1.0");
        expectedResults.add("1.0+1.0");
        //#5
        tests.add("2.0>3");
        expectedResults.add("0.0");
        //#6
        tests.add("2<=3");
        expectedResults.add("1.0");
        //#7
        tests.add("-2.7<=3.6");
        expectedResults.add("1.0");

        if (tests.size() == expectedResults.size()) {
            for (int i = 0; i < tests.size(); i++) {
                try {
                    if (expectedResults.get(i).equals(evaluateAllTernaryInSimpleExpression(
                            tests.get(i)))) {
                        System.out.println("OK #" + i);
                    } else {
                        System.out.println("FAIL #" + i);
                        result = false;
                    }

                } catch (Exception ex) {
                    System.out.println("Exception on #" + i);
                }
            }
        }
        if (result) {
            System.out.println("------------------------------------------------");
            System.out.println("OK\n");
        } else {
            System.out.println("------------------------------------------------");
            System.out.println("FAIL\n");
        }
        return result;

    }

    static boolean testCalculateSimpleHighPriorityBinaryExpression() {
        boolean result = true;
        System.out.println("Tests on calculateSimpleHighPriorityBinaryExpression");
        ArrayList<String> tests = new ArrayList<>();
        ArrayList<Double> expectedResults = new ArrayList<>();
//#2
        tests.add("-7.5*2");
        expectedResults.add(new Double(-15));
        tests.add("-99/3");
        expectedResults.add(new Double(-33));
//#0
        tests.add("7*-3.1");
        expectedResults.add(new Double(-21.7));
        //#1
        tests.add("-2*3");
        expectedResults.add(new Double(-6));

        if (tests.size() == expectedResults.size()) {
            for (int i = 0; i < tests.size(); i++) {
                try {
                    if (expectedResults.get(i).doubleValue()
                            == calculateSimpleHighPriorityBinaryExpression(
                                    tests.get(i))) {
                        System.out.println("OK #" + i);
                    } else {
                        System.out.println("FAIL #" + i);
                        result = false;
                    }

                } catch (Exception ex) {
                    System.out.println("Exception on #" + i);
                }
            }
        }
        if (result) {
            System.out.println("------------------------------------------------");
            System.out.println("OK\n");
        } else {
            System.out.println("------------------------------------------------");
            System.out.println("FAIL\n");
        }
        return result;
    }

    static boolean testEvaluateAllHighPriorityBinaryInSimpleExpression() {
        boolean result = true;
        System.out.println("Tests on evaluateAllHighPriorityBinaryInSimpleExpression");
        ArrayList<String> tests = new ArrayList<>();
        ArrayList<String> expectedResults = new ArrayList<>();
        //#0
        tests.add("2.5==3?6>7:8>-9.8*1.9>0?-3.4:8.6");
        expectedResults.add("-3.4");
        //#1
        tests.add("2.5==3?67:8.8+1.9>0?-3.4:8.6");
        expectedResults.add("8.8+-3.4");
        //#2
        tests.add("2.5==3?6.7:8.8+1.9>0?-3.4:8.6");
        expectedResults.add("8.8+-3.4");
        //#3
        tests.add("2.5>3?6.7:8.8");
        expectedResults.add("8.8");
        //#4
        tests.add("-2.7<=3.6+-18*3<4");
        expectedResults.add("1.0+-18.0");
        //#5
        tests.add("-2.7<=3.6+1.0+-3>4");
        expectedResults.add("1.0+1.0+0.0");
        //#6
        tests.add("-2.7<=3.6+1.0");
        expectedResults.add("1.0+1.0");
        //#7
        tests.add("2.0>3");
        expectedResults.add("0.0");
        //#8
        tests.add("2<=3");
        expectedResults.add("1.0");
        //#9
        tests.add("-2.7<=3.6");
        expectedResults.add("1.0");

        if (tests.size() == expectedResults.size()) {
            for (int i = 0; i < tests.size(); i++) {
                try {
                    if (expectedResults.get(i).equals(evaluateAllHighPriorityBinaryInSimpleExpression(
                            tests.get(i)))) {
                        System.out.println("OK #" + i);
                    } else {
                        System.out.println("FAIL #" + i);
                        result = false;
                    }

                } catch (Exception ex) {
                    System.out.println("Exception on #" + i);
                }
            }
        }
        if (result) {
            System.out.println("------------------------------------------------");
            System.out.println("OK\n");
        } else {
            System.out.println("------------------------------------------------");
            System.out.println("FAIL\n");
        }
        return result;

    }

    static boolean testEvaluateAllLowPriorityBinaryInSimpleExpression() {
        boolean result = true;
        System.out.println("Tests on evaluateAllLowPriorityBinaryInSimpleExpression");
        ArrayList<String> tests = new ArrayList<>();
        ArrayList<String> expectedResults = new ArrayList<>();
        //#0
        tests.add("2.5==3?6>7:8>-9.8*1.9>0?-3.4:8.6");
        expectedResults.add("-3.4");
        //#1
        tests.add("2.5==3?67:8.8+1.9>0?-3.4:8.6");
        expectedResults.add("5.4");
        //#2
        tests.add("2.5==3?6.7:8.8+1.9>0?-3.4:8.6");
        expectedResults.add("5.4");
        //#3
        tests.add("2.5>3?6.7:8.8");
        expectedResults.add("8.8");
        //#4
        tests.add("-2.7<=3.6+-18*3<4");
        expectedResults.add("-17.0");
        //#5
        tests.add("-2.7<=3.6+1.0+-3>4");
        expectedResults.add("2.0");
        //#6
        tests.add("-2.7<=3.6+1.0");
        expectedResults.add("2.0");
        //#7
        tests.add("2.0>3");
        expectedResults.add("0.0");
        //#8
        tests.add("2<=3");
        expectedResults.add("1.0");
        //#9
        tests.add("-2.7<=3.6");
        expectedResults.add("1.0");

        if (tests.size() == expectedResults.size()) {
            for (int i = 0; i < tests.size(); i++) {
                try {
                    if (expectedResults.get(i).equals(evaluateAllLowPriorityBinaryInSimpleExpression(
                            tests.get(i)))) {
                        System.out.println("OK #" + i);
                    } else {
                        System.out.println("FAIL #" + i);
                        result = false;
                    }

                } catch (Exception ex) {
                    System.out.println("Exception on #" + i);
                }
            }
        }
        if (result) {
            System.out.println("------------------------------------------------");
            System.out.println("OK\n");
        } else {
            System.out.println("------------------------------------------------");
            System.out.println("FAIL\n");
        }
        return result;

    }

    static boolean testevaluateExpression() {
        boolean result = true;
        System.out.println("Tests on evaluateExpression");
        ArrayList<String> tests = new ArrayList<>();
        ArrayList<String> expectedResults = new ArrayList<>();
//#9
        tests.add("((1+3)+(-2.25+(1*2.25)))/(2-1)*1");
        expectedResults.add("4.0");
        tests.add("((1+3)+(1.2+3.8))/3");
        expectedResults.add("3.0");
        tests.add("(1+3)");
        expectedResults.add("4.0");
        tests.add("(1+3)+6");
        expectedResults.add("10.0");
        tests.add("(1+3)+(1.2+3.8)");
        expectedResults.add("9.0");
//#0
        tests.add("2.5==3?6>7:8>-9.8*1.9>0?-3.4:8.6");
        expectedResults.add("-3.4");
        //#1
        tests.add("2.5==3?67:8.8+1.9>0?-3.4:8.6");
        expectedResults.add("5.4");
        //#2
        tests.add("2.5==3?6.7:8.8+1.9>0?-3.4:8.6");
        expectedResults.add("5.4");
        //#3
        tests.add("2.5>3?6.7:8.8");
        expectedResults.add("8.8");
        //#4
        tests.add("-2.7<=3.6+-18*3<4");
        expectedResults.add("-17.0");
        //#5
        tests.add("-2.7<=3.6+1.0+-3>4");
        expectedResults.add("2.0");
        //#6
        tests.add("-2.7<=3.6+1.0");
        expectedResults.add("2.0");
        //#7
        tests.add("2.0>3");
        expectedResults.add("0.0");
        //#8
        tests.add("2<=3");
        expectedResults.add("1.0");
        //#9
        tests.add("-2.7<=3.6");
        expectedResults.add("1.0");

        if (tests.size() == expectedResults.size()) {
            for (int i = 0; i < tests.size(); i++) {
                try {
                    if (expectedResults.get(i).equals(evaluateExpression(
                            tests.get(i)))) {
                        System.out.println("OK #" + i);
                    } else {
                        System.out.println("FAIL #" + i);
                        result = false;
                    }

                } catch (Exception ex) {
                    System.out.println("Exception on #" + i);
                }
            }
        }
        if (result) {
            System.out.println("------------------------------------------------");
            System.out.println("OK\n");
        } else {
            System.out.println("------------------------------------------------");
            System.out.println("FAIL\n");
        }
        return result;

    }

    public static void main(String[] args) {
        boolean result = true;
        result = result && testCalculateLogicalExpressions();
        result = result && testEvaluateAllLogicInSimpleExpression();
        result = result && testCalculateSimpleTernaryExpression();
        result = result && testEvaluateAllTernaryInSimpleExpression();
        result = result && testCalculateSimpleHighPriorityBinaryExpression();
        result = result && testEvaluateAllHighPriorityBinaryInSimpleExpression();
        result = result && testEvaluateAllLowPriorityBinaryInSimpleExpression();
        result = result && testevaluateExpression();

        if (result) {
            System.out.println("All Tests are OK.");
        } else {
            System.out.println("Tests are FAILED.");
        }
    }

}
