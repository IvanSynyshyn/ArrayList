package com.synyshyn;

import com.synyshyn.interf.MyList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by Ivan Synyshyn on 18.12.2016.
 */
public class MyArrayListTest {

    private MyList<Integer> list;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before MyArrayListTest.class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After MyArrayListTest.class");
    }

    @Before
    public void initTest() {
        list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @After
    public void afterTest() {
        list = null;
    }

    @Test
    public void add() throws Exception {
        MyList listToAdd = new MyArrayList();
        assertEquals(0, listToAdd.size());
        listToAdd.add(new Object());
        assertNotNull(listToAdd);
        assertEquals(1, listToAdd.size());
    }

    @Test
    public void add1() throws Exception {
        MyList listToAdd = new MyArrayList();
        assertEquals(0, listToAdd.size());
        listToAdd.add(new Object(), new Object(), new Object());
        assertNotNull(listToAdd);
        assertEquals(3, listToAdd.size());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void add2() throws Exception {
        list.add(10, 15);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void remove() throws Exception {
        list.remove(5);
    }

    @Test
    public void remove1() throws Exception {
        MyList<Object> listToRemove = new MyArrayList();
        listToRemove.add(new Object(), new Object(), new Object());
        assertEquals(3, listToRemove.size());
        listToRemove.remove(1);
        assertEquals(2, listToRemove.size());
    }

    @Test
    public void get() throws Exception {
        assertEquals(2, (long) list.get(1));
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, list.size());
    }
}