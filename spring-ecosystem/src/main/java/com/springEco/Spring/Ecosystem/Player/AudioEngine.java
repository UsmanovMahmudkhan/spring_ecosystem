package com.springEco.Spring.Ecosystem.Player;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AudioEngine {

    private final Song song;

    public AudioEngine(Song song) {
        this.song = song;
    }

    public Song getSong() {
        return song;
    }

    public String play(){
        return "Audio Engine is playing: "+song.getTitle();
    }
}
