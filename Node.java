package com.company;

public class Node {
    public Hero Hr;
    private String Name;
    private String hero;
        Node() {
            Name="";
            hero="";
        }
        Node (String n,String h,Hero p) {
            Name = n;
            hero= h;
            Hr=p;
        }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }
}
