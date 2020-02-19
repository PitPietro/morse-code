package tests.pair;

import javafx.util.Pair;

import java.util.ArrayList;

class PairMorseTest {
    public ArrayList<Pair<String, Integer>> pairArrayList;

    public PairMorseTest() {
        this.pairArrayList = new ArrayList<>();
    }

    public static Pair<String, Integer> getMaximum(ArrayList<Pair<String, Integer>> list) {
        // Assign minimum value initially
        int max = Integer.MIN_VALUE;

        // Pair to store the maximum marks of a student with its name
        Pair<String, Integer> ans = new Pair<>("", 0);

        // Using for each loop to iterate array of Pair Objects
        for (Pair<String, Integer> temp : list) {
            // Get the score of Student
            int val = temp.getValue();

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

        pairObject.pairArrayList.add(new Pair<>("Student A", 90));
        pairObject.pairArrayList.add(new Pair<>("Student B", 54));
        pairObject.pairArrayList.add(new Pair<>("Student C", 99));
        pairObject.pairArrayList.add(new Pair<>("Student D", 88));
        pairObject.pairArrayList.add(new Pair<>("Student E", 89));

        // get the Pair which has maximum value
        Pair<String, Integer> ans = getMaximum(pairObject.pairArrayList);

        System.out.println(ans.getKey() + " is top scorer with score of " + ans.getValue());
    }
}
