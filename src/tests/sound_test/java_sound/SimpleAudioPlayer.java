package tests.sound_test.java_sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Java inbuilt libraries support only AIFC, AIFF, AU, SND and WAVE formats. There are 2 different interfaces which
 * can be used for this purpose Clip and SourceDataLine. This project will play audio file using Clip only.
 * It supports the following operations:
 * 1- Start.
 * 2- Pause.
 * 3- Resume.
 * 4- Restart.
 * 5- Stop
 * 6- Jump to a specific position of playback.
 */
public class SimpleAudioPlayer {

    static String filePath;
    Long currentFrame; // store current position
    Clip clip;
    String status; // current status of clip
    AudioInputStream audioInputStream;

    /**
     * constructor to initialize streams and clip
     * @throws UnsupportedAudioFileException exception
     * @throws IOException exception
     * @throws LineUnavailableException exception
     */
    public SimpleAudioPlayer()
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        // create AudioInputStream object
        audioInputStream =
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void main(String[] args) {
        try {
            filePath = "src/audio_files/dot.wav";
            SimpleAudioPlayer audioPlayer =
                    new SimpleAudioPlayer();

            audioPlayer.play();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("1. pause");
                System.out.println("2. resume");
                System.out.println("3. restart");
                System.out.println("4. stop");
                System.out.println("5. Jump to specific time");
                int c = sc.nextInt();
                audioPlayer.gotoChoice(c);
                if (c == 4)
                    break;
            }
            sc.close();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }

    /**
     * Work as the user enters his choice
     * @param c user choice
     * @throws IOException exception
     * @throws LineUnavailableException exception
     * @throws UnsupportedAudioFileException exception
     */
    private void gotoChoice(int c)
            throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        switch (c) {
            case 1:
                pause();
                break;
            case 2:
                resumeAudio();
                break;
            case 3:
                restart();
                break;
            case 4:
                stop();
                break;
            case 5:
                System.out.println("Enter time (" + 0 +
                        ", " + clip.getMicrosecondLength() + ")");
                Scanner sc = new Scanner(System.in);
                long c1 = sc.nextLong();
                jump(c1);
                break;
        }
    }

    /**
     * Play the audio
     */
    public void play() {
        //start the clip
        clip.start();

        status = "play";
    }

    /**
     * Pause the audio
     */
    public void pause() {
        if (status.equals("paused")) {
            System.out.println("audio is already paused");
            return;
        }
        this.currentFrame =
                this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    /**
     * Resume the audio
     * @throws UnsupportedAudioFileException exception
     * @throws IOException exception
     * @throws LineUnavailableException exception
     */
    public void resumeAudio() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        if (status.equals("play")) {
            System.out.println("Audio is already " +
                    "being played");
            return;
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    /**
     * Restart the audio
     * @throws IOException exception
     * @throws LineUnavailableException exception
     * @throws UnsupportedAudioFileException exception
     */
    public void restart() throws IOException, LineUnavailableException,
            UnsupportedAudioFileException {
        clip.stop();
        clip.close();
        resetAudioStream();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        this.play();
    }

    /**
     * Stop the audio
     * @throws UnsupportedAudioFileException exception
     * @throws IOException exception
     * @throws LineUnavailableException exception
     */
    public void stop() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    /**
     * Jump over a specific part
     * @param c time
     * @throws UnsupportedAudioFileException exception
     * @throws IOException exception
     * @throws LineUnavailableException exception
     */
    public void jump(long c) throws UnsupportedAudioFileException, IOException,
            LineUnavailableException {
        if (c > 0 && c < clip.getMicrosecondLength()) {
            clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame = c;
            clip.setMicrosecondPosition(c);
            this.play();
        }
    }

    /**
     * Reset audio stream
     * @throws UnsupportedAudioFileException exception
     * @throws IOException exception
     * @throws LineUnavailableException exception
     */
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException,
            LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(
                new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
