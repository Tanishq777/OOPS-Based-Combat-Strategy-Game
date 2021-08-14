package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Graph g=new Graph();
        ArrayList<SideKick> side= new ArrayList<SideKick>();
        ArrayList<Node> Data=new ArrayList<Node>();
        boolean b=true,bo=true,t=true;
        int uflag=0,loc=0,le=0,df=0,cp=0,cflag=0,no=0,flag2=0,da=0,tds=0,sdflag=0,clone=0,spdef=0;
        int locf=1000,paplu=0,finalab=0,finalsd=0;
        int[] a=new int[3];
        a[0]=0;
        a[1]=1;
        a[2]=2;
        String hname;
        int count=0;
        while (b) {
            bo=true;
            t=true;
            paplu=0;
            System.out.println("Welcome To ArchLegends");
            System.out.println("Choose Your Option");
            System.out.println("1) New User");
            System.out.println("2) Existing User");
            System.out.println("3) EXIT");
            int n = s.nextInt();
            switch (n) {
                case 1:
                    Hero pl;
                    System.out.println("Enter Username");
                    String name = s.next();
                    System.out.println("Choose a Hero");
                    System.out.println("1) Warrior");
                    System.out.println("2) Thief");
                    System.out.println("3) Mage");
                    System.out.println("4) Healer");
                    no = s.nextInt();
                    if (no == 1) {
                        hname = "Warrior";
                        pl = new Warrior();
                    }
                    else if (no == 2) {
                        hname = "Thief";
                        pl = new Thief();
                    }
                    else if (no == 3) {
                        hname = "Mage";
                        pl = new Mage();
                    }
                    else {
                        hname = "Healer";
                        pl = new Healer();
                    }
                    Data.add(new Node(name, hname,pl));
                    System.out.println("User Creation Done!! UserName- " + name + " Hero Type: " + hname);
                    System.out.println("Log in To Play the Game, Exiting...");
                    break;

                case 2:
                    System.out.println("Enter Username");
                    String user= s.next();
                    int flag=0;
                    for(int i=0;i<Data.size();i++)
                    {
                        if (Data.get(i).getName().equals(user)) {
                            flag =i;
                            flag2=1;
                            break;
                        }
                    }
                    if (flag2==1)
                    {
                        cflag=0;
                        uflag=0;
                        count=0;
                        g.Build();  // building graph
                        System.out.println("User Found....Logging In");
                        System.out.println("Welcome "+user);
                        System.out.println("You Are At Starting Location, Choose Path:");
                        System.out.println("1) Go to Location 0");
                        System.out.println("2) Go to Location 1");
                        System.out.println("3) Go to Location 2");
                        System.out.println("Enter -1 to Exit");
                        while (t)
                        {
                            bo=true;
                            if (uflag==1)
                            {
                                System.out.println("You Are At "+loc+" Location, Choose Path:");
                                a=g.adj(loc,locf);
                                System.out.println("1) Go to Location "+a[0]);
                                System.out.println("2) Go to Location "+a[1]);
                                System.out.println("3) Go to Location "+a[2]);
                                if (locf!=1000)
                                    System.out.println("4) Go Back to Location "+locf);
                                System.out.println("Enter -1 to Exit");
                            }
                            int c=s.nextInt();
                            switch (c)
                            {
                                case 1:
                                    System.out.println("Moving to location "+a[0]);
                                    loc=a[0];
                                    break;
                                case 2:
                                    System.out.println("Moving to location "+a[1]);
                                    loc=a[1];
                                    break;
                                case 3:
                                    System.out.println("Moving to location "+a[2]);
                                    loc=a[2];
                                    break;
                                case 4:
                                    System.out.println("Moving to location "+locf);
                                    loc=locf;
                                    paplu=0;
                                    break;
                                case -1:t=false;
                                    tds=1;
                                    //System.exit(0);
                                    break;
                            }
                            //if (paplu==1)
                            locf=loc;
                            //paplu=1;
                            if (tds==1) {
                                tds=0;
                                break;
                            }
                            //loc=g.loc();
                            le=g.level(loc);
                            uflag=1;
                            if (le==4)
                            {
                                System.out.println("The Boss LionFang Has Come To See Your End");
                                System.out.println("Are You Ready !! Defeat The Boss To Conquer ThunderForge Kingdom.");
                            }
                            System.out.println("Fighting Started! Your Fighting a level "+le+" Monster");
                            Demon de;
                            if (le==1)
                                de=new Goblin();
                            else if (le==2)
                                de=new Zombie();
                            else if(le==3)
                                de=new Fiend();
                            else
                                de=new LionFang();
                            int Hero_hp= Data.get(flag).Hr.gethp();
                            int Demon_hp=de.gethp();
                            if (sdflag==1 || finalsd==1) {
                                finalsd=1;
                                System.out.println("Type 'yes' if you wish to use a sidekick, else type 'no'");
                                String dec = s.next();
                                if (dec.equals("yes")) {
                                    Collections.sort(side,new sidekickXPComparator());
                                    System.out.print("You have a sidekick "+side.get(0).getSk_name()+" with you. ");
                                    System.out.println("Attack of sidekick is " +side.get(0).getAttack());
                                    if (side.get(0).getSk_name().equals("minion") && finalab==0) {
                                        System.out.println("Press 'c' to use cloning ability. Else press 'f' to move to the fight");
                                        String po = s.next();
                                        if (po.equals("c")) {
                                            finalab=1;
                                            Minion c1=(Minion) side.get(0).clone();
                                            Minion c2=(Minion) side.get(0).clone();
                                            Minion c3=(Minion) side.get(0).clone();
                                            System.out.println("Cloning Done");
                                            clone=1;
                                        }
                                    }
                                }
                            }
                            while(bo) {
                                count++;
                                System.out.println("Choose Move");
                                System.out.println("1) Attack");
                                System.out.println("2) Defense");
                                if (count>=4)
                                {
                                    //count=0;
                                    System.out.println("3) Special Attack");
                                }
                                int di = s.nextInt();
                                if (cflag==1) {
                                    if (no==3)
                                    {de.hit(1000);}
                                    if (no==4)
                                    {Data.get(flag).Hr.sp(0);}
                                    cp++;
                                }
                                if (di == 1) {
                                    //String hn;
                                    System.out.println("You Choose to Attack");
                                    int at=Data.get(flag).Hr.attack();
                                    System.out.println("You attacked and inflicted "+at+" damage to the monster.");
                                    if (clone==1 && side.size()!=0)
                                    {
                                        System.out.println("SideKick attacked and inflicted "+(int)side.get(0).getAttack()+" damage to the monster.");
                                        System.out.println("SideKick attacked and inflicted "+(int)side.get(0).getAttack()+" damage to the monster.");
                                        System.out.println("SideKick attacked and inflicted "+(int)side.get(0).getAttack()+" damage to the monster.");
                                        System.out.println("SideKick attacked and inflicted "+(int)side.get(0).getAttack()+" damage to the monster.");
                                        de.hit((int) (at+(4*side.get(0).getAttack())));
                                    }
                                    else if (sdflag==1)
                                    {
                                        System.out.println("SideKick attacked and inflicted "+(int)side.get(0).getAttack()+" damage to the monster.");
                                        de.hit((int) (at+side.get(0).getAttack()));
                                    }
                                    else
                                        de.hit(at);
                                }
                                else if (di == 2) {
                                    System.out.println("You Choose to Defend");
                                    df=Data.get(flag).Hr.defense();
                                    if (sdflag==1 && le==2 && side.size()!=0)
                                        if (side.get(0).getSk_name().equals("knight")) {
                                            System.out.println("Monster Attack reduced By " + (df + 5));
                                            spdef=1;
                                        }
                                        else
                                            System.out.println("Monster Attack reduced By "+df);
                                    else
                                        System.out.println("Monster Attack reduced By "+df);
                                }
                                else if (di==3) {
                                    count=0;
                                    System.out.println("Special power activated");
                                    System.out.println("Performing special attack");
                                    if (no==2)
                                    {
                                        int ba=de.gethp();
                                        de.hit(2000);
                                        Data.get(flag).Hr.sp(ba,Hero_hp);
                                    }
                                    else {
                                        Data.get(flag).Hr.sp(0);
                                        cflag = 1;
                                        cp = 0;
                                    }
                                }
                                if (de.gethp()<=0) {
                                    System.out.println("Your Hp: " + Data.get(flag).Hr.gethp() + "/" + Hero_hp + " Monsters Hp: 0/" + Demon_hp);
                                    if (clone==1 && side.size()!=0) {
                                        System.out.println("SideKick HP "+side.get(0).getHP());
                                        System.out.println("SideKick HP "+side.get(0).getHP());
                                        System.out.println("SideKick HP "+side.get(0).getHP());
                                        System.out.println("SideKick HP "+side.get(0).getHP());
                                    }
                                    else if (sdflag==1)
                                        System.out.println("SideKick HP "+side.get(0).getHP());
                                }
                                else {
                                    System.out.println("Your Hp: " + Data.get(flag).Hr.gethp() + "/"+Hero_hp+" Monsters Hp: " + de.gethp() + "/"+Demon_hp);
                                    if (clone==1 && side.size()!=0) {
                                        System.out.println("SideKick HP "+side.get(0).getHP());
                                        System.out.println("SideKick HP "+side.get(0).getHP());
                                        System.out.println("SideKick HP "+side.get(0).getHP());
                                        System.out.println("SideKick HP "+side.get(0).getHP());
                                    }
                                    else if (sdflag==1)
                                        System.out.println("SideKick HP "+side.get(0).getHP());
                                    System.out.println("Monster attack!");
                                    if (le == 4) {
                                        int d2 = Data.get(flag).Hr.gethp();
                                        da=de.attack(d2);
                                    } else
                                        da = de.attack();
                                    if (di == 2) {
                                        if ((da-df)<=0)
                                            System.out.println("The monster attacked and inflicted 0 damage to you.");
                                        else if (((da-df)-5)<=0)
                                        {
                                            if (spdef==1)
                                            System.out.println("The monster attacked and inflicted 0 damage to you.");
                                        }
                                        else {
                                            if (spdef==1) {
                                                System.out.println("The monster attacked and inflicted " + ((da - df) - 5) + " damage to you.");
                                                da=(da-df)-5;
                                            }
                                            else {
                                                System.out.println("The monster attacked and inflicted " + (da - df) + " damage to you.");
                                                da=da-df;
                                            }
                                        }
                                        ///Data.get(flag).Hr.hit(da); ///change
                                    }
                                    else {
                                        System.out.println("The monster attacked and inflicted " + da + " damage to you.");
                                    }
                                    if (sdflag==1 && da>=side.get(0).getHP())
                                    {
                                        System.out.println("SideKick Died");
                                        sdflag=0;
                                        side.remove(0);
                                    }
                                    else if (sdflag==1)
                                    {
                                            side.get(0).gethit(da);
                                    }
                                    if (da>=(Data.get(flag).Hr.gethp())) {
                                        System.out.println("You Died!! Better Luck Next Time");
                                        Data.get(flag).Hr.sp(1);
                                        Data.get(flag).Hr.sethp();
                                        sdflag=0;
                                        clone=0;
                                        count=0;
                                        bo=false;
                                        t=false;
                                        break;
                                    }
                                    else {
                                        if (spdef==1) {
                                            spdef=0;
                                            Data.get(flag).Hr.hit(da - 5);
                                            //side.get(0).gethit(da-5);
                                        }
                                        else {
                                            Data.get(flag).Hr.hit(da);
                                            //side.get(0).gethit(da);
                                        }
                                    }
                                    System.out.println("Your Hp: " + Data.get(flag).Hr.gethp() + "/"+Hero_hp+" Monsters Hp: " + de.gethp() + "/"+Demon_hp);
                                    if (clone==1 && side.size()!=0) {
                                        System.out.println("SideKick HP "+side.get(0).getHP());
                                        System.out.println("SideKick HP "+side.get(0).getHP());
                                        System.out.println("SideKick HP "+side.get(0).getHP());
                                        System.out.println("SideKick HP "+side.get(0).getHP());
                                    }
                                    else if (sdflag==1)
                                        System.out.println("SideKick HP "+side.get(0).getHP());
                                    if (cp == 3) {
                                        cp = 0;
                                        Data.get(flag).Hr.sp(1);
                                        cflag = 0;
                                    }
                                }
                                if (de.gethp()<=0)
                                {
                                    clone=0;
                                    bo=false;
                                    System.out.println("Monster killed!");
                                    System.out.println(le*20+" XP awarded");
                                    Data.get(flag).Hr.setXP(le*20);
                                    if (sdflag==1) {
                                        System.out.println(le * 2 + " SideKick XP awarded");
                                        side.get(0).setXP(le * 2);
                                    }
                                    if (loc!=20) {
                                        System.out.println("Fight won proceed to the next location.");
                                        System.out.println("If you would like to buy a Sidekick, type 'yes', else type 'no' to upgrade your level.");
                                        String buy = s.next();
                                        if (buy.equals("yes")) {
                                            System.out.println("Your Current XP is " + Data.get(flag).Hr.getXP() + ".");
                                            System.out.println("If you want to buy a Minion, press 1");
                                            System.out.println("If you want to buy a Knight, press 2");
                                            int sk = s.nextInt();
                                            System.out.print("XP to Spend:");
                                            int spend = s.nextInt();  // spending XP to buy sidekick
                                            if ((spend>(Data.get(flag).Hr.getXP())) && spend>=5)
                                            {
                                                System.out.println("You Do not have "+spend+" XP");
                                                System.out.println("Increasing Your Level...");
                                            }
                                            else {
                                                sdflag=1;
                                                Data.get(flag).Hr.setXP(-1 * (spend));
                                                if (sk==1) {
                                                    System.out.println("You Have bought a SideKick: Minion");
                                                    side.add(new Minion());
                                                    side.get(side.size()-1).incattack(spend-5);
                                                }
                                                else
                                                {
                                                    System.out.println("You Have bought a SideKick: Knight");
                                                    side.add(new Knight());
                                                    side.get(side.size()-1).incattack(spend-8);
                                                }
                                                System.out.println("XP of SideKick:" +side.get(side.size()-1).getXP());
                                                System.out.println("attack of SideKick:" +side.get(side.size()-1).getAttack());
                                            }
                                        } else if (buy.equals("no")) {
                                            System.out.println("Level Up:level:" + ((Data.get(flag).Hr.getlevel()) + 1));
                                            Data.get(flag).Hr.setlevel(Data.get(flag).Hr.getlevel() + 1);
                                            Data.get(flag).Hr.inc();
                                        }
                                        side.get(0).refresh();
                                        Data.get(flag).Hr.refresh();
                                    }
                                    if (loc==20) {
                                        System.out.println("You Have Win The Game !!!");
                                        System.out.println("You Have Saved Kingdom ThunderForge !");
                                        t = false;
                                        //System.exit(0);
                                    }
                                }
                            }}
                    }
                    else
                        System.out.println("User Not Found...Going To Menu");
                    break;
                case 3:System.exit(0);
                    break;

            }
        }

    }
}

