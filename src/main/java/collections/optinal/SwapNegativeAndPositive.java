package collections.optinal;

import java.util.ArrayList;

public class SwapNegativeAndPositive {
    public ArrayList<Integer> swapNegativeAndPositive(ArrayList<Integer> list) {
        int countNegativeSwap = 0;
        int i = 0;
        while (i < list.size() - countNegativeSwap) {
            if (list.get(i) > 0) {
                Integer temp = list.get(i);
                list.remove(i);
                list.add(0, temp);
            } else if (list.get(i) < 0) {
                Integer temp = list.get(i);
                list.remove(i);
                list.add(temp);
                countNegativeSwap++;
                i--;
            }
          i++;
        }
        return list;
    }
}
