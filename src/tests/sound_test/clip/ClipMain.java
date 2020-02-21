package tests.sound_test.clip;

import static MVC.MorseController.DOT_PATH;

public class ClipMain {
    public static void main(String[] args) {
//        for (int i = 0; i < 3; i++) {
//            new ClipAudioPlayer().play("src/line.wav");
//            new ClipAudioPlayer().play("src/dot.wav");
//        }
        ClipAudioPlayer o = new ClipAudioPlayer();
        // o.notify();
        o.play(DOT_PATH);
        o.play(DOT_PATH);
    }
}
