package com.hash;

public class Phone {
    private String name;

    public Phone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return (int) name.charAt(0);
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Phone) obj).getName());
    }

}
