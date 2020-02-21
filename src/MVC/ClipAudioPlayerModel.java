package MVC;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ClipAudioPlayerModel implements LineListener {

    /**
     * this flag indicates whether the playback completes or not.
     */
    static boolean playCompleted;

    /**
     * Play a given audio file.
     *
     * @param audioFilePath Path of the audio file.
     */
    public static void play(String audioFilePath) {
        File audioFile = new File(audioFilePath);
        // playCompleted = false;

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);

            audioClip.addLineListener(new ClipAudioPlayerModel());
            audioClip.open(audioStream);
            audioClip.start();
            // playCompleted = true;

            while (!playCompleted) {
                // wait for the playback completes
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            audioClip.close();

        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }

    }

    @Override
    public void update(LineEvent lineEvent) {
        LineEvent.Type type = lineEvent.getType();

        if (type == LineEvent.Type.STOP) {
            playCompleted = true;
            // System.out.println("Playback completed.");
        }
    }
}
