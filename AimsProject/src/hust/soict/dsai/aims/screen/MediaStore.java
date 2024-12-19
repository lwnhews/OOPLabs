package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
    public MediaStore(Media media, Cart cart){

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add to cart button
        JButton addCartButton = new JButton("Add to cart");
        addCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    cart.addMedia(media);
                } catch (LimitExceededException e1) {
                    e1.printStackTrace();
                }
                // cart.print();
            }
        });
        container.add(addCartButton);

        // Play Button
        if (media instanceof Playable){
            JButton playButton = new JButton("Play");

            playButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Play Media");
                    dialog.setSize(200, 100);
                    dialog.setModal(true);

                    Playable playableMedia = (Playable) media;
                    String mediaInfo = "";
                    try {
                        mediaInfo = "<html>" + playableMedia.playGUI().replace("\n", "<br>") + "</html>";
                    } catch (PlayerException e1) {
                        e1.printStackTrace();
                    }
                    JLabel mediaLabel = new JLabel(mediaInfo);
                    mediaLabel.setVerticalAlignment(JLabel.CENTER);
                    mediaLabel.setHorizontalAlignment(JLabel.CENTER);

                    dialog.add(mediaLabel);
                    dialog.setVisible(true);
                    dialog.dispose();
                }
            });

            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
