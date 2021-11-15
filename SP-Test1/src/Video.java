import java.util.concurrent.TimeUnit;

public class Video extends PlayableMedia {
    public Video(String playableMediaTitle, int size) {
        super(playableMediaTitle, size);

        //simulare download
        try {
            TimeUnit.SECONDS.sleep(5);
        }
        catch( InterruptedException e) { e.printStackTrace(); }
    }

    @Override
    public void print() {
        System.out.println("Video: " + this.playableMediaTitle + ", marime: " + this.size + "kb");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.addSizeVideo(this);
    }
}
