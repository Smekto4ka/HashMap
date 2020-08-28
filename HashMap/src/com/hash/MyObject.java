package com.hash;

public class MyObject {
    private int a;
    private int b;
    private int c;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public MyObject(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }

    @Override
    public int hashCode() {
        return a + b + c;
    }

    @Override
    public boolean equals(Object ob) {
        if ((a == ((MyObject) ob).getA()) && (b == ((MyObject) ob).getB()) && (c == ((MyObject) ob).getC())) {
            return true;
        }
        return false;
    }


}
