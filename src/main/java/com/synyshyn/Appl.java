package com.synyshyn;

import com.synyshyn.interf.MyList;

/**
 * Created by Ivan Synyshyn on 17.12.2016.
 */
public class Appl {
    public static void main(String[] args) {
        MyList<User> list = new MyArrayList();
        list.add(new User("Alice", "Cooper"));
        list.add(new User("Freddie", "Mercury"));
        list.add(new User("Ozzy", "Osbourne"));
        list.add(new User("Ronny James", "Dio"));
        list.add(new User("Axl", "Rose"));

        list.print();
        System.out.println("___________________");
        System.out.println(list.get(2));
        System.out.println(list.contains(new User("Axl", "Rose")));
        System.out.println("___________________");

        list.remove(1);
        list.print();
        System.out.println("___________________");

        list.add(2, new User("James", "Hatfield"));
        list.print();
        System.out.println("___________________");

        list.add(new User("Klaus", "Maine"), new User("Bonn", "Scott"), new User("Lemmy", "Kilmister"));
        list.print();
        System.out.println("___________________");
        System.out.println("My list size: " + list.size());
    }
}