package tests.sound_test.java_sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Playing back using a SourceDataLine
 * Use a SourceDataLine (javax.sound.sampled.SourceDataLine) when you want to play a long sound file which cannot be
 * pre-loaded into memory or to stream real-time sound data such as playing sound back as it’s being captured.
 * <p>
 * Advantages:
 * 1- It’s suitable and efficient to play back long sound file or to stream sound in real-time.
 * 2- It’s possible to control what sound data to be written to the audio line’s playback buffer.
 * 3- Unlike the Clip, we don’t have to implement the LineListener interface to know when the playback completes.
 * <p>
 * Drawbacks:
 * 1- Cannot start playing from an arbitration position in the sound.
 * 2- Cannot repeatedly play (loop) all or a part of the sound.
 * 3- Cannot stop and resume playing in the middle.
 * 4- Cannot know duration of the sound before playing.
 * <p>
 * Steps to play:
 * Following are the steps to implement code for playing back a sound file using the SourceDataLine:
 * <p>
 * > Obtain a SourceDataLine is similar to obtain a Clip:
 * 1| File audioFile = new File(audioFilePath);
 * 2| AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
 * 3| AudioFormat format = audioStream.getFormat();
 * 4| DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
 * 5| SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);
 * <p>
 * > Open and start the audio line:
 * 1| audioLine.open(format);
 * 2| audioLine.start();
 * <p>
 * > Repeatedly read a chunk of bytes from the AudioInputStream and send it to the SourceDataLine’splayback buffer,
 * until reaching end of the input stream:
 * 1| int BUFFER_SIZE = 4096;
 * 2| byte[] bytesBuffer = new byte[BUFFER_SIZE];
 * 3| int bytesRead = -1;
 * 4| while ((bytesRead = audioStream.read(bytesBuffer)) != -1) {
 * 5| audioLine.write(bytesBuffer, 0, bytesRead);
 * 6| }
 * <p>
 * > Close and release resources acquired:
 * 1| audioLine.drain();
 * 2| audioLine.close();
 * 3| audioStream.close();
 */
public class SourceDataLineAudioPlayer {

    // size of the byte buffer used to read/write the audio stream
    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {
        String audioFilePath = "src/audio_files/dot.wav";
        SourceDataLineAudioPlayer player = new SourceDataLineAudioPlayer();
        player.play(audioFilePath);
    }

    /**
     * Play a given audio file.
     *
     * @param audioFilePath Path of the audio file.
     */
    void play(String audioFilePath) {
        File audioFile = new File(audioFilePath);
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            AudioFormat format = audioStream.getFormat();

            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

            SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);

            audioLine.open(format);

            audioLine.start();

            System.out.println("Playback started.");

            byte[] bytesBuffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;

            while ((bytesRead = audioStream.read(bytesBuffer)) != -1) {
                audioLine.write(bytesBuffer, 0, bytesRead);
            }

            audioLine.drain();
            audioLine.close();
            audioStream.close();

            System.out.println("Playback completed.");

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
}
