package com.my.learn.core_java.ch13;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by tianzy on 3/18/14.
 */
public class TreeSetTest {

    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<Item>();
        parts.add(new Item(1234, "Toaster"));
        parts.add(new Item(4562, "Widget"));
        parts.add(new Item(9912, "Modem"));

        System.out.println(parts);
        System.out.println(parts.first());
        System.out.println(parts.last());

        SortedSet<Item> sortedSet = new TreeSet<Item>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getDescription().compareTo(o2.getDescription());
            }
        });
        sortedSet.addAll(parts);
        System.out.println(sortedSet);


        NavigableSet<Item> navigableSet = new TreeSet<Item>(parts);
        Item a = new Item(1234, "Toaster");
        Item b = new Item(9913, "Toaster");
        System.out.println(navigableSet.first());
        System.out.println(navigableSet.last());
        System.out.println(navigableSet.higher(a));
        System.out.println(navigableSet.lower(a));
        System.out.println(navigableSet.higher(b));
        System.out.println(navigableSet.lower(b));
        System.out.println(navigableSet.ceiling(a));
        System.out.println(navigableSet.floor(a));
        System.out.println(navigableSet.ceiling(b));
        System.out.println(navigableSet.floor(b));
    }

}

class Item implements Comparable<Item> {
    private int partion;
    private String description;
    @Override
    public int compareTo(Item other) {
        return this.partion - other.partion;
    }

    public Item(int partion, String description) {
        this.partion = partion;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return "[partion=" + partion + ", description=" + description + "]";
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == this) {
            return  true;
        }
        if (otherObject == null) {
            return false;
        }
        if (otherObject.getClass() != this.getClass()) {
            return false;
        }
        Item item = (Item)otherObject;
        return description.equals(item.description) && partion == item.partion;
    }

    @Override
    public int hashCode() {
        return 13 * description.hashCode() + 17 * partion;
    }
}
