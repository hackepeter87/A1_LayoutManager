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
        switch (text) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                textField.setText(textField.getText() + text);
                break;

        }


    }
}
