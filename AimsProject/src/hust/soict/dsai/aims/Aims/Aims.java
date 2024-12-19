package hust.soict.dsai.aims.Aims;

import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    public static Store store = new Store();
    public static Cart cart = new Cart();

    public static void init() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("a");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("b","c",10);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("e", "f", "g", 5);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("h", "i", "j", 99, 7.5f);

        Track track1 = new Track("abcdefg", 6);
        Track track2 = new Track("hijklmnop", 5);

        CompactDisc cd1 = new CompactDisc("aa", "b", "cc", 60, 9);
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        CompactDisc cd2 = new CompactDisc("ab", "bb", "dd", 6);
        CompactDisc cd3 = new CompactDisc("zz", "yz", 10);
        CompactDisc cd4 = new CompactDisc("a-z");
        
        Book book1 = new Book("JJ");
        Book book2 = new Book("AA", "ZZ", 8);
        
        store.addMedia(dvd1,dvd2,dvd3,dvd4,cd1,cd2,cd3,cd4,book1,book2);
    }

    public static void main(String[] args) throws LimitExceededException, PlayerException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    viewStore(sc);
                    break;
                case 2:
                    updateStore(sc);
                    break;
                case 3:
                    seeCurrentCart(sc);
                    break;
                case 0:
                    System.out.println("Exiting AIMS!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        } while (choice != 0);
        sc.close();
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void viewStore(Scanner sc) throws LimitExceededException, PlayerException {
        store.displayStore();
        int choice;
        do {
            storeMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    seeMediaDetail(sc);
                    break;
                case 2:
                    addMediaToCart(sc);
                    break;
                case 3:
                    playMedia(sc);
                    break;
                case 4:
                    seeCurrentCart(sc);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        } while (choice != 0);
    }

    public static void seeMediaDetail(Scanner sc) throws LimitExceededException, PlayerException {
        System.out.println("Please enter the title of the media");
        String title = sc.nextLine();
        Media media = store.getMedia(title);
        if (media != null) {
            media.toString();
            int choice;
            do {
                mediaDetailsMenu();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        break;
                    case 2:
                        if (media instanceof DigitalVideoDisc) {
                            ((DigitalVideoDisc) media).play();
                        } else if (media instanceof CompactDisc) {
                            ((CompactDisc) media).play();
                        } else {
                            System.out.println("Media cannot be played");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again");
                }
            } while (choice != 0);
        } else {
            System.out.println("Media not found");
        }
    }

    public static void addMediaToCart(Scanner sc) throws LimitExceededException {
        System.out.println("Please enter the title of the media");
        String title = sc.nextLine();
        Media media = store.getMedia(title);
        if (media != null) {
            cart.addMedia(media);
            cart.displayCart();
        } else {
            System.out.println("Media not found");
        }
    }

    public static void playMedia(Scanner sc) throws PlayerException {
        System.out.println("Please enter the title of the media");
        String title = sc.nextLine();
        Media media = store.getMedia(title);
        if (media != null) {
            if (media instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) media).play();
            } else if (media instanceof CompactDisc) {
                ((CompactDisc) media).play();
            }
        } else {
            System.out.println("Media not found or cannot be played");
        }
    }

    public static void updateStore(Scanner sc) {
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            store.addMedia(sc);
        } else if (choice == 2) {
            System.out.println("Please enter the id of the media");
            int id = sc.nextInt();
            sc.nextLine();
            Media media = store.getMedia(id);
            if (media != null) {
                store.removeMedia(media);
            } else {
                System.out.println("Media not found");
            }
        } else {
            System.out.println("Invalid choice");
        }
    }

    public static void seeCurrentCart(Scanner sc) throws LimitExceededException, PlayerException {
        cart.displayCart();
        int choice;
        do {
            cartMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("1. Filter by id");
                    System.out.println("2. Filter by title");
                    int option = sc.nextInt();
                    if (option == 1) {
                        int id = sc.nextInt();
                        sc.nextLine();
                        cart.searchMedia(id);
                    } else if (option == 2) {
                        String title = sc.nextLine();
                        cart.filterMedia(title);
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 2:
                    System.out.println("1. Sort by tilte");
                    System.out.println("2. Sort by cost");
                    int option2 = sc.nextInt();
                    if (option2 == 1) {
                        cart.sortByTitleCost();
                    } else if (option2 == 2) {
                        cart.sortByCostTitle();
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 3:
                    System.out.println("Please enter the title of the media");
                    String title = sc.nextLine();
                    Media media = cart.getMedia(title);
                    if (media != null) {
                        cart.removeMedia(media);
                    } else {
                        System.out.println("Media not found");
                    }
                    break;
                case 4:
                    playMedia(sc);
                    break;
                case 5:
                    System.out.println("Order created!");
                    cart.emptyCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        } while (choice != 0);
    }
}
