package com.company;

public class Thief extends Hero {
    public Thief() {
        super("Thief");
    }
    private int attack=6;
    private int def=4;
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
       // System.out.println("Your");
        setflag(1);
        return def;
    }
    @Override
    void sp(int i)
    {i=i+1;}
    @Override
    void sp(int IN,int max)
    {
        System.out.println("Your Have Stolen 30% of opponent's HP");
            incHP(IN,max);

    }
}
