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
        userString.add(element);
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
}
