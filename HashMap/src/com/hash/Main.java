package com.hash;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>(3);

        hashMap.put("asdfgg", "789456123");
        hashMap.put("qwert", "7417");
        hashMap.put("asdfgg", "78921");
        hashMap.put("qsdfgm", "88");
        hashMap.put("[lkjbvc]", "753");

      System.out.println(hashMap.remove("asdfgg"));
        System.out.println(hashMap.remove("qwert"));
        System.out.println(hashMap.remove("qsdfgm"));






    }
}
