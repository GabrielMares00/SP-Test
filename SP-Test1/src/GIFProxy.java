public class GIFProxy implements Content, Visitee {
    private String gifUrl;
    private GIF gif;

    public GIFProxy(String gifUrl) {
        this.gifUrl = gifUrl;
    }

    public GIFProxy(String gifUrl, String playableMediaTitle, int size) {
        this.gifUrl = gifUrl;
        this.gif = new GIF(playableMediaTitle, size);
    }

    public GIFProxy(GIFProxy gp) {
        this.gif = gp.gif;
    }

    public void loadGIF() {
        if (this.gif == null) {
            URLParser urlParser = new URLParser(this.gifUrl);
            this.gif = (GIF) urlParser.getContentFromURL();
        }
    }

    @Override
    public Content clone() {
        return new MelodyProxy(this.gifUrl);
    }

    @Override
    public void print() {
        if (this.gif == null)
            loadGIF();
        this.gif.print();
    }

    @Override
    public void accept(Visitor visitor) {
        if (this.gif != null)
            visitor.addSizeGIF(this.gif);
    }
}
