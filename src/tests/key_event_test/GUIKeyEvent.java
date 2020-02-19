package tests.key_event_test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.getExtendedKeyCodeForChar;
import static java.awt.event.KeyEvent.getKeyText;

public class GUIKeyEvent extends JFrame implements KeyListener {
    JTextField textField;
    JLabel labelPrompt;
    JPanel panelEast;
    JPanel panelWest;
    JPanel labelNorth;

    private JLabel labelKeyTypedChar = new JLabel();
    private JLabel labelKeyPressedChar = new JLabel();
    private JLabel labelKeyReleasedChar = new JLabel();

    private JLabel labelKeyTypedCode = new JLabel();
    private JLabel labelKeyPressedCode = new JLabel();
    private JLabel labelKeyReleasedCode = new JLabel();

    private JLabel labelKeyPressedText = new JLabel();
    private JLabel labelKeyPressedLocation = new JLabel();
    private JLabel labelExtendedKeyCode = new JLabel();
    private JLabel labelExtendedKeyCodeforChar = new JLabel();

    public GUIKeyEvent() {
        setTitle("Java Key Event");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField(10);
        labelPrompt = new JLabel("Press any keys:");
        panelEast = new JPanel();
        panelWest = new JPanel();
        labelNorth = new JPanel();

        panelEast.setLayout(new GridLayout(4, 1));
        panelWest.setLayout(new GridLayout(6, 1));
        labelNorth.setLayout(new GridLayout(2, 1));

        add(labelNorth, BorderLayout.NORTH);
        labelNorth.add(labelPrompt);
        labelNorth.add(textField);

        add(panelEast, BorderLayout.EAST);
        add(panelWest, BorderLayout.WEST);

        panelEast.add(labelKeyTypedChar);
        panelEast.add(labelKeyTypedCode);
        panelEast.add(labelKeyReleasedChar);
        panelEast.add(labelKeyReleasedCode);

        panelWest.add(labelKeyPressedChar);
        panelWest.add(labelKeyPressedCode);
        panelWest.add(labelKeyPressedLocation);
        panelWest.add(labelKeyPressedText);
        panelWest.add(labelExtendedKeyCode);
        panelWest.add(labelExtendedKeyCodeforChar);

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
        gui.setSize(800, 800);
        // set visible status of JFrame
        gui.setVisible(true);

        // SwingUtilities.invokeLater(() -> new FactoryShaper().setVisible(true));
    }

    public void keyTyped(KeyEvent keyEvent) {
        char keyChar = keyEvent.getKeyChar();
        int keyCode = keyEvent.getKeyCode();

        labelKeyTypedChar.setText("|keyTyped| getKeyChar: " + keyChar);
        labelKeyTypedCode.setText("|keyTyped| getKeyCode: " + keyCode);
    }

    public void keyPressed(KeyEvent keyEvent) {
        char keyChar = keyEvent.getKeyChar();
        int keyCode = keyEvent.getKeyCode();
        int keyLocation = keyEvent.getKeyLocation();
        String keyText = getKeyText(keyCode);
        int extendedKeyCode = keyEvent.getExtendedKeyCode();
        int extendedKeyCodeForChar = getExtendedKeyCodeForChar(keyCode);

        labelKeyPressedChar.setText("|keyPressed| getKeyChar: " + keyChar);
        labelKeyPressedCode.setText("|keyPressed| getKeyCode: " + keyCode);
        labelKeyPressedText.setText("|keyPressed| getKeyText: " + keyText);
        labelKeyPressedLocation.setText("|keyPressed| getKeyLocation: " + keyLocation);
        labelExtendedKeyCode.setText("|keyPressed| getExtendedKeyCode: " + extendedKeyCode);
        labelExtendedKeyCodeforChar.setText("|keyPressed| getExtendedKeyCodeForChar: " + extendedKeyCodeForChar);
    }

    public void keyReleased(KeyEvent keyEvent) {
        char keyChar = keyEvent.getKeyChar();
        int keyCode = keyEvent.getKeyCode();

        labelKeyReleasedChar.setText("|keyReleased| getKeyChar: " + keyChar);
        labelKeyReleasedCode.setText("|keyReleased| getKeyCode: " + keyCode);
    }
}