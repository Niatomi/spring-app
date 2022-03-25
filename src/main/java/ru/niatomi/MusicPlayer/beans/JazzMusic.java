package ru.niatomi.MusicPlayer.beans;

import org.springframework.stereotype.Component;

/**
 * @author niatomi
 */
@Component
public class JazzMusic implements Music {
    @Override
    public String getSong() {
        return "Whiplash";
    }
}