public class Main {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer("Sputofy");

        Playlist playlist1 = new Playlist("Muzica d-aia blana");
        VideoProxy video1 = new VideoProxy("www.google.com/video/tarzan/1024");
        Video video2 = new Video("Visiting zoo", 768);
        playlist1.addDirectlyByContent(video1);
        playlist1.addDirectlyByContent(video2);
        playlist1.addPlaylistElement("www.youtube.com/video/copil-copac/2048");
        playlist1.addPlaylistElement("www.google.com/melody/maneaua-suprema/128");
        playlist1.addPlaylistElement("www.google.com/GIF/Doof/42");

        Playlist playlist2 = new Playlist("D-ale sufletului");
        playlist2.addPlaylistElement("www.google.com/video/farse-faine/30243");
        playlist2.addPlaylistElement("www.google.com/video/glume-proaste/3492");
        playlist2.addPlaylistElement("www.google.com/GIF/Jelly-Dance/128");
        playlist2.addPlaylistElement("www.google.com/GIF/Genshin-Pull-Jean/256");

        playlist1.addDirectlyByContent(playlist2);

        mediaPlayer.addContent(new Melody("Gica Taurul", 58));

        mediaPlayer.addContent(playlist1);
        // This is gonna take a long time to run :^(
        mediaPlayer.print();

        AddSizesVisitor visitor = new AddSizesVisitor();
        mediaPlayer.accept(visitor);
        visitor.print();
        visitor.printSumOfAllSizes();
    }
}
