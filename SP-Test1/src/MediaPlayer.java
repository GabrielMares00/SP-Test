import java.util.ArrayList;

public class MediaPlayer implements Visitee {
    private String appName;
    private ArrayList<Content> contentArrayList;

    public MediaPlayer(String appName) {
        this.appName = appName;
        this.contentArrayList = new ArrayList<Content>();
    }

    public MediaPlayer(String appName, ArrayList<Content> contentArrayList) {
        this.appName = appName;
        this.contentArrayList = contentArrayList;
    }

    public void addContent(Content content) {
        this.contentArrayList.add(content);
    }

    public void print() {
        System.out.println("Media player cu numele: " + this.appName);
        System.out.println("Are urmatoarele chestii la care te poti uita: ");
        for (Content i: contentArrayList)
            i.print();
    }

    public ArrayList<Content> getContentArrayList() {
        return contentArrayList;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.addMediaPlayer(this);
    }
}
