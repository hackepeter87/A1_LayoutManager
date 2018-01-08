package Uebung_SenderEmpfaenger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SenderGui {
    private Sender sender;
    private final JFrame frame;
    private final JTextField textField;

    public SenderGui(Sender sender) {
        this.sender = sender;
        this.frame = new JFrame("SenderGui");
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.textField = new JTextField(50);
        this.frame.add(textField);

        JButton button = new JButton("Senden");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sender.sende(textField.getText());
            }
        });
        this.frame.add(button, BorderLayout.SOUTH);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }

    public void doAnmelden(Empfaenger empfaenger) {
        this.sender.anmelden(empfaenger);
    }
}
