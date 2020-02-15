package java_morse;

import sound_test.clip.ClipAudioPlayer;

import java.util.ArrayList;

public class JMorse {
    private String[][] morse = {
            {"A", ".-"},
            {"B", "-..."},
            {"C", "-.-."},
            {"D", "-.."},
            {"E", "."},
            {"F", "..-."},
            {"G", "--."},
            {"H", "...."},
            {"I", ".."},
            {"J", ".---"},
            {"K", "-.-"},
            {"L", ".-.."},
            {"M", "--"},
            {"N", "-."},
            {"O", "---"},
            {"P", ".--."},
            {"Q", "--.-"},
            {"R", ".-."},
            {"S", "..."},
            {"T", "-"},
            {"U", "..-"},
            {"V", "...-"},
            {"W", ".--"},
            {"X", "-..-"},
            {"Y", "-.--"},
            {"Z", "--.."},
            {"0", "-----"},
            {"1", ".----"},
            {"2", "..---"},
            {"3", "...--"},
            {"4", "....-"},
            {"5", "....."},
            {"6", "-...."},
            {"7", "--..."},
            {"8", "---.."},
            {"9", "----."},
    };

    /**
     * It stores the message the user want to translate
     */
    private ArrayList<String> plaintext;

    public JMorse() {
        plaintext = new ArrayList<>();
    }

    /**
     * Fills the 'plaintext' variable whit the user's input.
     * It makes all the letters uppercase so that they can be
     * compared with the once stored in the multidimensional array
     * @param s user input
     */
    public void fillText(String s) {
        s = s.toUpperCase();
        for(int i = 0; i < s.length(); i++) {
            plaintext.add(String.valueOf(s.charAt(i)));
        }
    }

    /**
     * The foreach loop calls 'getMorseFromChar' for each character of the
     * 'plaintext' ArrayList printing the Morse code
     */
    public void printMorse() {
        for (String s : plaintext) {
            System.out.print(getMorseFromChar(s) + "\t");
            if(s.equals(" ")) {
                System.out.print("\n");
            }
        }
    }

    /**
     * Takes as parameter a letter or a number and returns the given Morse element
     * @param c a letter or a number that can be translated by the Morse alphabet
     * @return Morse char
     */
    public String getMorseFromChar(String c) {
        String msg = "";
        for (String[] strings : morse) {
            if (strings[0].equals(c)) {
                msg = strings[1];
                getSoundFromMorse(strings[1]);
                break;
            }
        }
        return msg;
    }

    /**
     * Takes as parameter a morse string from the multidimensional array. Foreach character of the string, check
     * if it is a line or a dot and play the right audio file.
     * @param morseString morse string
     */
    private void getSoundFromMorse(String morseString) {
        for (int i = 0; i < morseString.length(); ++i) {
            char morseChar = morseString.charAt(i);
            if(morseChar == '.') {
                new ClipAudioPlayer().play("src/dot.wav");
            } else if(morseChar == '-') {
                new ClipAudioPlayer().play("src/line.wav");
            }
        }
    }
}