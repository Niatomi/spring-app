package ru.niatomi.musicPlayer.player;

import lombok.AllArgsConstructor;
import ru.niatomi.musicPlayer.models.Music;

/**
 * @author niatomi
 */
@AllArgsConstructor
public class MusicPlayer {
    private Music music;

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }
}
