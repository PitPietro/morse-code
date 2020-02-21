package MVC;

import java.util.ArrayList;

/**
 * Saves the user interaction whit the View and interact with the Model
 */
public class MorseController {
    private ArrayList<String> userString;
    private ArrayList<String> morseString;

    public MorseController() {
        userString = new ArrayList<>();
        morseString = new ArrayList<>();
    }

    public boolean isElement(String element) {
        switch (element) {
            case "Shift":
            case "Ctrl":
            case "Alt":
            case "Alt Graph":
                return false;
            case "Space":
                addElementToUserString(" ");
                addElementToMorseString(" ");
                return false;
            case "Backspace":
                if (userString.size() > 0) {
                    userString.remove(userString.size() - 1);
                    morseString.remove(morseString.size() - 1);
                }
                return false;
            default:
                return true;
        }
    }

    public void addElementToUserString(String element) {
        userString.add(element);
    }

    private void deleteElementToMorseString() {
        morseString.remove(morseString.size()-1);
    }

    public void addElementToMorseString(String element) {
        morseString.add(element);
    }

    public ArrayList<String> getUserString() {
        return userString;
    }

    public void setUserString(ArrayList<String> userString) {
        this.userString = userString;
    }

    public ArrayList<String> getMorseString() {
        return morseString;
    }

    public void setMorseString(ArrayList<String> morseString) {
        this.morseString = morseString;
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
}
