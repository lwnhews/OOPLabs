package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media{
    private ArrayList<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        boolean found = false;
        for (String author : authors) {
            if (author.equals(authorName)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("The author already in the list");
        } else {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        boolean found = false;
        for (String author : authors) {
            if (author.equals(authorName)) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The author is not in the list");
        } else {
            authors.remove(authorName);
        }
    }

    public String toString() {
        return String.valueOf(this.getId()) + ". Book - " + this.getTitle() + " - " + this.getCategory() +  ": " + String.valueOf(this.getCost());
    }
}
