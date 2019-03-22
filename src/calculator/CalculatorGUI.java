/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.text.ParseException;

/**
 *
 * @author main
 */
public class CalculatorGUI extends javax.swing.JFrame {

    StringBuilder input = new StringBuilder();
    String result = "0";
    Calculator calc = new Calculator();

    /**
     * Creates new form CalculatorGUI
     */
    public CalculatorGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldInput = new javax.swing.JTextField();
        jTextFieldResult = new javax.swing.JTextField();
        jButtonClear = new javax.swing.JButton();
        jButtonZero = new javax.swing.JButton();
        jButtonOne = new javax.swing.JButton();
        jButtonTwo = new javax.swing.JButton();
        jButtonThree = new javax.swing.JButton();
        jButtonFour = new javax.swing.JButton();
        jButtonFive = new javax.swing.JButton();
        jButtonSix = new javax.swing.JButton();
        jButtonSeven = new javax.swing.JButton();
        jButtonEight = new javax.swing.JButton();
        jButtonNine = new javax.swing.JButton();
        jButtonPoint = new javax.swing.JButton();
        jButtonPlus = new javax.swing.JButton();
        jButtonMinus = new javax.swing.JButton();
        jButtonMultiply = new javax.swing.JButton();
        jButtonDivide = new javax.swing.JButton();
        jButtonCalculate = new javax.swing.JButton();
        jButtonOpenParanthese = new javax.swing.JButton();
        jButtonCloseParanthese = new javax.swing.JButton();
        jButtonClearAll = new javax.swing.JButton();
        jButtonEquals = new javax.swing.JButton();
        jButtonGreater = new javax.swing.JButton();
        jButtonLower = new javax.swing.JButton();
        jButtonColon = new javax.swing.JButton();
        jButtonQuestion = new javax.swing.JButton();
        jButtonGreaterOrEquals = new javax.swing.JButton();
        jButtonLowerOrEquals = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SimpleCalculator");
        setAlwaysOnTop(true);
        setResizable(false);

        jTextFieldInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldInput.setAutoscrolls(false);
        jTextFieldInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInputActionPerformed(evt);
            }
        });

        jTextFieldResult.setEditable(false);
        jTextFieldResult.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldResult.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldResult.setText("0");
        jTextFieldResult.setAutoscrolls(false);
        jTextFieldResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldResultActionPerformed(evt);
            }
        });

        jButtonClear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonClear.setText("<-");
        jButtonClear.setAlignmentY(0.0F);
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonZero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonZero.setText("0");
        jButtonZero.setAlignmentY(0.0F);
        jButtonZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZeroActionPerformed(evt);
            }
        });

        jButtonOne.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonOne.setText("1");
        jButtonOne.setAlignmentY(0.0F);
        jButtonOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOneActionPerformed(evt);
            }
        });

        jButtonTwo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonTwo.setText("2");
        jButtonTwo.setAlignmentY(0.0F);
        jButtonTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTwoActionPerformed(evt);
            }
        });

        jButtonThree.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonThree.setText("3");
        jButtonThree.setAlignmentY(0.0F);
        jButtonThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThreeActionPerformed(evt);
            }
        });

        jButtonFour.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonFour.setText("4");
        jButtonFour.setAlignmentY(0.0F);
        jButtonFour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFourActionPerformed(evt);
            }
        });

        jButtonFive.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonFive.setText("5");
        jButtonFive.setAlignmentY(0.0F);
        jButtonFive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiveActionPerformed(evt);
            }
        });

        jButtonSix.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonSix.setText("6");
        jButtonSix.setAlignmentY(0.0F);
        jButtonSix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSixActionPerformed(evt);
            }
        });

        jButtonSeven.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonSeven.setText("7");
        jButtonSeven.setAlignmentY(0.0F);
        jButtonSeven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSevenActionPerformed(evt);
            }
        });

        jButtonEight.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonEight.setText("8");
        jButtonEight.setAlignmentY(0.0F);
        jButtonEight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEightActionPerformed(evt);
            }
        });

        jButtonNine.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonNine.setText("9");
        jButtonNine.setAlignmentY(0.0F);
        jButtonNine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNineActionPerformed(evt);
            }
        });

        jButtonPoint.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonPoint.setText(".");
        jButtonPoint.setAlignmentY(0.0F);
        jButtonPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPointActionPerformed(evt);
            }
        });

        jButtonPlus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonPlus.setText("+");
        jButtonPlus.setAlignmentY(0.0F);
        jButtonPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlusActionPerformed(evt);
            }
        });

        jButtonMinus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonMinus.setText("-");
        jButtonMinus.setAlignmentY(0.0F);
        jButtonMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinusActionPerformed(evt);
            }
        });

        jButtonMultiply.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonMultiply.setText("*");
        jButtonMultiply.setAlignmentY(0.0F);
        jButtonMultiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMultiplyActionPerformed(evt);
            }
        });

        jButtonDivide.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonDivide.setText("/");
        jButtonDivide.setAlignmentY(0.0F);
        jButtonDivide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDivideActionPerformed(evt);
            }
        });

        jButtonCalculate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCalculate.setText("=");
        jButtonCalculate.setAlignmentY(0.0F);
        jButtonCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculateActionPerformed(evt);
            }
        });

        jButtonOpenParanthese.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonOpenParanthese.setText("(");
        jButtonOpenParanthese.setAlignmentY(0.0F);
        jButtonOpenParanthese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenParantheseActionPerformed(evt);
            }
        });

        jButtonCloseParanthese.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCloseParanthese.setText(")");
        jButtonCloseParanthese.setAlignmentY(0.0F);
        jButtonCloseParanthese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseParantheseActionPerformed(evt);
            }
        });

        jButtonClearAll.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonClearAll.setText("clear");
        jButtonClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearAllActionPerformed(evt);
            }
        });

        jButtonEquals.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonEquals.setText("==");
        jButtonEquals.setAlignmentY(0.0F);
        jButtonEquals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEqualsActionPerformed(evt);
            }
        });

        jButtonGreater.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonGreater.setText(">");
        jButtonGreater.setAlignmentY(0.0F);
        jButtonGreater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGreaterActionPerformed(evt);
            }
        });

        jButtonLower.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonLower.setText("<");
        jButtonLower.setAlignmentY(0.0F);
        jButtonLower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLowerActionPerformed(evt);
            }
        });

        jButtonColon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonColon.setText(":");
        jButtonColon.setAlignmentY(0.0F);
        jButtonColon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonColonActionPerformed(evt);
            }
        });

        jButtonQuestion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonQuestion.setText("?");
        jButtonQuestion.setAlignmentY(0.0F);
        jButtonQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuestionActionPerformed(evt);
            }
        });

        jButtonGreaterOrEquals.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonGreaterOrEquals.setText(">=");
        jButtonGreaterOrEquals.setAlignmentY(0.0F);
        jButtonGreaterOrEquals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGreaterOrEqualsActionPerformed(evt);
            }
        });

        jButtonLowerOrEquals.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonLowerOrEquals.setText("<=");
        jButtonLowerOrEquals.setAlignmentY(0.0F);
        jButtonLowerOrEquals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLowerOrEqualsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonQuestion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonGreater, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButtonGreaterOrEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonClearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButtonColon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonLower, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonLowerOrEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonCloseParanthese, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonOpenParanthese, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSeven, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonFour, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonOne, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonZero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonFive, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonNine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSix, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonThree, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPlus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonMinus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonMultiply, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDivide, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextFieldResult, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldInput, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldInput, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldResult, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonOpenParanthese, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLowerOrEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLower, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCloseParanthese, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonEight, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonNine, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonColon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonFour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonFive, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonSix, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonClearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonGreaterOrEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonGreater, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonMultiply, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButtonOne, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonThree, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButtonZero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonDivide, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void appendToInput(String update) {
        input.append(update);
        jTextFieldInput.setText(input.toString());
    }

    private void jTextFieldInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldInputActionPerformed
        input.setLength(0);
        input.append(jTextFieldInput.getText());
    }//GEN-LAST:event_jTextFieldInputActionPerformed

    private void jButtonSevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSevenActionPerformed
        appendToInput("7");
    }//GEN-LAST:event_jButtonSevenActionPerformed

    private void jButtonNineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNineActionPerformed
        appendToInput("9");
    }//GEN-LAST:event_jButtonNineActionPerformed

    private void jButtonEightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEightActionPerformed
        appendToInput("8");
    }//GEN-LAST:event_jButtonEightActionPerformed

    private void jButtonFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFourActionPerformed
        appendToInput("4");
    }//GEN-LAST:event_jButtonFourActionPerformed

    private void jButtonSixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSixActionPerformed
        appendToInput("6");
    }//GEN-LAST:event_jButtonSixActionPerformed

    private void jButtonFiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiveActionPerformed
        appendToInput("5");
    }//GEN-LAST:event_jButtonFiveActionPerformed

    private void jButtonOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOneActionPerformed
        appendToInput("1");
    }//GEN-LAST:event_jButtonOneActionPerformed

    private void jButtonThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThreeActionPerformed
        appendToInput("3");
    }//GEN-LAST:event_jButtonThreeActionPerformed

    private void jButtonTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTwoActionPerformed
        appendToInput("2");
    }//GEN-LAST:event_jButtonTwoActionPerformed

    private void jButtonPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlusActionPerformed
        appendToInput("+");
    }//GEN-LAST:event_jButtonPlusActionPerformed

    private void jButtonMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinusActionPerformed
        appendToInput("-");
    }//GEN-LAST:event_jButtonMinusActionPerformed

    private void jButtonMultiplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMultiplyActionPerformed
        appendToInput("*");
    }//GEN-LAST:event_jButtonMultiplyActionPerformed

    private void jButtonDivideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDivideActionPerformed
        appendToInput("/");
    }//GEN-LAST:event_jButtonDivideActionPerformed

    private void jButtonCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculateActionPerformed
        try {
            result = String.valueOf(calc.evaluateExpression(jTextFieldInput.getText()));
        } catch (ParseException pE) {
            result = pE.getMessage();
        } catch (ArithmeticException aE) {
            result = aE.getMessage();
        } catch (NumberFormatException nfE) {
            result = "Invalid Expression";
        } catch (Exception e) {
            result = "Invalid Expression";
        }
        jTextFieldResult.setText(result);
        System.out.println("\n");
    }//GEN-LAST:event_jButtonCalculateActionPerformed

    private void jButtonPointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPointActionPerformed
        appendToInput(".");
    }//GEN-LAST:event_jButtonPointActionPerformed

    private void jButtonZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZeroActionPerformed
        appendToInput("0");
    }//GEN-LAST:event_jButtonZeroActionPerformed

    private void jButtonCloseParantheseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseParantheseActionPerformed
        appendToInput(")");
    }//GEN-LAST:event_jButtonCloseParantheseActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        if (input.length() > 0) {
            input.deleteCharAt(input.length() - 1);
            jTextFieldInput.setText(input.toString());
        }
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonOpenParantheseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenParantheseActionPerformed
        appendToInput("(");
    }//GEN-LAST:event_jButtonOpenParantheseActionPerformed

    private void jTextFieldResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldResultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldResultActionPerformed

    private void jButtonClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearAllActionPerformed
        input.setLength(0);
        jTextFieldInput.setText(input.toString());
    }//GEN-LAST:event_jButtonClearAllActionPerformed

    private void jButtonEqualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEqualsActionPerformed
        appendToInput("=");    }//GEN-LAST:event_jButtonEqualsActionPerformed

    private void jButtonGreaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGreaterActionPerformed
        appendToInput(">");    }//GEN-LAST:event_jButtonGreaterActionPerformed

    private void jButtonLowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLowerActionPerformed
        appendToInput("<");
    }//GEN-LAST:event_jButtonLowerActionPerformed

    private void jButtonColonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonColonActionPerformed
        appendToInput(":");
    }//GEN-LAST:event_jButtonColonActionPerformed

    private void jButtonQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuestionActionPerformed
        appendToInput("?");
    }//GEN-LAST:event_jButtonQuestionActionPerformed

    private void jButtonGreaterOrEqualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGreaterOrEqualsActionPerformed
        appendToInput(">=");
    }//GEN-LAST:event_jButtonGreaterOrEqualsActionPerformed

    private void jButtonLowerOrEqualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLowerOrEqualsActionPerformed
        appendToInput("<=");
    }//GEN-LAST:event_jButtonLowerOrEqualsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculatorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCalculate;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonClearAll;
    private javax.swing.JButton jButtonCloseParanthese;
    private javax.swing.JButton jButtonColon;
    private javax.swing.JButton jButtonDivide;
    private javax.swing.JButton jButtonEight;
    private javax.swing.JButton jButtonEquals;
    private javax.swing.JButton jButtonFive;
    private javax.swing.JButton jButtonFour;
    private javax.swing.JButton jButtonGreater;
    private javax.swing.JButton jButtonGreaterOrEquals;
    private javax.swing.JButton jButtonLower;
    private javax.swing.JButton jButtonLowerOrEquals;
    private javax.swing.JButton jButtonMinus;
    private javax.swing.JButton jButtonMultiply;
    private javax.swing.JButton jButtonNine;
    private javax.swing.JButton jButtonOne;
    private javax.swing.JButton jButtonOpenParanthese;
    private javax.swing.JButton jButtonPlus;
    private javax.swing.JButton jButtonPoint;
    private javax.swing.JButton jButtonQuestion;
    private javax.swing.JButton jButtonSeven;
    private javax.swing.JButton jButtonSix;
    private javax.swing.JButton jButtonThree;
    private javax.swing.JButton jButtonTwo;
    private javax.swing.JButton jButtonZero;
    private javax.swing.JTextField jTextFieldInput;
    private javax.swing.JTextField jTextFieldResult;
    // End of variables declaration//GEN-END:variables
}
