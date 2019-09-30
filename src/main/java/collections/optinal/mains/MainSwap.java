package collections.optinal.mains;


import collections.optinal.SwapNegativeAndPositive;

import java.util.ArrayList;

public class MainSwap {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(-6);
        list.add(0);
        list.add(10);
        list.add(-3);
        list.add(5);
        list.add(-3);
        System.out.println(list);
        SwapNegativeAndPositive swapNegativeAndPositive = new SwapNegativeAndPositive();
        swapNegativeAndPositive.swapNegativeAndPositive(list);
        System.out.println(list);
    }
}
