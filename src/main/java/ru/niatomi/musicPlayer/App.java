package ru.niatomi.musicPlayer;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.niatomi.musicPlayer.models.ClassicalMusic;
import ru.niatomi.musicPlayer.models.Music;
import ru.niatomi.musicPlayer.player.MusicPlayer;

/**
 * @author niatomi
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Music music = context.getBean("musicBean", Music.class);

        MusicPlayer musicPlayer = new MusicPlayer(music);

        musicPlayer.playMusic();

    }
}
