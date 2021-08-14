package com.company;

import java.util.Random;

public abstract class Demon {
    private int HP;
    private final String  Demon_name;
    private Random r = new Random();
    Demon()
    {
        HP=0;
        Demon_name="";
    }
    Demon(int H, String h) {
        HP = H;
        Demon_name=h;
    }
    private int Standard_deviation(int u)
    {
        int mean=u/2;
        if (mean==0)
            mean=1;
        int sd=0;
        for (int i=0;i<=u;i++) {
            sd += (int) (Math.pow(i - mean,2));
        }
        return (int) Math.sqrt(sd/mean);
    }
    int gethp()
    {
        return HP;
    }
    int getattack()
    {
        //if (HP/4==0)
       //     return 0;
       // else {
            int sd = Standard_deviation(HP / 4);
            int n =-5;
            while (n > (HP / 4) || n < 0)
                n = (int) ((r.nextGaussian() * sd) + (HP / 8));
            return n;
        //}
    }
    void reduce_hp(int hi)
        {
            if (hi==1000)
                HP=HP-(HP/20);
            else if (hi==2000)
            {
                HP-=(0.3*HP);
            }
            else
            HP=HP-hi;
        }
        int attack()
        {return  0;}
        int attack(int y)
        {y=y+1;
            return y;
        }

    //int getHP()
    //{
     //   return (int)(0.3*HP);
    //}
    public abstract void hit(int at);
    //{
      //  at=at+1;
    //}
}
