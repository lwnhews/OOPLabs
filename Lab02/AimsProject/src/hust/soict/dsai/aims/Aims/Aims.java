package hust.soict.dsai.aims.Aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc disc1 = new DigitalVideoDisc("The Lion King", 
            "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(disc1);

        DigitalVideoDisc disc2 = new DigitalVideoDisc("Star Wars", 
            "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(disc2);

        DigitalVideoDisc disc3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(disc3);

        anOrder.displayCart();
        System.out.println("Total Cost is: " + anOrder.totalCost());
        anOrder.removeDigitalVideoDisc(disc2);
        System.out.println("Total Cost is: " + anOrder.totalCost());
    }
}
