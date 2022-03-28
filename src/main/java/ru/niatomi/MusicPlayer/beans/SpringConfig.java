package ru.niatomi.MusicPlayer.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

/**
 * @author niatomi
 */
@Configuration
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    public Genre rockGenre() {
        return new Genre("Rock");
    }

    @Bean
    public Genre classicGenre() {
        return new Genre("Classic");
    }

    @Bean
    public List<Genre> listOfGenres() {
        return Arrays.asList(rockGenre(), classicGenre());
    }

    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(listOfGenres());
    }

}
