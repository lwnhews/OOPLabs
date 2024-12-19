package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc {

    public DigitalVideoDisc(String title) {
        super(title, null, null, 0, 0);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, null, 0, 0);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, 0, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public String toString() {
        return String.valueOf(this.getId()) + ". DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + String.valueOf(this.getLength()) + ": " + String.valueOf(this.getCost());
    }

    public void play() throws PlayerException{
        if (getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive .");
        }
    }
}
