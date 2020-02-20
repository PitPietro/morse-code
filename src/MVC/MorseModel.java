package MVC;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class MorseModel {

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

                    // numeric pad
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

                    new Pair<>(110, ".-.-.-"), // Numeric Pad dot
                    new Pair<>(111, "-..-."), // '/'
                    new Pair<>(222, "..--..") // question mark
            ));

    public static Pair<Integer, String> getMorsePair(Integer number) {
        for (Pair<Integer, String> integerStringPair : pairArrayList) {
            if (integerStringPair.getKey().equals(number)) {
                return integerStringPair;
            }
        }

        return new Pair<>(0, "");
    }
}
