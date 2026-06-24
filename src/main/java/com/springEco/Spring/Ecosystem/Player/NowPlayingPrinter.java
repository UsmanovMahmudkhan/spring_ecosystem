package com.springEco.Spring.Ecosystem.Player;

import org.springframework.stereotype.Component;

@Component
public class NowPlayingPrinter {

    private final PlayerService playerService;
    private final Recommender recommender;

    public NowPlayingPrinter(PlayerService playerService, Recommender recommender) {
        this.playerService = playerService;
        this.recommender = recommender;
    }

    public PlayerService getPlayerService() {
        return playerService;
    }

    public Recommender getRecommender() {
        return recommender;
    }

    public void print(){
        var session=playerService.createSession();
        System.out.println(
                "===== TuneBox — Now Playing =====\n"+
                        "Listener: "+session.getListener().getName()+"\n"+
                        "Track: "+ session.getSong().getTitle()+"\n"+
                        "Artist: "+ session.getSong().getArtist()+"\n"+
                        "Duration: "+session.getDurationLabel()+"\n"+
                        "Engine: "+playerService.getAudioEngine().play()+"\n"+
                        "Recommended: "+recommender.recommend()+"\n"+
                        "=================================\n"

        );
    }



//    Duration:      5:55
//    Engine:        AudioEngine is playing Bohemian Rhapsody
//    Recommended:   Stairway to Heaven
//=================================
//
//    Song of the day (from context): Song{title='Lofi Beat', artist='TuneBox', seconds=180}

}
