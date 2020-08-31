package com.hash;

public class Tree<K, V> {

    private Tree father;
    private Tree ich;
    private Tree sonLeft;
    private Tree sonRight;
    private Tree memory;
    private Kay data;
    private HashMapTree hashMapTree;
private int size;

    public void setFather(Tree father) {
        this.father = father;
    }

    public Tree getIch() {
        return ich;
    }

    public K getKay() {
        return (K) data.getKay();
    }

    public Tree getSonLeft() {
        return sonLeft;
    }

    public void setSonLeft(Tree sonLeft) {
        this.sonLeft = sonLeft;
    }

    public Tree getSonRight() {
        return sonRight;
    }

    public void setSonRight(Tree sonRight) {
        this.sonRight = sonRight;
    }

    public Tree(Tree father, Kay data, HashMapTree hashMapTree) {
        this.father = father;
        this.data = data;
        this.hashMapTree = hashMapTree;

    }

    public void addIch(Tree ich) {
        this.ich = ich;
    }

    public void addSonLeft(Kay temporalKay) {
        sonLeft = new Tree(ich, temporalKay, hashMapTree);
        sonLeft.addIch(sonLeft);
    }

    public void addSonRight(Kay temporalKay) {
        sonRight = new Tree(ich, temporalKay, hashMapTree);
        sonRight.addIch(sonRight);
    }

    public void put(K kay, V value) {
        if ((kay.hashCode() == data.getHash()) && (kay.equals(data.getKay()))) {
            data.setValue(value);
        } else {
            if (kay.hashCode() < data.getHash()) {
                if (sonLeft == null) {
                    addSonLeft(new Kay<K, V>(kay, value));
                } else {
                    sonLeft.put(kay, value);
                }
            }
            if (kay.hashCode() >= data.getHash()) {
                if (sonRight == null) {
                    addSonRight(new Kay<K, V>(kay, value));
                } else {
                    sonRight.put(kay, value);
                }
            }
        }

    }

    public V get(K kay) {
        if ((kay.hashCode() == data.getHash()) && (kay.equals(data.getKay()))) {
            return (V) data.getValue();
        } else {
            if (kay.hashCode() < data.getHash()) {
                if (sonLeft != null)
                    return (V) sonLeft.get(kay);
            }
            if (kay.hashCode() >= data.getHash()) {
                if (sonRight != null)
                    return (V) sonRight.get(kay);
            }
        }
        return null;
    }

    public V remove(K kay) {
        if ((kay.hashCode() == data.getHash()) && (kay.equals(data.getKay()))) {
            if (redefinition()) {
                if (sonLeft != null)
                    sonLeft.transfer(memory);
            }
            return (V) data.getValue();

        } else {
            if (kay.hashCode() < data.getHash()) {
                if (sonLeft != null)
                    return (V) sonLeft.remove(kay);
            }
            if (kay.hashCode() >= data.getHash()) {
                if (sonRight != null)
                    return (V) sonRight.remove(kay);
            }

        }
        return null;
    }

    public void transfer(Tree link) {
        if (sonRight == null) {
            sonRight = link;
            sonRight.setFather(ich);
        } else {
            sonRight.transfer(link);
        }
    }

    private boolean redefinition() {
        if (sonRight == null) {
            if (father != null) {
                if (sonLeft != null) {
                    sonLeft.setFather(father.getIch());
                    father.setSonLeft(sonLeft.getIch());
                } else {
                    father.setSonLeft(null);
                }
            } else {
                if (sonLeft != null) {
                    sonLeft.setFather(null);
                    hashMapTree.setLink(data.getKay(), sonLeft.getIch());
                } else {
                    hashMapTree.setLink(data.getKay(), null);
                }
            }
            return false;
        }
        memory = sonRight.getSonLeft();

        if (sonLeft != null) {
            sonRight.setSonLeft(sonLeft.getIch());
            sonLeft.setFather(sonRight.getIch());
        } else {
            sonRight.setSonLeft(null);
        }
        if (father != null) {
            father.setSonLeft(sonRight.getIch());
            sonRight.setFather(father.getIch());
        } else {
            sonRight.setFather(null);
            hashMapTree.setLink(data.getKay(), sonRight.getIch());
        }
        if (memory == null)
            return false;
        return true;
    }

    public int size(){
        size = 0;
        if (sonLeft!=null)
           size += sonLeft.size();
        if (sonRight!=null)
            size += sonRight.size();
        return size + 1;
    }
}
