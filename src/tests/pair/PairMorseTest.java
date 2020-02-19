package tests.pair;

import javafx.util.Pair;

import java.util.ArrayList;

class PairMorseTest {
    public final static ArrayList<Pair<Integer, String>> pairArrayList = new ArrayList<>();

    public PairMorseTest() {
    }

    private static void fillPairedArrayList() {
        pairArrayList.add(new Pair<>(65, ".-"));
        pairArrayList.add(new Pair<>(66, "-..."));
        pairArrayList.add(new Pair<>(67, "-.-."));
        pairArrayList.add(new Pair<>(68, "-.."));
        pairArrayList.add(new Pair<>(69, "."));
    }

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

    // Driver method to test above method
    public static void main(String[] args) {
        fillPairedArrayList();

        // get the Pair which has maximum value
        Pair<Integer, String> ans = getMaximum(pairArrayList);

        System.out.println("key = " + ans.getKey() + "\tvalue = " + ans.getValue());
    }
}
