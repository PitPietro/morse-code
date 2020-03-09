package cli_morse_code.kotlin_morse

import java.util.*

/**
 * The user must be allowed to enter more than one world so the main method
 * must provide a solution of the exceptions generated by the Scanner when the user insert a whitespace.
 * Replace 'next()' method whit 'nextLine()' on line 29, but before the user input, clear the buffer whit another
 * call to 'nextLine()' on line 28.
 */
object KMain {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        scanner.useDelimiter("\n")
        val m = KMorse()
        var s = 0
        do {
            print(
                "\n\n|Morse code translator|\n0) Exit\n1) Translate the text\n2) Print Morse translation\n" +
                        "Number: "
            )
            s = scanner.nextInt()
            when (s) {
                0 -> println("Good bye!")
                1 -> {
                    print("Input the message: ")
                    val text = scanner.next()
                    m.fillText(text)
                }
                2 -> m.printMorse()
                else -> println("I can't do nothing whit this number")
            }
        } while (s != 0)
    }
}