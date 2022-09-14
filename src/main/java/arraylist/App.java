package arraylist;


import java.util.LinkedList;

public class App{
    public static void main(String[] args) {
        LinkedList<String> lst = new LinkedList<>();
        lst.add("d");
        lst.add("a");
        lst.add(1,"b");
        System.out.println(lst);
        String a = lst.element();
    }
}
