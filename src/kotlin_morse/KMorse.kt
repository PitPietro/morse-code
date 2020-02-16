package kotlin_morse

import sound_test.clip.ClipAudioPlayer
import java.util.*

class KMorse() {

    private val morse = arrayOf(
        arrayOf("A", ".-"),
        arrayOf("B", "-..."),
        arrayOf("C", "-.-."),
        arrayOf("D", "-.."),
        arrayOf("E", "."),
        arrayOf("F", "..-."),
        arrayOf("G", "--."),
        arrayOf("H", "...."),
        arrayOf("I", ".."),
        arrayOf("J", ".---"),
        arrayOf("K", "-.-"),
        arrayOf("L", ".-.."),
        arrayOf("M", "--"),
        arrayOf("N", "-."),
        arrayOf("O", "---"),
        arrayOf("P", ".--."),
        arrayOf("Q", "--.-"),
        arrayOf("R", ".-."),
        arrayOf("S", "..."),
        arrayOf("T", "-"),
        arrayOf("U", "..-"),
        arrayOf("V", "...-"),
        arrayOf("W", ".--"),
        arrayOf("X", "-..-"),
        arrayOf("Y", "-.--"),
        arrayOf("Z", "--.."),
        arrayOf("0", "-----"),
        arrayOf("1", ".----"),
        arrayOf("2", "..---"),
        arrayOf("3", "...--"),
        arrayOf("4", "....-"),
        arrayOf("5", "....."),
        arrayOf("6", "-...."),
        arrayOf("7", "--..."),
        arrayOf("8", "---.."),
        arrayOf("9", "----.")
    )

    /**
     * It stores the message the user want to translate
     */
    private var plaintext: ArrayList<String>? = null

    /**
     * Fills the 'plaintext' variable whit the user's input.
     * It makes all the letters uppercase so that they can be
     * compared with the once stored in the multidimensional array
     *
     * @param s user input
     */
    fun fillText(s: String) {
        var s = s
        s = s.toUpperCase()
        for (i in 0 until s.length) {
            plaintext!!.add(s[i].toString())
        }
    }

    /**
     * The foreach loop calls 'getMorseFromChar' for each character of the
     * 'plaintext' ArrayList printing the Morse code. After the loop, clear
     * the ArrayList: if the user input another message, it will be placed
     * after the once already in.
     */
    fun printMorse() {
        for (s in plaintext!!) {
            print(getMorseFromChar(s) + "\t")
            if (s == " ") {
                print("\n")
            }
        }
        plaintext!!.clear()
    }

    /**
     * Takes as parameter a letter or a number and returns the given Morse element
     *
     * @param c a letter or a number that can be translated by the Morse alphabet
     * @return Morse char
     */
    fun getMorseFromChar(c: String): String {
        var msg = ""
        for (strings in morse) {
            if (strings[0] == c) {
                msg = strings[1]
                getSoundFromMorse(strings[1])
                break
            }
        }
        return msg
    }

    /**
     * Takes as parameter a morse string from the second row of the multidimensional array.
     * Foreach character of the string, check if it is a line or a dot and play the right audio file.
     *
     * @param morseString morse string
     */
    private fun getSoundFromMorse(morseString: String) {
        for (i in 0 until morseString.length) {
            val morseChar = morseString[i]
            if (morseChar == '.') {
                ClipAudioPlayer().play("src/audio_files/dot.wav")
            } else if (morseChar == '-') {
                ClipAudioPlayer().play("src/audio_files/line.wav")
            }
        }
    }

    init {
        plaintext = ArrayList()
    }
}