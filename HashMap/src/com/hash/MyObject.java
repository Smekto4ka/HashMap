package com.hash;

public class MyObject {
    private int a;
    private int b;
    private int c;
    private int hash;

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
        hash = a+b*10+c*100;

    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object ob) {
        if ((a == ((MyObject) ob).getA()) && (b == ((MyObject) ob).getB()) && (c == ((MyObject) ob).getC())) {
            return true;
        }
        return false;
    }


}
