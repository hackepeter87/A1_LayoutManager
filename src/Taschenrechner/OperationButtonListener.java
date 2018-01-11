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
        String op = actionEvent.getActionCommand();
        double zahl = 0D;
        if (this.textField.getText().length()==0) {
            zahl = 0D;
        }else {
            zahl = Double.parseDouble(this.textField.getText());
        }
        switch (op) {
            case "clear":
                this.textField.setText("");
                this.rechner.clear();
                break;
            case "plus":
                this.rechner.setOperandA(zahl);
                this.rechner.setOperation("+");
                this.textField.setText("");
                break;
            case "minus":
                this.rechner.setOperandA(zahl);
                this.rechner.setOperation("-");
                this.textField.setText("");
                break;
            case "equals":
                this.rechner.setOperandB(zahl);
                this.rechner.executeOperation();
                textField.setText(Double.toString(this.rechner.getErgebnis()));
                break;
        }
    }
}
