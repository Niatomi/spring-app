package ru.niatomi.MusicPlayer.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
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
