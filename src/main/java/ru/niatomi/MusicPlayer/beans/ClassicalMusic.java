package ru.niatomi.MusicPlayer.beans;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author niatomi
 */
@Component
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
