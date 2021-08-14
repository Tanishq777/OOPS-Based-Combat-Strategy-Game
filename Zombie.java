package com.company;

public class Zombie extends Demon {
    Zombie() {
        super(150, "Zombie");
    }
    @Override
    public int attack()
    {
        return super.getattack();
    }
    @Override
    public void hit(int hit)
    {
        super.reduce_hp(hit);
    }
}
