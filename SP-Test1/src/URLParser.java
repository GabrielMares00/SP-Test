public class URLParser {
    private String URL;

    public URLParser(String URL) {
        this.URL = URL;
    }

    // Formatez un URL ca fiind "www.google.com/tip/titlu/marime";
    public PlayableMedia getContentFromURL() {
        String[] splitURL = URL.split("/");
        PlayableMedia playableMedia = null;

        try {
            switch (splitURL[1]) {
                case "video" ->
                        {
                            System.out.println("Descarc video");
                            playableMedia = new Video(splitURL[2], Integer.parseInt(splitURL[3]));
                        }
                case "melody" ->
                        {
                            System.out.println("Descarc melodie");
                            playableMedia = new Melody(splitURL[2], Integer.parseInt(splitURL[3]));
                        }
                case "GIF" ->
                        {
                            System.out.println("Descarc GIF");
                            playableMedia = new GIF(splitURL[2], Integer.parseInt(splitURL[3]));
                        }
            }
        }
        catch (UnsupportedOperationException e) { e.printStackTrace(); }

        return playableMedia;
    }
}
