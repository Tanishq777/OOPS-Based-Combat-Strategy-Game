package com.company;
import java.util.Comparator;

public class sidekickXPComparator implements Comparator<SideKick> {
    @Override
    public int compare(SideKick o1,SideKick o2) {
        if (o1.getXP() == o2.getXP())
            return 0;
        else if (o1.getXP() < o2.getXP())
            return 1;
        else
            return -1;
    }
}
