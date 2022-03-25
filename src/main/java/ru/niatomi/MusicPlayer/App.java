package ru.niatomi.MusicPlayer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.niatomi.MusicPlayer.beans.ClassicalMusic;
import ru.niatomi.MusicPlayer.beans.Computer;
import ru.niatomi.MusicPlayer.beans.Music;
import ru.niatomi.MusicPlayer.beans.MusicPlayer;

/**
 * @author niatomi
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "ru.niatomi.MusicPlayer.beans"
        );

        Computer computer = context.getBean(Computer.class);

        System.out.println(computer.toString());

        context.close();

    }
}
