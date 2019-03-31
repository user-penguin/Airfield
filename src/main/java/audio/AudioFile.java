package audio;

public interface AudioFile {
    void play();
    void pause();
    void stop();
    void load(String path);
}
