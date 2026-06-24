package com.springEco.Spring.Ecosystem.Player;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.springEco.Spring.Ecosystem.Player")
public class Config {

//    song1 = Bohemian Rhapsody / Queen / 355 seconds
//    song2 = Stairway to Heaven / Led Zeppelin / 482 seconds
    @Bean("song1")
    @Primary
    public Song song(){
        Song song=new Song();
        song.setArtist("Queen");
        song.setSecond(355);
        song.setTitle("Bohemian Rhapsody");
        return song;
    }

    @Bean("song2")
    public Song song2(){
        Song song=new Song();
        song.setTitle("Stairway to Heaven");
        song.setArtist("Led Zeppelin");
        song.setSecond(482);
        return song;
    }
}
