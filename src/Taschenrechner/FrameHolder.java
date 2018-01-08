package Taschenrechner;

import javax.swing.*;
import java.awt.*;

public class FrameHolder {
    private final JFrame frame;

    public FrameHolder() {
        this.frame = new JFrame("Taschenrechner");
        this.frame.add(createContentPanel());
        this.frame.pack();
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }

    public JPanel createContentPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        JTextField textField = new JTextField(20);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        panel.setLayout(new BorderLayout(5,5));
        panel.add(textField, BorderLayout.NORTH);

        JPanel nummernBlock = new JPanel();
        nummernBlock.setLayout(new GridLayout(4,3,2,2));
        nummernBlock.add(new JButton("7"));
        nummernBlock.add(new JButton("8"));
        nummernBlock.add(new JButton("9"));
        nummernBlock.add(new JButton("4"));
        nummernBlock.add(new JButton("5"));
        nummernBlock.add(new JButton("6"));
        nummernBlock.add(new JButton("1"));
        nummernBlock.add(new JButton("2"));
        nummernBlock.add(new JButton("3"));
        nummernBlock.add(new JButton("."));
        nummernBlock.add(new JButton("0"));
        nummernBlock.add(new JButton("+/-"));
        NumberButtonListener numListener = new NumberButtonListener(textField);
        ModifierButtonListener modListener = new ModifierButtonListener(textField);
        for(Component c : nummernBlock.getComponents()) {
            if(((JButton) c).getText().contains(".") || ((JButton) c).getText().contains("+/-")) {
                ((JButton) c).addActionListener(modListener);
            } else {
                ((JButton) c).addActionListener(numListener);
            }
        }
        panel.add(nummernBlock, BorderLayout.CENTER);


        JPanel opBlock = new JPanel();
        opBlock.setLayout(new GridLayout(4,1,2,2));
        opBlock.add(new JButton("C"));
        opBlock.add(new JButton("+"));
        opBlock.add(new JButton("-"));
        opBlock.add(new JButton("="));
        OperationButtonListener opListener = new OperationButtonListener(textField);
        for(Component c: opBlock.getComponents()) {
            ((JButton) c).addActionListener(opListener);
        }

        panel.add(opBlock, BorderLayout.EAST);

        return panel;
    }
}
