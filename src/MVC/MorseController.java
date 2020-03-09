package MVC;

import javafx.util.Pair;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import static MVC.SoundModel.playSound;

/**
 * Saves the user interaction whit the View and interact with the Model
 */
public class MorseController {
    public static final String DOT_PATH = "src/audio_files/dot.wav";
    public static final String LINE_PATH = "src/audio_files/line.wav";
    public static final String PAUSE_PATH = "src/audio_files/pause.wav";
    private static final String SHORT_PAUSE_PATH = "src/audio_files/short-pause.wav";
    private static int index;
    private ArrayList<String> userString;
    private ArrayList<String> morseString;

    public MorseController() {
        userString = new ArrayList<>();
        morseString = new ArrayList<>();
        index = 0;
    }

    public boolean isElement(String element) {
        switch (element) {
            case "Shift":
            case "Ctrl":
            case "Alt":
            case "Alt Graph":
            case "Unknown keyCode: 0x0":
            case "Up":
            case "Down":
            case "Enter":
            case "Quote":
                return false;
            case "Left":
                index++;
                return false;
            case "Right":
                index--;
                return false;
            case "Space":
                addElementToUserString(" ");
                addElementToMorseString(" ");
                return false;
            case "Backspace":
                if (userString.size() > 0) {
                    userString.remove(morseString.size() - index - 1);
                    morseString.remove(morseString.size() - index - 1);
                }
                return false;
            default:
                return true;
        }
    }

    public void addElementToUserString(String element) {
        userString.add(element);
    }

    public void addElementToMorseString(String element) {
        morseString.add(element);
    }

    public String userStringToString() {
        StringBuilder msg = new StringBuilder("    ");
        for (String morseStrings : userString) {
            msg.append(morseStrings);
            msg.append("  ");
        }
        return msg.toString();
    }

    public String morseStringToString() {
        StringBuilder msg = new StringBuilder();
        for (String morseStrings : morseString) {
            msg.append(morseStrings);
            msg.append("  ");
            System.out.println(msg);
        }
        return msg.toString();
    }

    public void playMorse() {
        for (int i = 0; i < morseString.size(); ++i) {
            String mString = morseString.get(i);
            for (int j = 0; j < mString.length(); ++j) {
                char mChar = mString.charAt(j);
                switch (mChar) {
                    case '.': {
                        playSound(DOT_PATH);
                        // make a short pause between each letter
                        playSound(SHORT_PAUSE_PATH);
                    }
                    break;
                    case '-': {
                        playSound(LINE_PATH);
                        playSound(SHORT_PAUSE_PATH);
                    }
                    break;
                    case ' ':
                        playSound(PAUSE_PATH);
                        break;
                    default:
                        System.out.println("Play NOTHING");
                }
            }
        }
    }

    public void openProjectURL() {
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/PitPietro/morse-code").toURI());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
