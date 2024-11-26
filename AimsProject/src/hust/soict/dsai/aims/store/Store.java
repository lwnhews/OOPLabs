package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.util.List;
import java.util.ArrayList;

public class Store {
    private List<DigitalVideoDisc> itemsInStore;

    public Store() {
        itemsInStore = new ArrayList<>();
    }

    public void addDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (DigitalVideoDisc disc : itemsInStore) {
            if (disc.equals(dvd)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("The dvd is already added.");
        } else {
            itemsInStore.add(dvd);
            System.out.println("The dvd has been added.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (DigitalVideoDisc disc : itemsInStore) {
            if (disc.equals(dvd)) {
                found = true;
                break;
            }
        }

        if (found) {
            itemsInStore.remove(dvd);
            System.out.println("The dvd has been removed.");
        } else {
            System.out.println("DVD not found.");
        }
    }

    public void displayStore() {
        int index = 1;
        for (DigitalVideoDisc disc : itemsInStore) {
            System.out.println(index++ + ". " + disc.toString());
        }
    }
}
