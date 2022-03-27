package ru.niatomi.MusicPlayer.beans;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static ru.niatomi.MusicPlayer.beans.Genre.*;

/**
 * @author niatomi
 */
@Component
public class Computer {

    private int id;

    @Autowired
    MusicPlayer musicPlayer;

    public Computer(MusicPlayer musicPlayer) {
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", musicPlayer=" + musicPlayer.playMusic(CLASSICAL) +
                '}';
    }
}
