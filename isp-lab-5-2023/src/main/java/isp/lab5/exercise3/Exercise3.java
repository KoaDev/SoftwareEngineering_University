package isp.lab5.exercise3;

public class Exercise3 {
    public static void main(String[] args) {

        Playable video1 = new ProxyVideo("video1.mp4", false);
        Playable video2 = new ProxyVideo("video2.avi", true);

        video1.play();
        video2.play();
    }
}

interface Playable {
    void play();
}

class ColorVideo implements Playable {

    private String fileName;

    public ColorVideo(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void play() {
        System.out.println("Play " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading video..." + fileName);
    }
}

class BlackAndWhiteVideo implements Playable {

    private String fileName;

    public BlackAndWhiteVideo(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void play() {
        System.out.println("Play black and white video " + fileName);
    }
}

class ProxyVideo implements Playable {

    private Playable video;
    private String fileName;

    public ProxyVideo(String fileName, boolean isBlackAndWhite){
        this.fileName = fileName;
        if (isBlackAndWhite) {
            video = new BlackAndWhiteVideo(fileName);
        } else {
            video = new ColorVideo(fileName);
        }
    }

    @Override
    public void play() {
        video.play();
    }
}