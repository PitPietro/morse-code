package tests.key_event_test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Made following http://ecomputernotes.com/java/swing/keyevent
 */
public class GUIKeyEvent extends JFrame implements KeyListener {
    private JLabel labelKeyTyped = new JLabel();
    private JLabel labelKeyPressed = new JLabel();
    private JLabel labelKeyReleased = new JLabel();
    JTextField textField;
    JLabel labelPrompt;
    JPanel labelPanel;
    JPanel labelNorth;

    public GUIKeyEvent() {
        setTitle("Java Example of Key Event");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField(10);
        labelPrompt = new JLabel("Press any keys:");
        labelPanel = new JPanel();
        labelNorth = new JPanel();
        labelPanel.setLayout(new GridLayout(3, 1));
        labelNorth.setLayout(new GridLayout(2, 1));

        add(labelNorth, BorderLayout.NORTH);
        labelNorth.add(labelPrompt);
        labelNorth.add(textField);

        add(labelPanel, BorderLayout.CENTER);
        labelPanel.add(labelKeyTyped);
        labelPanel.add(labelKeyPressed);
        labelPanel.add(labelKeyReleased);

        addKeyListener(this);
        textField.addKeyListener(this);
        setVisible(true);
    }

    public static void main(String[] args) {
        // set look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        GUIKeyEvent gui = new GUIKeyEvent();
        // close the operation of JFrame
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set size of JFrame.
        gui.setSize(500, 500);
        // set visible status of JFrame
        gui.setVisible(true);

        // SwingUtilities.invokeLater(() -> new FactoryShaper().setVisible(true));
    }

    public void keyTyped(KeyEvent keyEvent) {
        char keyChar = keyEvent.getKeyChar();
        int keyCode = keyEvent.getKeyCode();

        labelKeyTyped.setText("|keyTyped| getKeyChar: " + keyChar);
        labelKeyTyped.setText("|keyTyped| getKeyCode: " + keyCode);
    }

    public void keyPressed(KeyEvent Evnt) {
        char keyChar = Evnt.getKeyChar();
        labelKeyPressed.setText("|keyPressed| getKeyChar: " + keyChar);
    }

    public void keyReleased(KeyEvent Evnt) {
        char keyChar = Evnt.getKeyChar();
        labelKeyReleased.setText("|keyReleased| getKeyChar: " + keyChar);
    }
}

