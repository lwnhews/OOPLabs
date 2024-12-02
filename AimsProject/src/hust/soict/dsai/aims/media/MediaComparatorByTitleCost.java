package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media o1, Media o2) {
        if (!o1.getTitle().equals(o2.getTitle())) {
            return o1.getTitle().compareToIgnoreCase(o2.getTitle());
        }
        return o1.getCost() > o2.getCost() ? -1 : o1.getCost() < o2.getCost() ? 1 : 0;
    }
}
