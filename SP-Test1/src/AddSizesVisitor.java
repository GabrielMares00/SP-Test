public class AddSizesVisitor implements Visitor {
    private int sizeVideo;
    private int sizeMelody;
    private int sizeGIF;

    @Override
    public void addMediaPlayer(MediaPlayer mediaPlayer) {
        for (Content i: mediaPlayer.getContentArrayList()) {
            Visitee castedI = (Visitee) i;
            castedI.accept(this);
        }
    }

    @Override
    public void addSizePlaylist(Playlist playlist) {
        for (Content i: playlist.getContentArrayList()) {
            Visitee castedI = (Visitee) i;
            castedI.accept(this);
        }
    }

    @Override
    public void addSizeVideo(Video video) {
        this.sizeVideo += video.getSize();
    }

    @Override
    public void addSizeMelody(Melody melody) {
        this.sizeMelody += melody.getSize();
    }

    @Override
    public void addSizeGIF(GIF gif) {
        this.sizeGIF += gif.getSize();
    }

    @Override
    public void print() {
        System.out.println("Size of Videos: " + this.sizeVideo);
        System.out.println("Size of Melodies: " + this.sizeMelody);
        System.out.println("Size of GIFs: " + this.sizeGIF);
    }

    public void printSumOfAllSizes() {
        System.out.println("Size of all: " + (this.sizeVideo + this.sizeMelody + this.sizeGIF));
    }
}
