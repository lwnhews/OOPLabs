public class Cart {
    public static final int MAX_NUMBERS_ORDERS = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERS];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERS) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; // Clear the last spot
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc was not found.");
        }
    }

    public float totalCost() {
        float result = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            result += itemsOrdered[i].getCost();
        }
        return result;
    }

    public void displayCart() {
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println("Disk " + (i+1) + ":");
            System.out.println("Title: " + itemsOrdered[i].getTitle());
            System.out.println("Category: " + itemsOrdered[i].getCategory());
            System.out.println("Director: " + itemsOrdered[i].getDirector());
            System.out.println("Length: " + itemsOrdered[i].getLength());
            System.out.println("Cost: " + itemsOrdered[i].getCost());
        }
    }
}
