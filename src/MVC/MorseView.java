package MVC;

import javafx.util.Pair;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static MVC.MorseModel.getMorsePair;
import static java.awt.event.KeyEvent.getKeyText;

/**
 * The Morse
 */
public class MorseView extends JFrame implements KeyListener, ActionListener {
    JLabel labelUserInput;
    JLabel labelFooter;
    JLabel labelControllerUserString;
    JLabel labelControllerMorseString;
    JTextField textUserInput;
    JPanel panelNorth;
    JPanel panelCenter;
    JPanel panelEast;
    JPanel panelSouth;
    JButton buttonSound;
    JButton buttonGitHubLink;
    private MorseController controller;
    private JLabel labelMorse;

    public MorseView() {
        setTitle("Morse GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textUserInput = new JTextField(10);
        labelUserInput = new JLabel("    Write here: ");

        labelMorse = new JLabel("", SwingConstants.CENTER);
        labelMorse.setFont(new Font("Serif", Font.PLAIN, 30));

        labelControllerUserString = new JLabel();
        labelControllerMorseString = new JLabel();
        labelFooter = new JLabel("This programme is under a MIT licence. Copyright (c) 2020 Pietro Poluzzi");

        buttonSound = new JButton("Play morse");
        buttonSound.addActionListener(this);
        buttonGitHubLink = new JButton("Open source!");
        buttonGitHubLink.addActionListener(this);

        panelNorth = new JPanel();
        panelNorth.setLayout(new GridLayout(2, 2));
        panelNorth.add(labelUserInput);
        panelNorth.add(textUserInput);
        panelNorth.add(labelControllerUserString);
        panelNorth.add(labelControllerMorseString);

        panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(1, 1));
        panelCenter.add(labelMorse);

        panelEast = new JPanel();
        panelEast.setLayout(new BorderLayout());
        panelEast.add(buttonSound, BorderLayout.NORTH);
        panelEast.add(buttonGitHubLink, BorderLayout.SOUTH);

        panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(1, 1));
        panelSouth.add(labelFooter);

        controller = new MorseController();

        add(panelNorth, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(panelEast, BorderLayout.EAST);
        add(panelSouth, BorderLayout.SOUTH);
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
        boolean isMorseElement = controller.isElement(keyText);

        labelMorse.setText(pairedValue);

        if (isMorseElement) {
            controller.addElementToUserString(keyText);
            controller.addElementToMorseString(pairedValue);
        }

        labelControllerUserString.setText(controller.userStringToString());
        labelControllerMorseString.setText(controller.morseStringToString());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == buttonSound) {
            controller.playMorse();
        } else if (actionEvent.getSource() == buttonGitHubLink) {
            controller.openProjectURL();
        }
    }
}
