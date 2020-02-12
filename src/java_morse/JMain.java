package java_morse;

public class JMain {
    public static void main(String[] args) {
        String w = "Hello world";
        JMorse m = new JMorse();
        System.out.println(m.getMorseFromChar("S"));
        m.fillText(w);
        m.printMorse();
        /* provide a switch
         * 0 - exit
         * 1 - input the plaintext
         * 2 - get the morse traduction */
    }
}