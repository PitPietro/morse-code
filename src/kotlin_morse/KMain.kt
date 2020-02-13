package kotlin_morse

import java_morse.JMorse
import java.util.*

object KMain {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        val m = JMorse()
        var s = 0
        do {
            print(
                "\n|Morse code translator|\n0) Exit\n1) Translate the text\n2) Print Morse translation\n" +
                        "Number: "
            )
            s = scanner.nextInt()
            when (s) {
                0 -> println("Good bye!")
                1 -> {
                    print("Input the message: ")
                    scanner.nextLine()
                    val text = scanner.nextLine()
                    m.fillText(text)
                }
                2 -> m.printMorse()
                else -> println("I can't do nothing whit this number")
            }
        } while (s != 0)
    }
}