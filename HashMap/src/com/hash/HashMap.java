package com.hash;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

import static java.lang.Math.abs;

public class HashMap<K, V> {
    private int length;
    private LinkedList<LinkedList> mass;
    private V removeV;
    private Kay removeKay;

    public HashMap(int length) {
        this.length = length;
        mass = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            LinkedList<Kay> list = new LinkedList<>();
            mass.add(list);
        }
    }

    public void put(K kay, V value) {
        if (0 < size(kay)) {
            for (Object k : mass.get(id(kay))) {
                if (((Kay) k).getKay().equals(kay)) {
                    ((Kay) k).setData(value);
                    return;
                }
            }
        }
        mass.get(id(kay)).add(new Kay<K, V>(kay, value));

    }

    public V get(K kay) {
        if (0 != size(kay)) {
            for (Object k : mass.get(id(kay)))
                if (kay.equals(((Kay) k).getKay())) {
                    return (V) ((Kay) k).getValue();
                }
        }
        System.out.print(" нет такого объекта");
        return null;
    }

    public int size(K kay) {
        return (mass.get(id(kay))).size();
    }

    private int id(K kay) {
        return  abs(kay.hashCode()) % length;
    }

    public V remove(K kay) {
        if (0 != size(kay)) {
            for (int i = 0; i < size(kay); i++) {
                removeKay = (Kay) mass.get(id(kay)).get(i);
                if (kay.equals(removeKay.getKay())) {
                    removeV = (V) removeKay.getValue();
                    mass.get(id(kay)).remove(i);
                    return removeV;
                }
            }
        }
        return null;
    }

}
