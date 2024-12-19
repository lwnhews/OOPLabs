package hust.soict.dsai.aims.cart;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.media.MediaComparatorByTitleCost;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERS = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void setItemsOrdered(ObservableList<Media> itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    public void addMedia(Media media) throws LimitExceededException{
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERS){
            boolean checkExist = itemsOrdered.contains(media);
            if (!checkExist){
                itemsOrdered.add(media);
            }
        } else{
            throw new LimitExceededException("Error: The number of media has reached its limit!");
        }
    }

    public void removeMedia(Media media) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.equals(media)) {
                found = true;
                itemsOrdered.remove(media);
                System.out.println("The media has been removed");
                break;
            }
        }
        if (!found) {
            System.out.println("Media not found");
        }
    }

    public float totalCost() {
        float cost = 0;
        for (Media media : itemsOrdered) {
            cost += media.getCost();
        }
        return cost;
    }

    public void displayCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public void searchMedia(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                found = true;
                System.out.println("Media is found. Displaying information:");
                System.out.println(media.toString());
                break;
            }
        }
        if (!found) {
            System.out.println("Media not found");
        }
    }

    public void searchMedia(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                found = true;
                System.out.println("Media is found. Displaying information:");
                System.out.println(media.toString());
                break;
            }
        }
        if (!found) {
            System.out.println("Media not found");
        }
    }

    public Media getMedia(String title) {
        Media result = null;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                result = media;
                break;
            }
        }
        return result;
    }

    public void filterMedia(String title) throws LimitExceededException {
        boolean found = false;
        Cart cart = new Cart();
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                found = true;
                cart.addMedia(media);
            }
        }
        if (!found) {
            System.out.println("Media not found");
        } else {
            cart.displayCart();
        }
    }

    public void emptyCart() {
        itemsOrdered.clear();
    }

    public List<Media> searchById(String keyword) {
        try {
            int id = Integer.parseInt(keyword);
            return itemsOrdered.stream().filter(media -> media.getId() == id).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            return Collections.emptyList();
        }
    }

    public List<Media> searchByTitle(String keyword) {
        return itemsOrdered.stream().filter(media -> media.getTitle().toLowerCase().contains(keyword.toLowerCase())).collect(Collectors.toList());
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, COMPARE_BY_COST_TITLE);
    }

    public void placeOrder(){
        itemsOrdered.clear();
    }
}
