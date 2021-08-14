package com.company;

import java.util.Random;

class Graph {
    private Random rand = new Random();
   // public int loc;
   private int[][] graph = new int[21][21];

    Graph()
    {
    for(int i=0;i<=20;i++)
    {
        for (int j=0;j<=20;j++)
        {
            graph[i][j]=0;//rand.nextInt(3)+1;
        }
    }
    graph[0][1]=1;
    graph[0][2]=1;
    graph[0][4]=1;
    graph[4][8]=1;
    graph[4][12]=1;
    graph[4][16]=1;
    graph[8][9]=1;
    graph[8][12]=1;
    graph[8][20]=1;
    graph[12][20]=1;
    graph[16][12]=1;
    graph[16][20]=1;
    graph[16][19]=1;
    graph[19][20]=1;
    graph[19][14]=1;
    graph[14][20]=1;
    graph[14][10]=1;
    graph[10][20]=1;
    graph[2][6]=1;
    graph[2][3]=1;
    graph[6][19]=1;
    graph[6][14]=1;
    graph[6][10]=1;
    graph[10][11]=1;
    graph[11][20]=1;
    graph[11][15]=1;
    graph[15][20]=1;
    graph[15][18]=1;
    graph[18][20]=1;
    graph[18][17]=1;
    graph[3][7]=1;
    graph[3][1]=1;
    graph[7][11]=1;
    graph[7][15]=1;
    graph[7][18]=1;
    graph[17][20]=1;
    graph[17][13]=1;
    graph[13][20]=1;
    graph[13][9]=1;
    graph[9][20]=1;
    graph[1][5]=1;
    graph[5][13]=1;
    graph[5][17]=1;
    graph[5][9]=1;
    ////////////////
    graph[0][6]=1;
    graph[2][7]=1;
    graph[3][5]=1;
    graph[1][8]=1;
    for(int i=0;i<=20;i++)
    {
        for (int j=0;j<=20;j++)
        {
            if (graph[i][j]!=0)
            graph[j][i]=graph[i][j];//rand.nextInt(3)+1;
    }
    }
    /*int l=0;
        for (int i=0;i<21;i++)
        {
            System.out.print(i+"-> ");
            for (int j=0;j<21;j++)
            if (graph[l][j]!=0 && l!=j) {
                System.out.print(j+", ");
            }
            System.out.println("");
            l++;
        }*/
        //System.out.print("  ");
        /*for(int i=0;i<=20;i++)
            System.out.print(i+" ");
        System.out.println("");
        for(int i=0;i<=20;i++)
        {
            System.out.print(i+" ");
            for (int j=0;j<=20;j++)
            {
                System.out.print(+graph[i][j]+" ");//=graph[j][i];//rand.nextInt(3)+1;
            }
            System.out.println("");
        }*/
}
 void Build()   // Build graph dynamically at each login
 {
     for(int i=0;i<20;i++) {
         graph[i][i] = rand.nextInt(3) + 1;
         //graph[i][j]=
     }
     graph[20][20]=4;
 }
 int level(int num)
 {
    return (graph[num][num]);
 }
 //int loc()
 //{
 //    return loc;
 //}
 int[] adj(int l,int prev)
 {
     prev--;
     int[] a =new int[3];
     int z=0;
     for (int i=0;i<21;i++)
     {
             if (graph[l][i]!=0 && l!=i) {
                 if (z==3)
                     break ;
                 if (prev!=i)
                    a[z++] =i;
             }
         }
     return a;
 }
 //int hint(int pos)
 //{
     //for ()
 //}

}
