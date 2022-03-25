package ru.niatomi.MusicPlayerXML.models;

/**
 * @author niatomi
 */
public class ClassicalMusic implements Music {

    private ClassicalMusic() {}

    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();
    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }

    void doMyInit() {
        System.out.println("Init in progress");
    }

    void doMyDestroy() {
        System.out.println("Destroying");
    }
}
