public interface Visitor {
    void addMediaPlayer(MediaPlayer mediaPlayer);
    void addSizePlaylist(Playlist playlist);
    void addSizeVideo(Video video);
    void addSizeMelody(Melody melody);
    void addSizeGIF(GIF gif);
    void print();
}