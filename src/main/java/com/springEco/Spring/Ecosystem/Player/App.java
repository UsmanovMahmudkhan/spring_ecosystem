package com.springEco.Spring.Ecosystem.Player;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

@SpringBootApplication(scanBasePackages = "com.springEco.Spring.Ecosystem.Player")
public class App {
    public static void main(String[] args) {
        var context=new AnnotationConfigApplicationContext(Config.class);

        var print=context.getBean(NowPlayingPrinter.class);
        print.print();

        Song song =new Song();
        //Song of the day (from context): Song{title='Lofi Beat', artist='TuneBox', seconds=180}
        song.setTitle("Lofi Beat");
        song.setArtist("TuneBox");
        song.setSecond(180);
        Supplier<Song>songSupplier=()->song;
        context.registerBean("song",Song.class,songSupplier);


        var song_manual=context.getBean(Song.class);
        System.out.println("Song of the day (from context): "+song_manual);
    }
}
