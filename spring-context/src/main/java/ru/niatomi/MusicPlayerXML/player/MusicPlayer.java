package ru.niatomi.MusicPlayerXML.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.niatomi.MusicPlayerXML.models.Music;

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

    void doMyInit() {
        System.out.println("Init in progress");
    }

    void doMyDestroy() {
        System.out.println("Destroying");
    }
}
