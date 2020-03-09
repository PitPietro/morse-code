package tests.pair;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class PairMorseTest {
    // short list of Morse String
    public final static ArrayList<Pair<Integer, String>> pairArrayList =
            new ArrayList<>(Arrays.asList(
                    new Pair<>(44, "--..--"), // comma
                    new Pair<>(46, ".-.-.-"), // dot
                    // keyboard numbers
                    new Pair<>(48, "-----"), // 0
                    new Pair<>(49, ".----"), // 1
                    new Pair<>(50, "..---"),
                    new Pair<>(51, "...--"),
                    new Pair<>(52, "....-"),
                    new Pair<>(53, "....."), // 5
                    new Pair<>(54, "-...."),
                    new Pair<>(55, "--..."),
                    new Pair<>(56, "---.."),
                    new Pair<>(57, "----."), // 9
                    // letters
                    new Pair<>(65, ".-"), // A
                    new Pair<>(66, "-..."),
                    new Pair<>(67, "-.-."),
                    new Pair<>(68, "-.."),
                    new Pair<>(69, "."),
                    new Pair<>(70, "..-."),
                    new Pair<>(71, "--."),
                    new Pair<>(72, "...."),
                    new Pair<>(73, ".."),
                    new Pair<>(74, ".---"),
                    new Pair<>(75, "-.-"),
                    new Pair<>(76, ".-..") // L
            ));

    public static Pair<Integer, String> getMaximum(ArrayList<Pair<Integer, String>> list) {

        // Assign minimum value initially
        int max = Integer.MIN_VALUE;

        // Pair to store the maximum marks of a student with its name
        Pair<Integer, String> ans = new Pair<>(0, "");

        // Using for each loop to iterate array of Pair Objects
        for (Pair<Integer, String> temp : list) {
            // Get the score of Student
            int val = temp.getKey();

            // Check if it is greater than the previous
            // maximum marks
            if (val > max) {
                max = val; // update maximum
                ans = temp; // update the Pair
            }
        }
        return ans;
    }

    public static Pair<Integer, String> getMorsePair(Integer number) {
        for (Pair<Integer, String> integerStringPair : pairArrayList) {
            if (integerStringPair.getKey().equals(number)) {
                return integerStringPair;
            }
        }

        return new Pair<>(0, "");
    }

    // Driver method to test above method
    public static void main(String[] args) {
        Pair<Integer, String> answer = getMaximum(pairArrayList);
        System.out.println("key = " + answer.getKey() + "\tvalue = " + answer.getValue());

        for (int i = 65; i < 70; ++i) {
            answer = getMorsePair(i);
            System.out.println("key = " + answer.getKey() + "\tvalue = " + answer.getValue());
        }

    }
}
