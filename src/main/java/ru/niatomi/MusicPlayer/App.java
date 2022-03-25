package ru.niatomi.MusicPlayer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.niatomi.MusicPlayer.models.Music;
import ru.niatomi.MusicPlayer.models.RockMusic;
import ru.niatomi.MusicPlayer.player.MusicPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niatomi
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Music music = context.getBean("rockMusic", Music.class);

        MusicPlayer musicPlayer = new MusicPlayer(music);

        musicPlayer.playMusic();

        Music music2 = context.getBean("rockMusic", Music.class);

        MusicPlayer classicalMusicPlayer = new MusicPlayer(music2);

        classicalMusicPlayer.playMusic();

        System.out.println(music == music2);

        context.close();

    }
}
