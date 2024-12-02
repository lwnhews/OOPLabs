package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        boolean found = false;
        for (Media m : itemsInStore) {
            if (m.equals(media)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("The media is already added");
        } else {
            itemsInStore.add(media);
            System.out.println("The media has been added");
        }
    }

    public void removeMedia(Media media) {
        boolean found = false;
        for (Media m : itemsInStore) {
            if (m.equals(media)) {
                found = true;
                break;
            }
        }
        if (found) {
            itemsInStore.remove(media);
            System.out.println("The media has been removed");
        } else {
            System.out.println("Media not found");
        }
    }

    public Media getMedia(String title) {
        Media result = null;
        for (Media media : itemsInStore) {
            if (media.isMatch(title)) {
                result = media;
                break;
            }
        }
        return result;
    }

    public Media getMedia(int id) {
        Media result = null;
        for (Media media : itemsInStore) {
            if (media.getId() == id) {
                result = media;
                break;
            }
        }
        return result;
    }

    public void addMedia(Scanner sc) {
        System.out.println("Choose type of media to add");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            System.out.println("Please enter the information of the book");
            System.out.println("Title:");
            String title = sc.nextLine();
            System.out.println("Category:");
            String category = sc.nextLine();
            System.out.println("Cost:");
            float cost = sc.nextFloat();
            sc.nextLine();
            Book book = new Book(title, category, cost);
            itemsInStore.add(book);
        } else if (choice == 2) {
            System.out.println("Please enter the information of the DVD");
            System.out.println("Title:");
            String title = sc.nextLine();
            System.out.println("Category:");
            String category = sc.nextLine();
            System.out.println("Director:");
            String director = sc.nextLine();
            System.out.println("Length:");
            int length = sc.nextInt();
            System.out.println("Cost:");
            float cost = sc.nextFloat();
            sc.nextLine();
            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            itemsInStore.add(dvd);
        } else if (choice == 3) {
            System.out.println("Please enter the information of the CD");
            System.out.println("Title:");
            String title = sc.nextLine();
            System.out.println("Category:");
            String category = sc.nextLine();
            System.out.println("Artist:");
            String artist = sc.nextLine();
            System.out.println("Director:");
            String director = sc.nextLine();
            System.out.println("Length:");
            int length = sc.nextInt();
            System.out.println("Cost:");
            float cost = sc.nextFloat();
            sc.nextLine();
            CompactDisc cd = new CompactDisc(title, category, artist, director, length, cost);
            itemsInStore.add(cd);
        } else {
            System.out.println("Invalid choice");
        }
    }

    public void displayStore() {
        System.out.println("***********************STORE***********************");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
        System.out.println("***************************************************");
    }
}
