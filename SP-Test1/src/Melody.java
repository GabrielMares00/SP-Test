import java.util.concurrent.TimeUnit;

public class Melody extends PlayableMedia {
    public Melody(String playableMediaTitle, int size) {
        super(playableMediaTitle, size);

        //simulare download
        try {
            TimeUnit.SECONDS.sleep(3);
        }
        catch( InterruptedException e) { e.printStackTrace(); }
    }

    @Override
    public void print() {
        System.out.println("Melodie: " + this.playableMediaTitle + ", marime: " + this.size + "kb");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.addSizeMelody(this);
    }
}