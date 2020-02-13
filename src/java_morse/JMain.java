package java_morse;

import java.util.Scanner;

public class JMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        JMorse m = new JMorse();

        int s = 0;
        do {
            System.out.print("\n|Morse code translator|\n0) Exit\n1) Translate the text\n2) Print Morse translation\n" +
                    "Number: ");
            s = scanner.nextInt();

            switch (s) {
                case 0: System.out.println("Good bye!");
                break;
                case 1: {
                    System.out.print("Input the message: ");
                    String text = scanner.next();
                    m.fillText(text);
                }
                break;
                case 2: m.printMorse();
                    break;
                default:
                    System.out.println("I can't do nothing whit this number");
            }
        } while(s != 0);
    }
}