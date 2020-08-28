package com.hash;

public class Main {

    public static void main(String[] args) {
        HashMap<MyObject, String> hashMap = new HashMap<>(3);

        hashMap.put(new MyObject(1, 2, 3), "789456123");
        hashMap.put(new MyObject(12, 23, 36), "7417");
        hashMap.put(new MyObject(1, 2, 3), "78921");
        hashMap.put(new MyObject(15, 96, 32), "88");
        hashMap.put(new MyObject(14, 25, 36), "753");

      System.out.println(hashMap.remove(new MyObject(1, 2, 3)));





    }
}
