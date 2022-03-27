package ru.niatomi.MusicPlayer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.niatomi.MusicPlayer.beans.ClassicalMusic;
import ru.niatomi.MusicPlayer.beans.Computer;
import ru.niatomi.MusicPlayer.beans.Music;
import ru.niatomi.MusicPlayer.beans.MusicPlayer;

import java.util.Random;

import static ru.niatomi.MusicPlayer.beans.Genre.*;

/**
 * @author niatomi
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "ru.niatomi.MusicPlayer.beans"
        );

        MusicPlayer musicPlayer = context.getBean(MusicPlayer.class);

        System.out.println(musicPlayer.playMusic(ROCK));

        context.close();

    }
}
