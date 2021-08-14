package com.company;

public abstract class Hero{
    private int XP,HP,level;
    private final String Hero_name;
    private int flag=0;
    int gethp()
    {
        return HP;
    }
    void sethp()
    {
        if (level==1)
            HP=100;
        if (level==2)
            HP=150;
        if (level==3)
            HP=200;
        if (level==4)
            HP=250;
    }
    void setflag(int to)
    {
        flag=to;
    }
    int getlevel()
    {
        return level;
    }
    Hero()
    {
        XP=0;
        HP=100;
        level=1;
        Hero_name="";
    }
    public void refresh()
    {
        if (level==1)
            HP=100;
        else if(level==2)
            HP=150;
        else if (level==3)
            HP=200;
        else
            HP=250;
    }
    Hero(String h) {
        XP = 0;
        HP = 100;
        Hero_name=h;
        level=1;
    }
    void incHP()
    {
        HP+=(HP/20);
    }
    void incHP(int H,int max)
    {
        if ((HP+(0.3*H))>=max)
            HP=max;
        else
            HP+=0.3*H;
    }
    void reduce_hp(int hi,int def)
    {
        if (hi<0)
        {
            if (flag==1)
                flag=0;
        }
        else {
            if (hi > HP)
                HP = 0;
            else
                HP = HP - hi;
            if (flag == 1) {
                flag = 0;
                if (def > hi)
                    HP = HP + hi;
                else
                    HP = HP + def;
            }
        }
    }
    abstract void sp(int s);
    //{int c=1;
    //}
    void sp(int y,int z)
    {int c=1;
    }
    abstract int attack();
    //{return 0;}
    abstract void hit(int c);
    //{ c=c+1;}
    abstract int defense();
    //{
    //    return 0;
    //}

    public String getHero_name() {
        return Hero_name;
    }
    void setXP(int X) {
        //if (X<0)
          //  this.XP-=X;
        //else
        this.XP += X;
    }
    int getXP() {
        return XP;
    }
    void setlevel(int l)
    {
        this.level=l;
        if (level==1)
            HP=100;
        else if(level==2)
            HP=150;
        else if (level==3)
            HP=200;
        else
            HP=250;
    }

    public abstract void inc();
    //{
      //  int i=0;
    //}

}
