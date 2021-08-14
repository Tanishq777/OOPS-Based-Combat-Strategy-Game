package com.company;

public class Healer extends Hero {
    Healer() {
        super("Healer");
    }
    private int attack=4;
    private int def=8;
    @Override
    public int attack()
    {
        return attack;
    }
    @Override
    public void inc()
    {
        attack++;
        def++;
    }

    @Override
    void hit(int hit)
    {
        reduce_hp(hit,def);
    }

    @Override
    int defense()
    {
        setflag(1);
        return def;
    }
    @Override
    void sp(int f)
    {
        if (f==0) {
            System.out.println("Your HP increased by 5% for next 3 moves");
            incHP();
        }

    }
}
