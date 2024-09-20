package SpaceInvaders.midi;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/*
*  Class to handle space Invaders background music
 */
public class SpaceInvadersMusic implements Runnable {
    private Sequencer sequencer;


    @Override
    public void run() {
        try {
            File musicFile = new File("src\\main\\java\\SpaceInvaders\\Ressurser\\swts.mid");
            InputStream song = new FileInputStream(musicFile);
            this.doPlayMidi(song, true);
        } catch (Exception e) {
            this.midiError("Failed to load music file: " + e.getMessage());
        }
    }

    private void doPlayMidi(final InputStream is, final boolean loop) {
        try {
            this.doStopMidiSounds();
            (this.sequencer = MidiSystem.getSequencer()).setSequence(MidiSystem.getSequence(is));
            if (loop) {
                this.sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            }
            this.sequencer.open();
            this.sequencer.start();
        } catch (Exception e) {
            this.midiError("MIDI Playback Error: " + e.getMessage());
        }
    }

    public void doStopMidiSounds() {
        try {
            if (this.sequencer != null && this.sequencer.isRunning()) {
                this.sequencer.stop();
                this.sequencer.close();
            }
        } catch (Exception e) {
            this.midiError("Error stopping MIDI: " + e.getMessage());
        }
        this.sequencer = null;
    }
        private void midiError(final String msg) {
            System.err.println("MIDI Error: " + msg);
            this.sequencer = null;
        }
    }