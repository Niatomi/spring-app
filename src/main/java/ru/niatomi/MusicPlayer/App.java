package ru.niatomi.MusicPlayer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.niatomi.MusicPlayer.beans.*;

import java.util.Random;

import static ru.niatomi.MusicPlayer.beans.Genre.*;

/**
 * @author niatomi
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        MusicPlayer musicPlayer = context.getBean(MusicPlayer.class);

        musicPlayer.playMusic();

        context.close();

    }
}
