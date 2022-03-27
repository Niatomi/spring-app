package ru.niatomi.MusicPlayer.beans;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author niatomi
 */
@Component
public interface Music {
    List<String> getSongs();
}
