import java.util.ArrayList;

public class Playlist implements Content, Visitee {
    private String playlistTitle;
    private ArrayList<Content> contentArrayList;

    public Playlist(String playlistTitle) {
        this.playlistTitle = playlistTitle;
        this.contentArrayList = new ArrayList<Content>();
    }

    public Playlist(String playlistTitle, ArrayList<Content> contentArrayList) {
        this.playlistTitle = playlistTitle;
        this.contentArrayList = contentArrayList;
    }

    public void addPlaylistElement(String URL) {
        URLParser urlParser = new URLParser(URL);
        this.contentArrayList.add(urlParser.getContentFromURL());
    }

    // deviez putin de la cerinta initiala cu URLs
    // pentru cazul in care adaug un playlist in alt playlist sau obiecte "deja aflate in playlist"
    public void addDirectlyByContent(Content content) {
        System.out.println("Initializez content deja existent");
        this.contentArrayList.add(content);
    }

    @Override
    public void print() {
        System.out.println("Playlist cu titlul: " + this.playlistTitle);
        for (Content i: contentArrayList)
            i.print();
    }

    public ArrayList<Content> getContentArrayList() {
        return contentArrayList;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.addSizePlaylist(this);
    }
}
