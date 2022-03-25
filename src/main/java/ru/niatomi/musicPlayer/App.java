package ru.niatomi.musicPlayer;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.niatomi.musicPlayer.player.MusicPlayer;

/**
 * @author niatomi
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        musicPlayer.playMusic();

        context.close();


    }
}
