package ru.niatomi.MusicPlayer.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ru.niatomi.MusicPlayer.beans.Genre.*;

/**
 * @author niatomi
 */
public class MusicPlayer {

    private List<Genre> genreList = new ArrayList<>();

    private ClassicalMusic classicalMusic = new ClassicalMusic();
    private RockMusic rockMusic = new RockMusic();

    public MusicPlayer(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public void playMusic() {
        Genre randomGenre = genreList.get(new Random().nextInt(genreList.size()));
        if (randomGenre.getGenre() == "Classic") {
            classicalMusic.getSongs()
                          .stream()
                          .forEach(genre -> System.out.println(genre));
        } else if (randomGenre.getGenre() == "Rock") {
            rockMusic.getSongs()
                     .stream()
                     .forEach(genre -> System.out.println(genre));
        }
    }

}
