package ru.niatomi.musicPlayer.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.niatomi.musicPlayer.models.Music;

import java.util.List;

/**
 * @author niatomi
 */
@AllArgsConstructor
@NoArgsConstructor
public class MusicPlayer {
    @Setter
    private List<Music> musicList;

    @Getter
    @Setter
    private String name;

    @Setter
    @Getter
    private int volume;

    public void playMusic() {
        musicList.stream().forEach(e -> System.out.println("Playing: ".concat(e.getSong())));
    }
}
