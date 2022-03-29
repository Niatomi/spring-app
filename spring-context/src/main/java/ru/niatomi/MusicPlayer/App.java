package ru.niatomi.MusicPlayer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.niatomi.MusicPlayer.beans.MusicPlayer;
import ru.niatomi.MusicPlayer.beans.SpringConfig;

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
