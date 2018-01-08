package Taschenrechner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifierButtonListener implements ActionListener {
    private final JTextField textField;

    public ModifierButtonListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String text = ((JButton) actionEvent.getSource()).getText();
        switch (text) {
            case ".":
                if (!textField.getText().contains(".")) {
                    if (textField.getText().length() == 0) {
                        textField.setText("0");
                    }
                    textField.setText(textField.getText() + ".");
                }
                break;
            case "+/-":
                String inhalt = textField.getText();
                if (inhalt.charAt(0) == '-') {
                    textField.setText(inhalt.substring(1, inhalt.length()));
                } else {
                    textField.setText("-" + inhalt);
                }
                break;
        }
    }
}
