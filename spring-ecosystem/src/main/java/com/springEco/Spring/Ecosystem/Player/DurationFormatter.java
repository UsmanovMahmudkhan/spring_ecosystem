package com.springEco.Spring.Ecosystem.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DurationFormatter {

    @Autowired
    Song song;

    public String format(){
        int seconds=song.getSecond();
        int minut=seconds/60;
        int rest_min=seconds-(minut*60);
        return  String.valueOf(minut)+":"+String.valueOf(rest_min);

    }
}
