package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, String category, String artist, String director, int length, float cost) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, null, 0, cost);
        this.artist = artist;
    }

    public CompactDisc(String cd_title) {
		super(cd_title, null, null, 0, 0);
        this.tracks = new ArrayList<>();
	}

	public CompactDisc(String cd_title, String cd_category, float cd_cost) {
		super(cd_title, cd_category, null, 0, cd_cost);
        this.tracks = new ArrayList<>();
	}

	public CompactDisc(String cd_title, String cd_category, String cd_director, float cd_cost) {
		super(cd_title, cd_category, cd_director, 0, cd_cost);
        this.tracks = new ArrayList<>();
	}

    public CompactDisc(String cd_title, String cd_category, String cd_director, int length, float cd_cost) {
		super(cd_title, cd_category, cd_director, length, cd_cost);
        this.tracks = new ArrayList<>();
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

    public void play() throws PlayerException{
        System.out.println("Playing CD: " + this.getTitle() + " - " + this.getArtist());
        if (getLength() > 0) {
            for (int i = 0; i < tracks.size(); i++) {
                Track track = tracks.get(i);
                System.out.println("Track no." + String.valueOf(i+1) + "...");
                track.play();
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive .");
        }   
    }
}
