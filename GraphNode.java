package com.company;

public class GraphNode {
    private String Name;
    private int level;
    GraphNode()
    {
        Name="";
        level=0;
    }
    GraphNode(String n,int l)
    {
        this.Name=n;
        this.level=l;
    }
}
