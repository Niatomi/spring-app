package ru.niatomi.MusicPlayer.beans;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author niatomi
 */
@Component
@AllArgsConstructor
public class MusicPlayer {

    private ClassicalMusic classicalMusic;

    private RockMusic rockMusic;

    public String playMusic() {
        return "Playing: " + classicalMusic.getSong();
    }

}
