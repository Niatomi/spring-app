package ru.niatomi.MusicPlayer.beans;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

import static ru.niatomi.MusicPlayer.beans.Genre.*;

/**
 * @author niatomi
 */
@Component
@AllArgsConstructor
public class MusicPlayer {

    @Autowired
    @Qualifier("classicalMusic")
    private Music classicalMusic;

    @Autowired
    @Qualifier("rockMusic")
    private Music rockMusic;

    public String playMusic(Enum anEnum) {
        String returnString = "";
        if (anEnum == CLASSICAL) {
            returnString = "Playing: " + classicalMusic.getSongs().get(new Random().nextInt(3));
        } else if (anEnum == ROCK) {
            returnString = "Playing: " + rockMusic.getSongs().get(new Random().nextInt(3));
        }
        return returnString;
    }

}
