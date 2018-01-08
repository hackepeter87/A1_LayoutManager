import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zahlenumwandler {
    private final JFrame frame;
    private final JTextField eingabe;
    private final JTextField ausgabe;

    public Zahlenumwandler() {
        frame = new JFrame("Zahlenumwandler");
        eingabe = new JTextField(20);
        ausgabe = new JTextField(20);
        ausgabe.setEditable(false);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        northPanel.add(new JLabel("Eingabe", SwingConstants.LEFT));
        northPanel.add(eingabe);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        centerPanel.add(new JLabel("Ausgabe", SwingConstants.LEFT));
        centerPanel.add(ausgabe);

        JPanel southPanel = new JPanel();
        JButton hexButton = new JButton("in Hexadezimal");
        hexButton.addActionListener((ActionEvent actionEvent) -> {
            try {
                String str = Integer.toHexString(Integer.parseInt(this.eingabe.getText())).toUpperCase();
                this.ausgabe.setText(reformat(str, 2));
            } catch (NumberFormatException e) {
                this.ausgabe.setText("");
            }
        });

        JButton binaerButton = new JButton("in Binär");
        binaerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String str = Integer.toBinaryString(Integer.parseInt(Zahlenumwandler.this.eingabe.getText())).toUpperCase();
                    Zahlenumwandler.this.ausgabe.setText(reformat(str, 4));
                } catch (NumberFormatException e) {
                    Zahlenumwandler.this.ausgabe.setText("");
                }
            }
        });

        JButton dezimalButton = new JButton("in Oktal");
        dezimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String str = Integer.toOctalString(Integer.parseInt(eingabe.getText())).toUpperCase();
                    ausgabe.setText(reformat(str, 3));
                } catch (NumberFormatException e) {
                    ausgabe.setText("");
                }
            }
        });



        southPanel.add(hexButton);
        southPanel.add(binaerButton);
        southPanel.add(dezimalButton);

        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(southPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(frame.getSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private String reformat(String input, int distance) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= input.length(); i++) {
            sb.insert(0, input.charAt(input.length() - i));
            if (i % distance == 0 && i != input.length()) {
                sb.insert(0, " ");
            }
        }
        return sb.toString();
    }
}
