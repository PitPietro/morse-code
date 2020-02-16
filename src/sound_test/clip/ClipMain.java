package sound_test.clip;

public class ClipMain {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new ClipAudioPlayer().play("src/line.wav");
            new ClipAudioPlayer().play("src/dot.wav");
        }
    }
}
