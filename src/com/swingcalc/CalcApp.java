package swingcalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class CalcApp extends JFrame {
    private JPanel contentPane;
    private JTextField calcField;
    private JLabel calcLabel;
    private JButton buttonCursor;
    private JButton cButton;
    private JButton buttonPlus;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonPoint;
    private JButton buttonEquals;
    private JButton buttonSqrt;
    private JButton buttonDiv;
    private JButton buttonMultiply;
    private JButton buttonMinus;
    private JRadioButton addRB;
    private JRadioButton subtractRB;
    private JRadioButton multRB;
    private JRadioButton sqrtRB;
    private JRadioButton divRB;

    private double num,ans;
    private int calculation;

    public CalcApp() {
        super("Калькулятор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(contentPane);
        addButtonListeners();
        addPluginListeners();
        setUnvisibleOperationBtn();
        calcField.addKeyListener(calcFieldKL);
    }

    public void arithmeticOperation() {
        switch(calculation){
            case 1:  // Sum
                ans = num + Double.parseDouble(calcField.getText());
                calcField.setText(Double.toString(ans));
                break;
            case 2:  // Subtraction
                ans = num - Double.parseDouble(calcField.getText());
                calcField.setText(Double.toString(ans));
                break;
            case 3:  // Multiplication
                ans = num * Double.parseDouble(calcField.getText());
                ans = new BigDecimal(ans).setScale(12, RoundingMode.UP).doubleValue();
                calcField.setText(Double.toString(ans));
                break;
            case 4:  // Division
                ans = num / Double.parseDouble(calcField.getText());
                ans = new BigDecimal(ans).setScale(12, RoundingMode.UP).doubleValue();
                calcField.setText(Double.toString(ans));
                break;
            case 5:  // Sqrt
                ans = Math.sqrt(num);
                ans = new BigDecimal(ans).setScale(12, RoundingMode.UP).doubleValue();
                calcField.setText(Double.toString(ans));
                break;
        }
    }

    private void setUnvisibleOperationBtn() {
        buttonPlus.setVisible(false);
        buttonMinus.setVisible(false);
        buttonMultiply.setVisible(false);
        buttonDiv.setVisible(false);
        buttonSqrt.setVisible(false);
    }

    private  void addButtonListeners() {
        button0.addActionListener(numberBtnListener);
        button1.addActionListener(numberBtnListener);
        button2.addActionListener(numberBtnListener);
        button3.addActionListener(numberBtnListener);
        button4.addActionListener(numberBtnListener);
        button5.addActionListener(numberBtnListener);
        button6.addActionListener(numberBtnListener);
        button7.addActionListener(numberBtnListener);
        button8.addActionListener(numberBtnListener);
        button9.addActionListener(numberBtnListener);
        buttonPlus.addActionListener(operationBtnListener);
        buttonMinus.addActionListener(operationBtnListener);
        buttonMultiply.addActionListener(operationBtnListener);
        buttonDiv.addActionListener(operationBtnListener);
        buttonSqrt.addActionListener(operationBtnListener);
        buttonPoint.addActionListener(operationBtnListener);
        cButton.addActionListener(operationBtnListener);
        buttonCursor.addActionListener(operationBtnListener);
        buttonEquals.addActionListener(operationBtnListener);
    }

    private  void addPluginListeners() {
        addRB.addActionListener(pluginListener);
        subtractRB.addActionListener(pluginListener);
        multRB.addActionListener(pluginListener);
        divRB.addActionListener(pluginListener);
        sqrtRB.addActionListener(pluginListener);
    }

    private ActionListener pluginListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(addRB)) {
                if (addRB.isSelected()) {
                    buttonPlus.setVisible(true);
                } else
                    buttonPlus.setVisible(false);
            } else if(e.getSource().equals(subtractRB)) {
                if (subtractRB.isSelected()) {
                    buttonMinus.setVisible(true);
                } else
                    buttonMinus.setVisible(false);
            } else if(e.getSource().equals(multRB)) {
                if (multRB.isSelected()) {
                    buttonMultiply.setVisible(true);
                } else
                    buttonMultiply.setVisible(false);
            } else if(e.getSource().equals(divRB)) {
                if (divRB.isSelected()) {
                    buttonDiv.setVisible(true);
                } else
                    buttonDiv.setVisible(false);
            } else if(e.getSource().equals(sqrtRB)) {
                if (sqrtRB.isSelected()) {
                    buttonSqrt.setVisible(true);
                } else
                    buttonSqrt.setVisible(false);
            }
        }
    };

    private ActionListener numberBtnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(button0)) {
                calcField.setText(calcField.getText() + "0");
            } else if(e.getSource().equals(button1)) {
                calcField.setText(calcField.getText() + "1");
            } else if(e.getSource().equals(button2)) {
                calcField.setText(calcField.getText() + "2");
            } else if(e.getSource().equals(button3)) {
                calcField.setText(calcField.getText() + "3");
            } else if(e.getSource().equals(button4)) {
                calcField.setText(calcField.getText() + "4");
            } else if(e.getSource().equals(button5)) {
                calcField.setText(calcField.getText() + "5");
            } else if(e.getSource().equals(button6)) {
                calcField.setText(calcField.getText() + "6");
            } else if(e.getSource().equals(button7)) {
                calcField.setText(calcField.getText() + "7");
            } else if(e.getSource().equals(button8)) {
                calcField.setText(calcField.getText() + "8");
            } else if(e.getSource().equals(button9)) {
                calcField.setText(calcField.getText() + "9");
            }
        }
    };

    private ActionListener operationBtnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(buttonPlus)) {
                num = Double.parseDouble(calcField.getText());
                calculation = 1;
                calcLabel.setText(num + "+");
                calcField.setText("");
            } else if (e.getSource().equals(buttonMinus)) {
                num = Double.parseDouble(calcField.getText());
                calculation = 2;
                calcLabel.setText(num + "-");
                calcField.setText("");
            } else if (e.getSource().equals(buttonMultiply)) {
                num = Double.parseDouble(calcField.getText());
                calculation = 3;
                calcLabel.setText(num + "*");
                calcField.setText("");
            } else if (e.getSource().equals(buttonDiv)) {
                num = Double.parseDouble(calcField.getText());
                calculation = 4;
                calcLabel.setText(num + "/");
                calcField.setText("");
            } else if (e.getSource().equals(buttonSqrt)) {
                num = Double.parseDouble(calcField.getText());
                calculation = 5;
                calcLabel.setText("");
                arithmeticOperation();
            }else if (e.getSource().equals(cButton)) {
                calcField.setText("");
                calcLabel.setText("");
            } else if (e.getSource().equals(buttonPoint)) {
                if (!calcField.getText().contains("."))
                    calcField.setText(calcField.getText() + ".");
            } else if (e.getSource().equals(buttonCursor)) {
                int length = calcField.getText().length();
                int number = length - 1;
                String store;
                if (length > 0) {
                    StringBuffer back = new StringBuffer(calcField.getText());
                    back.deleteCharAt(number);
                    store = back.toString();
                    calcField.setText(store);
                }
            } else if (e.getSource().equals(buttonEquals)) {
                arithmeticOperation();
            }
        }
    };

    private KeyListener calcFieldKL = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if(c=='.'&& !calcField.getText().contains(".")) {

            } else if ( ((c < '0') || (c > '9'))) {
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };
}
