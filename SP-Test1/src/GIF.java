import java.util.concurrent.TimeUnit;

public class GIF extends PlayableMedia {
    public GIF(String playableMediaTitle, int size) {
        super(playableMediaTitle, size);

        //simulare download
        try {
            TimeUnit.SECONDS.sleep(1);
        }
        catch( InterruptedException e) { e.printStackTrace(); }
    }

    @Override
    public void print() {
        System.out.println("GIF: " + this.playableMediaTitle + ", marime: " + this.size + "kb");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.addSizeGIF(this);
    }
}