package Taschenrechner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberButtonListener implements ActionListener {
    private final JTextField textField;

    public NumberButtonListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String text = actionEvent.getActionCommand();
        String number = null;
        switch (text) {
            case "zero":
                number = "0";
                break;
            case "one":
                number = "1";
                break;
            case "two":
                number = "2";
                break;
            case "three":
                number = "3";
                break;
            case "four":
                number = "4";
                break;
            case "five":
                number = "5";
                break;
            case "six":
                number = "6";
                break;
            case "seven":
                number = "7";
                break;
            case "eight":
                number = "8";
                break;
            case "nine":
                number = "9";
                break;
            default:
                System.exit(-1);
        }
        textField.setText(textField.getText() + number);
    }
}
