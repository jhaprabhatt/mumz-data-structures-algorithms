package com.mumz.test.mania;

import java.util.*;

public class CollectionsMania {
    private String name;

    @Override
    public String toString() {
        return "CollectionsMania{" +
               "name='" + name + '\'' +
               '}';
    }

    public static void main(String args[]) {
        /*CollectionsMania first = new CollectionsMania();
        first.name = "First";

        CollectionsMania second = new CollectionsMania();
        second.name = "Second";

        TreeSet treeSet = new TreeSet();
        treeSet.add(first);
        treeSet.add(second);

        for (Object o : treeSet) {
            System.out.println(o);
        }*/

        List<CollectionsMania> list = new ArrayList<>();
        CollectionsMania first = new CollectionsMania();
        first.name = "First";
        list.add(first);

        CollectionsMania second = new CollectionsMania();
        second.name = "Second";
        list.add(second);

//        Collections.max(list);
    }
}
