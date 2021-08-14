package com.company;

public class Mage extends Hero {
    Mage() {
        super("Mage");
    }
    private int attack=5;
    private int def=5;
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
            System.out.println("Your opponent's HP will be reduced by 5% for next 3 moves");
            int c=1;
        }
    }
}
