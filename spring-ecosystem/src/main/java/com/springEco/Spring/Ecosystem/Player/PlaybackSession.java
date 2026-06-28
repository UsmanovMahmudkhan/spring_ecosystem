package com.springEco.Spring.Ecosystem.Player;

public class PlaybackSession

{
    private Song song;
    private Listener listener;
    private String durationLabel;

    public PlaybackSession(Song song, Listener listener, String durationLabel) {
        this.song = song;
        this.listener = listener;
        this.durationLabel = durationLabel;
    }

    public Song getSong() {
        return song;
    }

    public Listener getListener() {
        return listener;
    }


    public String getDurationLabel() {
        return durationLabel;
    }

}
