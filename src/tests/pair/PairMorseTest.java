package tests.pair;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class PairMorseTest {
    public final static ArrayList<Pair<Integer, String>> pairArrayList =
            new ArrayList<>(Arrays.asList(
                    new Pair<>(46, ".-.-.-"), // dot
                    new Pair<>(44, "--..--"), // comma
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
                    new Pair<>(76, ".-.."),
                    new Pair<>(77, "--"),
                    new Pair<>(78, "-."),
                    new Pair<>(79, "---"),
                    new Pair<>(80, ".--."),
                    new Pair<>(81, "--.-"),
                    new Pair<>(82, ".-."),
                    new Pair<>(83, "..."),
                    new Pair<>(84, "-"),
                    new Pair<>(85, "..-"),
                    new Pair<>(86, "...-"),
                    new Pair<>(87, ".--"),
                    new Pair<>(88, "-..-"),
                    new Pair<>(89, "-.--"),
                    new Pair<>(90, "--.."), // Z
                    // numeric pad numbers
                    new Pair<>(96, "-----"), // 0
                    new Pair<>(97, ".----"), // 1
                    new Pair<>(98, "..---"),
                    new Pair<>(99, "...--"),
                    new Pair<>(100, "....-"),
                    new Pair<>(101, "....."), // 5
                    new Pair<>(102, "-...."),
                    new Pair<>(103, "--..."),
                    new Pair<>(104, "---.."),
                    new Pair<>(105, "----."), // 9

                    new Pair<>(111, "-..-."), // '/'
                    new Pair<>(222, "..--..") // question mark
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
