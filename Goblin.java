package com.company;

public class Goblin extends Demon {
    Goblin() {
        super(100,"Goblin");
    }
    @Override
    public int attack()
    {
        return getattack();
    }
    @Override
    public void hit(int hit)
    {
        reduce_hp(hit);
    }
}
