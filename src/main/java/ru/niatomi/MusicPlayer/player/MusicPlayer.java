package ru.niatomi.MusicPlayer.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.niatomi.MusicPlayer.models.Music;

import java.util.List;

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
