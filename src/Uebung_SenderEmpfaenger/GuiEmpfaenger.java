package Uebung_SenderEmpfaenger;

import javax.swing.*;
import java.awt.*;

public class GuiEmpfaenger implements Empfaenger {
    private final JFrame frame;
    private final JTextField textField;

    public GuiEmpfaenger() {
        this.frame = new JFrame("GuiEmpfänger");
        this.frame.add(new JLabel("Letzte empfangene Nachricht:"), BorderLayout.NORTH);
        this.textField = new JTextField(50);
        this.textField.setEditable(false);
        this.frame.add(textField);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }

    @Override
    public void empfange(String nachricht) {
        this.textField.setText(nachricht);
    }
}
