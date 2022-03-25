package ru.niatomi.MusicPlayer.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author niatomi
 */
@Component
public interface Music {
    String getSong();
}
