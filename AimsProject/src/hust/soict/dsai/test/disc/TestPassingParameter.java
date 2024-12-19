package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        // changeTitle(jungleDVD, cinderellaDVD.getTitle());
        // System.out.println("jungle dvd title: " + jungleDVD.getTitle());

        Wrapper<DigitalVideoDisc> dvd1 = new Wrapper<DigitalVideoDisc>(jungleDVD);
        Wrapper<DigitalVideoDisc> dvd2 = new Wrapper<DigitalVideoDisc>(cinderellaDVD);
        mySwap(dvd1, dvd2);
        System.out.println(dvd1);
        System.out.println(dvd2);
    }

    static class Wrapper<T> {
        T value;

        Wrapper(T value) {
            this.value = value;
        }

        public String toString() {
            return value.toString();
        }
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }

    public static <T> void mySwap(Wrapper<T> o1, Wrapper<T> o2) {
        T temp = o1.value;
        o1.value = o2.value;
        o2.value = temp;
    }
}
