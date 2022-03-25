package ru.niatomi.MusicPlayer.models;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
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