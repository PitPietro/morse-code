package tests.pair;

import javafx.util.Pair;

import java.util.ArrayList;

class PairMorseTest {
    public ArrayList<Pair<Integer, String>> pairArrayList;

    public PairMorseTest() {
        this.pairArrayList = new ArrayList<>();
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

        PairMorseTest pairObject = new PairMorseTest();

        // get the Pair which has maximum value
        Pair<Integer, String> ans = getMaximum(pairObject.pairArrayList);

        System.out.println(ans.getKey() + " is top scorer with score of " + ans.getValue());
    }
}
