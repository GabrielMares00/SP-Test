public class VideoProxy implements Content, Visitee {
    private String videoUrl;
    private Video video;

    public VideoProxy(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public VideoProxy(String videoUrl, String playableMediaTitle, int size) {
        this.videoUrl = videoUrl;
        this.video = new Video(playableMediaTitle, size);
    }

    public VideoProxy(VideoProxy vp) {
        this.video = vp.video;
    }

    public void loadVideo() {
        if (this.video == null) {
            URLParser urlParser = new URLParser(this.videoUrl);
            this.video = (Video) urlParser.getContentFromURL();
        }
    }

    @Override
    public Content clone() {
        return new VideoProxy(this.videoUrl);
    }

    @Override
    public void print() {
        if (this.video == null)
            loadVideo();
        this.video.print();
    }

    @Override
    public void accept(Visitor visitor) {
        if (this.video != null)
            visitor.addSizeVideo(this.video);
    }
}
