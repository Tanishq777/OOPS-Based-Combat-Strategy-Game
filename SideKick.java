package com.company;

public class SideKick implements Cloneable {
    private int HP;
    private float XP,attack,temp;
    private final String sk_name;

    public SideKick() {
        HP=100;
        XP=0;
        sk_name="";
    }
    void refresh()
    {
        HP=100;

    }
    public SideKick clone()
    {
        try{
            SideKick copy=(Minion) super.clone();
            return copy;
        } catch (CloneNotSupportedException e)
        {
            return null;
        }
    }

    String getSk_name() {
        return sk_name;
    }

    void incattack(float at)
    {
        at= (float) (0.5*(at));
        this.attack+=at;
    }
    //public abstract void attack();
    SideKick(String sk_name) {
        XP =0;
        HP = 100;
        temp=0;
        this.sk_name = sk_name;
        if (sk_name.equals("minion"))
            attack=1;
        else
            attack=2;
    }
    void gethit(int hit)
    {
        hit= (int) (hit*(1.5));
        if (hit<=0)
        {}
        else if (hit>=HP)
            this.HP=0;
        else
            this.HP-=hit;
    }
    float getXP() {
        return XP;
    }

    void setXP(float XP) {
        this.XP += XP;
        temp+=XP;
        if (temp>=5) {
            temp=0;
            attack++;
        }
    }

    int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public float getAttack() {
        return attack;
    }

    public void setAttack(float attack) {
        this.attack = attack;
    }
}
