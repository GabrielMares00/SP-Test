public abstract class PlayableMedia implements Content, Visitee {
    protected String playableMediaTitle;
    protected int size;

    public PlayableMedia(String playableMediaTitle, int size) {
        this.playableMediaTitle = playableMediaTitle;
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
