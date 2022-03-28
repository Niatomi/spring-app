package ru.niatomi.MusicPlayer.beans;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author niatomi
 */
@NoArgsConstructor
public class RockMusic implements Music {
    List<String> songList = Arrays.asList(
            "It's only smiles",
            "Marigold",
            "Reptile");

    @Override
    public List<String> getSongs() {
        return songList;
    }
}
