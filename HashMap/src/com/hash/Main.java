package com.hash;

public class Main {

    public static void main(String[] args) {
        HashMap<MyObject,Phone> hashMap = new HashMap<>(3);

        hashMap.put(new MyObject(10,20,30), new Phone("789456123"));
        hashMap.put(new MyObject(14,12,58), new Phone("7417"));
        hashMap.put(new MyObject(74, 52 ,69), new Phone("78921"));
        hashMap.put(new MyObject(10,20,30), new Phone("88"));
        hashMap.put(new MyObject(14,12,58), new Phone("753"));

      System.out.println(hashMap.remove(new MyObject(10,20,30)).getName());// getName есть у класса Phone
        System.out.println(hashMap.remove(new MyObject(14,12,58)).getName());
        System.out.println(hashMap.remove(new MyObject(14,12,58))); //  null.getName -- Exception






    }
}
