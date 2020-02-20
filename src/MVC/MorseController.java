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

    public void addElementToUserString(String element) {
        if (element.equals("Backspace")) {
            userString.remove(userString.size()-1);
            deleteElementToMorseString();
        } else {
            userString.add(element);
        }

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
        }
        return msg.toString();
    }
}
