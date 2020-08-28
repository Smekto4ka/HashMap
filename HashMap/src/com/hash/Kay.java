package com.hash;

public class Kay<K, V> {
    private int hash;
    private K kay;
    private V data;

    public Kay(K kay, V data) {
        this.data = data;
        this.kay = kay;
        this.hash = kay.hashCode();
    }

    public K getKay() {
        return kay;
    }
/*
    public void setKay(K kay) {
        this.kay = kay;
    }
*/
    public V getValue() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public int getHash() {
        return hash;
    }

}
