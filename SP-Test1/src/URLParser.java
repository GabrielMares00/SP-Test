public class URLParser {
    private String URL;

    public URLParser(String URL) {
        this.URL = URL;
    }

    // Formatez un URL ca fiind "www.google.com/tip/titlu/marime";
    public Content getContentFromURL() {
        String[] splitURL = URL.split("/");
        Content content = null;

        try {
            switch (splitURL[1]) {
                case "video" ->
                        {
                            System.out.println("Descarc video");
                            content = new Video(splitURL[2], Integer.parseInt(splitURL[3]));
                        }
                case "melody" ->
                        {
                            System.out.println("Descarc melodie");
                            content = new Melody(splitURL[2], Integer.parseInt(splitURL[3]));
                        }
                case "GIF" ->
                        {
                            System.out.println("Descarc GIF");
                            content = new GIF(splitURL[2], Integer.parseInt(splitURL[3]));
                        }
            }
        }
        catch (UnsupportedOperationException e) { e.printStackTrace(); }

        return content;
    }
}
