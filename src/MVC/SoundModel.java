package MVC;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundModel {
    static AudioInputStream audioStream;
    static SourceDataLine sourceLine;

    public static void playSound(String soundPath) {
        try {
            File soundFile = new File(soundPath);
            audioStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        AudioFormat audioFormat = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }

        sourceLine.start();

        int bytesRead = 0;
        int BUFFER_SIZE = 128000;
        byte[] bufferData = new byte[BUFFER_SIZE];

        while (bytesRead != -1) {
            try {
                bytesRead = audioStream.read(bufferData, 0, bufferData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(bytesRead >= 0) {
                int bytesWritten = sourceLine.write(bufferData, 0, bytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
    }
}
