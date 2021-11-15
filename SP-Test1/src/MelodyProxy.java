public class MelodyProxy implements Content, Visitee {
    private String melodyUrl;
    private Melody melody;

    public MelodyProxy(String videoUrl) {
        this.melodyUrl = videoUrl;
    }

    public MelodyProxy(String melodyUrl, String playableMediaTitle, int size) {
        this.melodyUrl = melodyUrl;
        this.melody = new Melody(playableMediaTitle, size);
    }

    public MelodyProxy(MelodyProxy mp) {
        this.melody = mp.melody;
    }

    public void loadMelody() {
        if (this.melody == null) {
            URLParser urlParser = new URLParser(this.melodyUrl);
            this.melody = (Melody) urlParser.getContentFromURL();
        }
    }

    @Override
    public Content clone() {
        return new MelodyProxy(this.melodyUrl);
    }

    @Override
    public void print() {
        if (this.melody == null)
            loadMelody();
        this.melody.print();
    }

    @Override
    public void accept(Visitor visitor) {
        if (this.melody != null)
            visitor.addSizeMelody(this.melody);
    }
}
