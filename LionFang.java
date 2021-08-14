package com.company;
import java.util.Random;

public class LionFang extends Demon {
    private Random r1 = new Random();
    LionFang() {
        super(250,"LionFang");
    }
    @Override
    public int attack(int h)
    {
        int ro=r1.nextInt(11);
        if (ro==5)
        {
            return (h/2);
        }
        return getattack();
    }
    @Override
    public void hit(int hit)
    {
        reduce_hp(hit);
    }
}
