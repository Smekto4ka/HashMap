package com.hash;

import static java.lang.Math.abs;

public class HashMapTree <K,V>{

    private HashMapTree hashMapTree;
    private int size;
    private Tree<K,V> [] mass;
    private int length;
    public HashMapTree (int length ){
        mass = new Tree[length];
        this.length = length;
    }
    public void setHashMapTree (HashMapTree hashMapTree){
        this.hashMapTree=hashMapTree;
    }

    public void put(K kay , V value){
        if (mass[id(kay)]==null) {
            mass[id(kay)] = new Tree(null,new Kay<K,V> (kay,value),hashMapTree);
            mass[id(kay)].addIch(mass[id(kay)]);
        }else{
            mass[id(kay)].put(kay,value);
        }
    }
    public V get (K kay){
        if (mass[id(kay)]==null)
            return null;
        return  mass[id(kay)].get(kay);
    }

    public V remove(K kay){
        if (mass[id(kay)]==null)
            return null;
        return mass[id(kay)].remove(kay);
    }

    private int id(K kay) {
        return  abs(kay.hashCode()) % length;
    }
    public void setLink(K kay ,Tree link){
        mass[id(kay)] = link;
    }
    public int size (){
        size = 0;
        for(Tree tree : mass){
            if (tree != null)
                size += tree.size();
        }
        return size;
    }
}
