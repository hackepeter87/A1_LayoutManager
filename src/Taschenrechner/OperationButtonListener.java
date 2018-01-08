package Taschenrechner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationButtonListener implements ActionListener {
    private final JTextField textField;
    private final Rechner rechner;

    public OperationButtonListener(JTextField textField) {
        this.rechner = new Rechner();
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String op = ((JButton)actionEvent.getSource()).getText();
        double zahl = 0D;
        if (this.textField.getText().length()==0) {
            zahl = 0D;
        }else {
            zahl = Double.parseDouble(this.textField.getText());
        }
        switch (op) {
            case "C":
                this.textField.setText("");
                this.rechner.clear();
                break;
            case "+":
            case "-":
                this.rechner.setOperandB(zahl);
                this.rechner.setOperation(op);
                this.textField.setText("");
                break;
            case "=":
                this.rechner.setOperandB(zahl);
                this.rechner.setOperation("=");
                textField.setText(Double.toString(this.rechner.getErgebnis()));
                break;
        }
    }
}
