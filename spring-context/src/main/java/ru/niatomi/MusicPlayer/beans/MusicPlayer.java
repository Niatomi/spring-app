package ru.niatomi.MusicPlayer.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
