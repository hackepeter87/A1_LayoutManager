import javax.swing.*;
import java.awt.*;

public class Layouts {
    private final JFrame frameBorder;
    private final JFrame frameGrid;
    private final JFrame frame;

    public Layouts() {

        frame = new JFrame("Layouts");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());


        frameBorder = new JFrame("BorderLayout");
        frameBorder.setSize(300, 200);
        frameBorder.setLayout(new BorderLayout());

        frameBorder.add(new JLabel("Norden", SwingConstants.CENTER), BorderLayout.NORTH);
        frameBorder.add(new JLabel("Süden", SwingConstants.CENTER), BorderLayout.SOUTH);
        frameBorder.add(new JLabel("Osten", SwingConstants.CENTER), BorderLayout.EAST);
        frameBorder.add(new JLabel("Westen", SwingConstants.CENTER), BorderLayout.WEST);
        frameBorder.add(new JLabel("Center", SwingConstants.CENTER), BorderLayout.CENTER);


        frameGrid = new JFrame("GridLayout");
        frameGrid.setSize(300, 200);
        frameGrid.setLayout(new GridLayout(3, 2));

        frameGrid.add(new JLabel("1 / 1", SwingConstants.CENTER));
        frameGrid.add(new JLabel("1 / 2", SwingConstants.CENTER));
        frameGrid.add(new JLabel("2 / 1", SwingConstants.CENTER));
        frameGrid.add(new JLabel("2 / 2", SwingConstants.CENTER));
        frameGrid.add(new JLabel("3 / 1", SwingConstants.CENTER));
        frameGrid.add(new JLabel("3 / 2", SwingConstants.CENTER));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton buttonToBorder = new JButton("BorderLayout");
        JButton buttonToGrid = new JButton("GridLayout");
        buttonToBorder.addActionListener(a -> {
            frameBorder.setLocationRelativeTo(frame);
            frameBorder.setLocation(frame.getLocation().x - frameBorder.getWidth() / 2 - 5, frame.getLocation().y + frame.getHeight() + 10);
            frameBorder.setVisible(true);
        });
        buttonToGrid.addActionListener(a -> {
            frameGrid.setLocationRelativeTo(frame);
            frameGrid.setLocation(frame.getLocation().x + frameGrid.getWidth() / 2 + 5, frame.getLocation().y + frame.getHeight() + 10);
            frameGrid.setVisible(true);
        });

        frame.add(buttonToBorder);
        frame.add(buttonToGrid);
        frame.pack();
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        new Layouts();
    }
}
