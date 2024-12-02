package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: "+ this.getLength());
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } if (!(o instanceof Track)) {
            return false;
        }
        Track track = (Track) o;
        return this.title != null && this.title.equals(track.title) && this.length == track.length;
    }
}
