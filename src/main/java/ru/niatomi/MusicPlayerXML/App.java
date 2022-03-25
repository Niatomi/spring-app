package ru.niatomi.MusicPlayerXML;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.niatomi.MusicPlayerXML.player.MusicPlayer;

/**
 * @author niatomi
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer musicPlayer1 = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer musicPlayer2 = context.getBean("musicPlayer", MusicPlayer.class);

//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//
        musicPlayer1.playMusic();
        musicPlayer2.playMusic();
        System.out.println(musicPlayer1 == musicPlayer2);

        context.close();

    }
}
