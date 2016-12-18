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

    @Test
    public void add2() throws Exception {
        MyList<Integer> listToAdd = new MyArrayList();
        listToAdd.add(0, 10);
        listToAdd.add(1, 12);
        listToAdd.add(2, 15);
        assertEquals(3, listToAdd.size());
        listToAdd.add(1, 20);
        assertEquals(4, listToAdd.size());
        assertEquals(20, (long) listToAdd.get(1));
        assertEquals(15, (long) listToAdd.get(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void add3() throws Exception {
        list.add(10, 15);
    }


    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void remove() throws Exception {
        list.remove(5);
    }

    @Test
    public void remove1() throws Exception {
        MyList<Integer> listToRemove = new MyArrayList();
        listToRemove.add(10, 20, 30, 40);
        assertEquals(4, listToRemove.size());
        assertEquals(20, (long) listToRemove.get(1));
        listToRemove.remove(1);
        assertEquals(3, listToRemove.size());
        assertEquals(30, (long) listToRemove.get(1));
    }

    @Test
    public void get() throws Exception {
        assertEquals(2, (long) list.get(1));
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, list.size());
    }

    @Test
    public void contains() throws Exception {
        assertTrue(list.contains(2));
        assertFalse(list.contains(20));
    }
}