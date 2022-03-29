package ru.niatomi.MusicPlayer.beans;

import java.util.Arrays;
import java.util.List;

/**
 * @author niatomi
 */
public class ClassicalMusic implements Music {
    List<String> songList = Arrays.asList(
            "Hungary Rhapsody",
            "Cannon in D",
            "Four seasons");

    @Override
    public List<String> getSongs() {
        return songList;
    }
}
