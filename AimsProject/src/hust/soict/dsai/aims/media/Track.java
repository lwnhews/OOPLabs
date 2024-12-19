package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

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

    public void play() throws PlayerException{
        if (getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: "+ this.getLength());
        } else {
            throw new PlayerException("ERROR: Track length is non-positive .");
        }
    }

    public String playGUI() throws PlayerException{
        if (this.getLength() > 0){
            return "Playing track: " + this.getTitle() + " - Track length: " + this.getLength() + "\n";
        } else {
            throw new PlayerException("ERROR: Track's length is non-positive!");
        }
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
