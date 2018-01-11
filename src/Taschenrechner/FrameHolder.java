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
        JButton button;
        nummernBlock.setLayout(new GridLayout(4,3,2,2));
        button = new JButton("7");
        button.setActionCommand("seven");
        nummernBlock.add(button);
        button = new JButton("8");
        button.setActionCommand("eight");
        nummernBlock.add(button);
        button = new JButton("9");
        button.setActionCommand("nine");
        nummernBlock.add(button);
        button = new JButton("4");
        button.setActionCommand("four");
        nummernBlock.add(button);
        button = new JButton("5");
        button.setActionCommand("five");
        nummernBlock.add(button);
        button = new JButton("6");
        button.setActionCommand("six");
        nummernBlock.add(button);
        button = new JButton("1");
        button.setActionCommand("one");
        nummernBlock.add(button);
        button = new JButton("2");
        button.setActionCommand("two");
        nummernBlock.add(button);
        button = new JButton("3");
        button.setActionCommand("three");
        nummernBlock.add(button);
        button = new JButton(".");
        button.setActionCommand("period");
        nummernBlock.add(button);
        button = new JButton("0");
        button.setActionCommand("zero");
        nummernBlock.add(button);
        button = new JButton("+/-");
        button.setActionCommand("sign");
        nummernBlock.add(button);

        NumberButtonListener numListener = new NumberButtonListener(textField);
        ModifierButtonListener modListener = new ModifierButtonListener(textField);
        for(Component c : nummernBlock.getComponents()) {
            JButton b = (JButton) c;
            if(b.getText().contains(".") || b.getText().contains("+/-")) {
                b.addActionListener(modListener);
            } else {
                b.addActionListener(numListener);
            }
        }
        panel.add(nummernBlock, BorderLayout.CENTER);


        JPanel opBlock = new JPanel();
        opBlock.setLayout(new GridLayout(4,1,2,2));
        button = new JButton("C");
        button.setActionCommand("clear");
        opBlock.add(button);
        button = new JButton("+");
        button.setActionCommand("plus");
        opBlock.add(button);
        button = new JButton("-");
        button.setActionCommand("minus");
        opBlock.add(button);
        button = new JButton("=");
        button.setActionCommand("equals");
        opBlock.add(button);
        OperationButtonListener opListener = new OperationButtonListener(textField);
        for(Component c: opBlock.getComponents()) {
            ((JButton) c).addActionListener(opListener);
        }

        panel.add(opBlock, BorderLayout.EAST);

        return panel;
    }
}
