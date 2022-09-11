package arraylist;

import java.util.ArrayList;

public class App{
    public static void main(String[] args) {
        CustomArrayList<Integer> lst = new CustomArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        lst.add(6);
        lst.add(7);
        lst.add(8);
        lst.add(9);
        lst.add(10);
        lst.remove(4);
        lst.remove((Integer) 10);
        System.out.println(lst.set(5, 10));
        lst.removeRange(3,5);
        lst.trimToSize();
    }
}
