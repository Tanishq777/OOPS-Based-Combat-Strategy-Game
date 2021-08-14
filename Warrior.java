package com.company;

public class Warrior extends Hero {
    //public Warrior(int xp, int hp) {
     //   super(xp, hp);
    //}
    private final String name="Warrior";
    private int attack=10;
    private int def=3;

    @Override
    public void inc()
    {
        attack++;
        def++;
    }
    Warrior() {
        super("Warrior");
    }
    @Override
    public int attack()
    {
        return attack;
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
            System.out.println("Your attack and defense increased by 5 for next 3 moves");
            attack += 5;
            def += 5;
        }
        else {
            attack -= 5;
            def -= 5;
        }
    }
}
