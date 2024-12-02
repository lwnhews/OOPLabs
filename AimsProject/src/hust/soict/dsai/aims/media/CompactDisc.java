package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, String category, String artist, String director, int length, float cost) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    public void addTrack(Track track) {
        boolean found = false;
        for (Track t : tracks) {
            if (t.equals(track)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("The track already in the list");
        } else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        boolean found = false;
        for (Track t : tracks) {
            if (t.equals(track)) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The track is not in the list");
        } else {
            tracks.add(track);
        }
    }

    public int getLength() {
        int length = 0;
        for (Track track : tracks) {
            length += track.getLength();
        }
        return length;
    }

    public String toString() {
        return String.valueOf(this.getId()) + ". CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist() + " - " + this.getDirector() + " - " + String.valueOf(this.getLength()) + ": " + String.valueOf(this.getCost());
    }

    public void play() {
        System.out.println("Playing CD: " + this.getTitle() + " - " + this.getArtist());
        for (Track track : this.tracks) {
            track.play();
        }
    }
}
