package com.springEco.Spring.Ecosystem.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerService {

    private final AudioEngine audioEngine;
    private  Listener listener;


    @Autowired
    DurationFormatter durationFormatter;

    @Autowired
    public void setListener(Listener listener) {
        this.listener=listener;
    }

    public PlayerService(AudioEngine audioEngine) {
        this.audioEngine = audioEngine;
    }

    public Listener getListener() {
        return listener;
    }

    public AudioEngine getAudioEngine() {
        return audioEngine;
    }

    public DurationFormatter getDurationFormatter() {
        return durationFormatter;
    }

    public void setDurationFormatter(DurationFormatter durationFormatter) {
        this.durationFormatter = durationFormatter;
    }

    public PlaybackSession createSession(){
        return new PlaybackSession(audioEngine.getSong(), getListener(),durationFormatter.format());
    }
}


