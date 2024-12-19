package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public StoreScreen(Store store){
        StoreScreen.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem smAddBook = new JMenuItem("Add Book");
        smAddBook.addActionListener(new btnMenuListener());
        smUpdateStore.add(smAddBook);

        JMenuItem smAddCD = new JMenuItem("Add CD");
        smUpdateStore.add(smAddCD);
        smAddCD.addActionListener(new btnMenuListener());

        JMenuItem smAddDVD = new JMenuItem("Add DVD");
        smUpdateStore.add(smAddDVD);
        smAddDVD.addActionListener(new btnMenuListener());

        menu.add(smUpdateStore);
        // View store in MenuBar
        JMenuItem viewStoreMenu = new JMenuItem("View store");
        viewStoreMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new StoreScreen(store);
            }
        });
        menu.add(viewStoreMenu);

        // View Cart in MenuBar
        JMenuItem viewCartMenu = new JMenuItem("View cart");
        viewCartMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new CartScreen(cart);
            }
        });
        menu.add(viewCartMenu);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private class btnMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String menuItemText = e.getActionCommand();
            if (menuItemText.equals("Add Book")){
                new AddBookToStore(store);
            } else if (menuItemText.equals("Add CD")){
                new AddCDToStore(store);
            } else if (menuItemText.equals("Add DVD")){
                new AddDVDToStore(store);
            }
        }
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cartBtn = new JButton("View cart");
        cartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                new CartScreen(cart);
            }
        });
        cartBtn.setPreferredSize(new Dimension(100, 50));
        cartBtn.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartBtn);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }

        return center;
    }

    public static void initMedia() {
        Book book1 = new Book("The Lean Startup", "Business/Entrepreneurship", 14.99f);
        store.addMedia(book1);
        Book book2 = new Book("1984", "Fiction/Dystopian", 10.99f);
        store.addMedia(book2);
        Book book3 = new Book("The Da Vinci Code", "Fiction/Thriller", 9.99f);
        store.addMedia(book3);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The God Father", "Crime/Drama", "Francis Ford Coppola", 175, 12.99f);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Dark Knight", "Action/Crime/Drama", "Christopher Nolan", 152, 10.99f);
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The ShawShank Redemption", "Drama", "Frank Darabont", 142, 9.99f);
        store.addMedia(dvd3);

        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", 10.99f, "Michael Jackson");
        Track track1 = new Track("Wanna Be Startin' Somethin'", 7);
        Track track2 = new Track("Baby Be Mine", 5);
        Track track3 = new Track("Beat It", 5);

        cd1.addTrack(track1);
        cd1.addTrack(track2);
        cd1.addTrack(track3);
        store.addMedia(cd1);

    }
    public static void main(String[] args) {
        initMedia();
        new StoreScreen(store);
    }
}
