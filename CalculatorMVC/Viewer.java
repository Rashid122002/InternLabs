package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Viewer {

    private final JTextField textField;

    public Viewer() {

        Controller controller = new Controller(this);

        JFrame frame = new JFrame();
        frame.setTitle("Calculator");
        ImageIcon image = new ImageIcon("images/logo.jpg");
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(421, 508);
        frame.getContentPane().setBackground(Color.WHITE);

        textField = new JTextField("0");
        textField.setBounds(0, 0, 401, 95);
        textField.setFont(new Font("Consolas", Font.BOLD, 30));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField.setBackground(new Color(236, 240, 241));
        textField.setEditable(false);

        Font buttonFont = new Font("Roboto", Font.BOLD, 20);
        Color darkGray = new Color(23, 32, 42);
        Color gray = new Color(179, 182, 183);

        JButton buttonPercent = new JButton("%");
        buttonPercent.setBounds(3, 95, 97, 58);
        buttonPercent.setFont(buttonFont);
        buttonPercent.setForeground(Color.WHITE);
        buttonPercent.setBackground(darkGray);
        buttonPercent.addActionListener(controller);
        buttonPercent.setActionCommand("percent");

        JButton buttonCE = new JButton("CE");
        buttonCE.setBounds(103, 95, 97, 58);
        buttonCE.setFont(buttonFont);
        buttonCE.setForeground(Color.WHITE);
        buttonCE.setBackground(darkGray);
        buttonCE.addActionListener(controller);
        buttonCE.setActionCommand("ce");

        JButton buttonC = new JButton("C");
        buttonC.setBounds(203, 95, 97, 58);
        buttonC.setFont(buttonFont);
        buttonC.setForeground(Color.WHITE);
        buttonC.setBackground(darkGray);
        buttonC.addActionListener(controller);
        buttonC.setActionCommand("c");

        JButton buttonDel = new JButton("\u232B");
        buttonDel.setBounds(303, 95, 97, 58);
        buttonDel.setFont(buttonFont);
        buttonDel.setForeground(Color.WHITE);
        buttonDel.setBackground(darkGray);
        buttonDel.addActionListener(controller);
        buttonDel.setActionCommand("del");


        JButton buttonOneDelX = new JButton("1/x");
        buttonOneDelX.setBounds(3, 156, 97, 58);
        buttonOneDelX.setFont(buttonFont);
        buttonOneDelX.setForeground(Color.WHITE);
        buttonOneDelX.setBackground(darkGray);
        buttonOneDelX.addActionListener(controller);
        buttonOneDelX.setActionCommand("oneDelX");

        JButton buttonSquare = new JButton("^");
        buttonSquare.setBounds(103, 156, 97, 58);
        buttonSquare.setFont(buttonFont);
        buttonSquare.setForeground(Color.WHITE);
        buttonSquare.setBackground(darkGray);
        buttonSquare.addActionListener(controller);
        buttonSquare.setActionCommand("xsquare");

        JButton buttonSqrt = new JButton("\u221A");
        buttonSqrt.setBounds(203, 156, 97, 58);
        buttonSqrt.setFont(buttonFont);
        buttonSqrt.setForeground(Color.WHITE);
        buttonSqrt.setBackground(darkGray);
        buttonSqrt.addActionListener(controller);
        buttonSqrt.setActionCommand("sqrt");

        JButton buttonDivision = new JButton("/");
        buttonDivision.setBounds(303, 156, 97, 58);
        buttonDivision.setFont(buttonFont);
        buttonDivision.setForeground(Color.WHITE);
        buttonDivision.setBackground(darkGray);
        buttonDivision.addActionListener(controller);
        buttonDivision.setActionCommand("division");


        JButton buttonSeven = new JButton("7");
        buttonSeven.setBounds(3, 217, 97, 58);
        buttonSeven.setFont(buttonFont);
        buttonSeven.setBackground(gray);
        buttonSeven.addActionListener(controller);
        buttonSeven.setActionCommand("seven");

        JButton buttonEight = new JButton("8");
        buttonEight.setBounds(103, 217, 97, 58);
        buttonEight.setFont(buttonFont);
        buttonEight.setBackground(gray);
        buttonEight.addActionListener(controller);
        buttonEight.setActionCommand("eight");

        JButton buttonNine = new JButton("9");
        buttonNine.setBounds(203, 217, 97, 58);
        buttonNine.setFont(buttonFont);
        buttonNine.setBackground(gray);
        buttonNine.addActionListener(controller);
        buttonNine.setActionCommand("nine");

        JButton buttonMult = new JButton("x");
        buttonMult.setBounds(303, 217, 97, 58);
        buttonMult.setFont(buttonFont);
        buttonMult.setForeground(Color.WHITE);
        buttonMult.setBackground(darkGray);
        buttonMult.addActionListener(controller);
        buttonMult.setActionCommand("mult");


        JButton buttonFour = new JButton("4");
        buttonFour.setBounds(3, 278, 97, 58);
        buttonFour.setFont(buttonFont);
        buttonFour.setBackground(gray);
        buttonFour.addActionListener(controller);
        buttonFour.setActionCommand("four");

        JButton buttonFive = new JButton("5");
        buttonFive.setBounds(103, 278, 97, 58);
        buttonFive.setFont(buttonFont);
        buttonFive.setBackground(gray);
        buttonFive.addActionListener(controller);
        buttonFive.setActionCommand("five");

        JButton buttonSix = new JButton("6");
        buttonSix.setBounds(203, 278, 97, 58);
        buttonSix.setFont(buttonFont);
        buttonSix.setBackground(gray);
        buttonSix.addActionListener(controller);
        buttonSix.setActionCommand("six");

        JButton buttonMinus = new JButton("-");
        buttonMinus.setBounds(303, 278, 97, 58);
        buttonMinus.setFont(buttonFont);
        buttonMinus.setForeground(Color.WHITE);
        buttonMinus.setBackground(darkGray);
        buttonMinus.addActionListener(controller);
        buttonMinus.setActionCommand("minus");


        JButton buttonOne = new JButton("1");
        buttonOne.setBounds(3, 339, 97, 58);
        buttonOne.setFont(buttonFont);
        buttonOne.setBackground(gray);
        buttonOne.addActionListener(controller);
        buttonOne.setActionCommand("one");

        JButton buttonTwo = new JButton("2");
        buttonTwo.setBounds(103, 339, 97, 58);
        buttonTwo.setFont(buttonFont);
        buttonTwo.setBackground(gray);
        buttonTwo.addActionListener(controller);
        buttonTwo.setActionCommand("two");

        JButton buttonThree = new JButton("3");
        buttonThree.setBounds(203, 339, 97, 58);
        buttonThree.setFont(buttonFont);
        buttonThree.setBackground(gray);
        buttonThree.addActionListener(controller);
        buttonThree.setActionCommand("three");

        JButton buttonPlus = new JButton("+");
        buttonPlus.setBounds(303, 339, 97, 58);
        buttonPlus.setFont(buttonFont);
        buttonPlus.setForeground(Color.WHITE);
        buttonPlus.setBackground(darkGray);
        buttonPlus.addActionListener(controller);
        buttonPlus.setActionCommand("plus");

        //
        JButton buttonPlusMinus = new JButton("+/-");
        buttonPlusMinus.setBounds(3, 400, 97, 58);
        buttonPlusMinus.setFont(buttonFont);
        buttonPlusMinus.setBackground(gray);
        buttonPlusMinus.addActionListener(controller);
        buttonPlusMinus.setActionCommand("plusMinus");

        JButton buttonNull = new JButton("0");
        buttonNull.setBounds(103, 400, 97, 58);
        buttonNull.setFont(buttonFont);
        buttonNull.setBackground(gray);
        buttonNull.addActionListener(controller);
        buttonNull.setActionCommand("zero");

        JButton buttonDot = new JButton(".");
        buttonDot.setBounds(203, 400, 97, 58);
        buttonDot.setFont(buttonFont);
        buttonDot.setBackground(gray);
        buttonDot.addActionListener(controller);
        buttonDot.setActionCommand("dot");

        JButton buttonResult = new JButton("=");
        buttonResult.setBounds(303, 400, 97, 58);
        buttonResult.setFont(buttonFont);
        buttonResult.setForeground(Color.WHITE);
        buttonResult.setBackground(new Color(243, 156, 18));
        buttonResult.addActionListener(controller);
        buttonResult.setActionCommand("equal");

        frame.add(textField);
        frame.add(buttonPercent);
        frame.add(buttonCE);
        frame.add(buttonC);
        frame.add(buttonDel);
        frame.add(buttonOneDelX);
        frame.add(buttonSquare);
        frame.add(buttonSqrt);
        frame.add(buttonDivision);
        frame.add(buttonSeven);
        frame.add(buttonEight);
        frame.add(buttonNine);
        frame.add(buttonMult);
        frame.add(buttonFour);
        frame.add(buttonFive);
        frame.add(buttonSix);
        frame.add(buttonMinus);
        frame.add(buttonOne);
        frame.add(buttonTwo);
        frame.add(buttonThree);
        frame.add(buttonPlus);
        frame.add(buttonPlusMinus);
        frame.add(buttonNull);
        frame.add(buttonDot);
        frame.add(buttonResult);

        frame.setVisible(true);
    }

    public void update(String text) {
        textField.setText(text);
    }
}
