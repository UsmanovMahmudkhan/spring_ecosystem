package com.springEco.Spring.Ecosystem.Player;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Recommender {
    private final Song song;

    public Recommender(@Qualifier("song2") Song song) {
        this.song = song;
    }

    public Song getSong() {
        return song;
    }

    public String recommend(){
        return "Recommender :"+song.getTitle();
    }
}
