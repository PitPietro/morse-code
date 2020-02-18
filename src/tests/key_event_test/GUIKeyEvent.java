package tests.key_event_test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Made following http://ecomputernotes.com/java/swing/keyevent
 */
public class GUIKeyEvent extends JFrame implements KeyListener {
    private JLabel LblOutPt = new JLabel("Key Typed is:");
    private JTextField Txt = new JTextField(10);

    public GUIKeyEvent() {
        setTitle("Java Example of Key Event");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JLabel lblPrmpt = new JLabel("Press keys as Desired Below:");
        add(lblPrmpt, BorderLayout.NORTH);
        add(Txt, BorderLayout.CENTER);
        add(LblOutPt, BorderLayout.SOUTH);
        addKeyListener(this);
        Txt.addKeyListener(this);
    }

    public static void main(String[] ar) {
        GUIKeyEvent Frm = new GUIKeyEvent();
        final int WIDTH = 500;
        final int HEIGHT = 500;
        Frm.setSize(WIDTH, HEIGHT);
        Frm.setVisible(true);
    }

    public void keyTyped(KeyEvent Evnt) {
        char s = Evnt.getKeyChar();
        LblOutPt.setText("Last key Pressed:" + s);
    }

    public void keyPressed(KeyEvent Evnt) {
    }

    public void keyReleased(KeyEvent Evnt) {
    }
}

