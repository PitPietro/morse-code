package tests.sound_test.clip;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * This is an example program that demonstrates how to play back an audio file
 * using the Clip in Java Sound API.
 * <p>
 * Currently the Java Sound API supports playing back the following audio file format: AIFC, AIFF, AU, SND and WAVE.
 * The examples will play with the WAVE format (.wav). Generally, the Java Sound API (package: javax.sound) provides
 * two ways for playing back audio: using a Clip and using a SourceDataLine. Each way has its own advantages and drawbacks.
 * <p>
 * Playing back audio using a Clip
 * Use a Clip (javax.sound.sampled.Clip) when you want to play non-real-time sound data such as a short sound file.
 * The whole file is pre-loaded into memory before playing back, therefore we have total control over the playback.
 * <p>
 * Advantages:
 * 1- It’s possible to start playing from any position in the sound (using either of the Clip’s methods
 * setMicrosecondPosition(long)or setFramePosition(int)).
 * 2- It’s possible to repeatedly play (loop) all or a part of the sound (using the setLoopPoints(int, int) and loop(int) methods).
 * 3- It’s possible to know duration of the sound before playing (using the getFrameLength() or getMicrosecondLength() methods).
 * 4- It’s possible to stop playing back at the current position and resume playing later (using the stop() and start() methods).
 * <p>
 * Drawbacks:
 * 1- It’s not suitable and inefficient to play back lengthy sound data such as a big audio file because it consumes too much memory.
 * 2- The Clip’s start() method does playing the sound but it does not block the current thread (it returns immediately),
 * so it requires to implement the LineListener interface to know when the playing completes.
 * <p>
 * Steps to play:
 * Following are the steps to implement code for playing back an audio file (typically in .wav format) using the Clip:
 * > Create an AudioInputStream from a given sound file:
 * 1| File audioFile = new File(audioFilePath);
 * 2| AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
 * <p>
 * > Acquire audio format and create a DataLine.Infoobject:
 * 1| AudioFormat format = audioStream.getFormat();
 * 2| DataLine.Info info = new DataLine.Info(Clip.class, format);
 * <p>
 * > Obtain the Clip:
 * 1| Clip audioClip = (Clip) AudioSystem.getLine(info);
 * <p>
 * > Open the AudioInputStream and start playing:
 * 1| audioClip.open(audioStream);
 * 2| audioClip.start();
 * <p>
 * > Close and release resources acquired:
 * 1| audioClip.close();
 * 2| audioStream.close();
 *
 * @author https://www.codejava.net/coding/how-to-play-back-audio-in-java-with-examples
 */
public class ClipAudioPlayer implements LineListener {

    /**
     * this flag indicates whether the playback completes or not.
     */
    boolean playCompleted;

    /**
     * Play a given audio file.
     *
     * @param audioFilePath Path of the audio file.
     */
    public void play(String audioFilePath) {
        File audioFile = new File(audioFilePath);

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);

            audioClip.addLineListener(this);
            audioClip.open(audioStream);
            audioClip.start();

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

    /**
     * Listens to the START and STOP events of the audio line.
     */
    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();

        if (type == LineEvent.Type.STOP) {
            playCompleted = true;
        }
    }

}
