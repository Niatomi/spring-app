package ru.niatomi.MusicPlayer.beans;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author niatomi
 */
@Component
@NoArgsConstructor
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}
