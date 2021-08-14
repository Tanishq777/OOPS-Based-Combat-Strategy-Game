package com.company;

public class Fiend extends Demon {
    Fiend() {
        super(200, "Fiend");
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
