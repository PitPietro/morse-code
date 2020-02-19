package tests.pair;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

class PairMorseTest {
    public final static ArrayList<Pair<Integer, String>> pairArrayList =
            new ArrayList<>(Arrays.asList(
                    new Pair<>(65, ".-"),
                    new Pair<>(66, "-..."),
                    new Pair<>(67, "-.-."),
                    new Pair<>(68, "-.."),
                    new Pair<>(69, ".")
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

    static Pair<Integer, String> getMorsePair(Integer number) {
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
