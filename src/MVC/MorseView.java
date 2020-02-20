package MVC;

import javafx.util.Pair;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static MVC.MorseModel.getMorsePair;
import static java.awt.event.KeyEvent.getKeyText;

/**
 * The Morse
 */
public class MorseView extends JFrame implements KeyListener {
    private MorseController controller;
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
        labelUserInput = new JLabel("    Write here: ");
        labelMorse = new JLabel("", SwingConstants.CENTER);
        labelMorse.setFont(new Font("Serif", Font.PLAIN, 20));

        panelNorth = new JPanel();
        panelNorth.setLayout(new GridLayout(1, 2));
        panelNorth.add(labelUserInput);
        panelNorth.add(textUserInput);

        panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(1, 1));
        panelCenter.add(labelMorse);

        labelFooter = new JLabel("This programme is under a MIT licence");

        controller = new MorseController();

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
        String keyText = getKeyText(keyCode);
        String pairedValue = pair.getValue();

        labelMorse.setText(pairedValue);
        controller.addElementToUserString(keyText);
        controller.addElementToMorseString(pairedValue);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
