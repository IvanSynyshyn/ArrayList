package com.synyshyn;

import com.synyshyn.interf.MyList;

/**
 * Created by Ivan Synyshyn on 17.12.2016.
 */
public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_SIZE = 10;
    private Object[] myArray;
    private int size = 0;

    public MyArrayList() {
        myArray = new Object[DEFAULT_SIZE];
    }

    public void add(E obj) {
        increaseSize();
        myArray[size++] = obj;
    }

    public void add(E... obj) {
        for (int i = 0; i < obj.length; i++) {
            increaseSize();
            myArray[size++] = obj[i];
        }
    }

    public void add(int index, E obj) {
        increaseSize();
        for (int i = size + 1; i > index; i--) {
            myArray[i] = myArray[i - 1];
        }
        myArray[index] = obj;
        size++;
    }

    public void remove(int index) {
        if (index > 0 && index < size) {
            myArray[index] = null;
            for (int tmp = index; tmp < size; tmp++) {
                myArray[tmp] = myArray[tmp + 1];
                myArray[tmp + 1] = null;
            }
            size--;
        } else {
            throw new ArrayIndexOutOfBoundsException("You can not do it. Use number between 0 and " + (size - 1));
        }
    }

    public E get(int index) {
        if (index > 0 && index < size) {
            return (E) myArray[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("You can not do it. Use number between 0 and " + (size - 1));
        }
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + myArray[i]);
        }
    }

    private void increaseSize() {
        if (size == myArray.length) {
            int newSize = myArray.length * 2;
            myArray = copyArrays(myArray, newSize);
        }
    }

    /*I do not use Arrays.copyOf() or System.arraycopy because of 'Note: you should not use any predefined and
    already exists data structures'*/
    private Object[] copyArrays(Object[] obj, int newSize) {
        Object[] newMass = new Object[newSize];
        for (int i = 0; i < obj.length; i++) {
            newMass[i] = obj[i];
        }
        return newMass;
    }
}