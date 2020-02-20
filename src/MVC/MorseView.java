package MVC;

import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static MVC.MorseModel.getMorsePair;

public class MorseView extends JFrame implements KeyListener {
    private JLabel labelMorse;
    JLabel labelUserInput;
    JLabel labelFooter;

    JTextField textUserInput;

    JPanel panelNorth;
    JPanel panelCenter;

    public MorseView() {
        setTitle("Morse GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textUserInput = new JTextField(10);
        labelUserInput = new JLabel("Write here: ");
        labelMorse = new JLabel();

        panelNorth = new JPanel();
        panelNorth.setLayout(new GridLayout(1, 2));
        panelNorth.add(labelUserInput);
        panelNorth.add(textUserInput);

        panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(1, 1));
        panelCenter.add(labelMorse);

        labelFooter = new JLabel("This programme is under a MIT licence");

        add(panelNorth, BorderLayout.NORTH);
        add(labelFooter, BorderLayout.SOUTH);
        add(panelCenter, BorderLayout.CENTER);
        addKeyListener(this);
        textUserInput.addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Pair<Integer, String> pair = getMorsePair(keyCode);
        labelMorse.setText(pair.getValue());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
