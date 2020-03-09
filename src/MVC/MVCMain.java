package MVC;

import tests.key_event_test.GUIKeyEvent;

import javax.swing.*;

/**
 * Build and run the application:
 * https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#run_app
 * The tutorial also show how to package in application in a JAR, run the package application
 */
public class MVCMain {
    public static void main(String[] args) {
        // set look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        MorseView view = new MorseView();
        // set size of JFrame.
        view.setSize(800, 800);
        // set visible status of JFrame
        view.setVisible(true);
    }
}
