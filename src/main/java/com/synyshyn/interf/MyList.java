package com.synyshyn.interf;

/**
 * Created by Ivan Synyshyn on 18.12.2016.
 */
public interface MyList<E> {
    void add(E obj);
    void add(E... obj);
    void add(int index, E obj);
    void remove(int index);
    E get(int index);
    int size();
    void print();
}
