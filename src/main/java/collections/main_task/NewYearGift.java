package collections.main_task;

import collections.main_task.confection.Candy;
import collections.main_task.confection.Sweetness;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NewYearGift {
    private List<? extends Sweetness> sweetGift;

    public NewYearGift(List<? extends Sweetness> sweetGift) {
        this.sweetGift = sweetGift;
    }

    public List<? extends Sweetness> getSweetGift() {
        return sweetGift;
    }

    public double getTotalWeigthGift() {
        double totalWeight = 0;
        for (Sweetness sweetness : sweetGift) {
            totalWeight += sweetness.getWeightSweetness();
        }
        return totalWeight;
    }

    public NewYearGift sortByWeight() {
        Collections.sort(sweetGift, new Comparator<Sweetness>() {
            @Override
            public int compare(Sweetness o1, Sweetness o2) {
                return o1.getWeightSweetness() - o2.getWeightSweetness();
            }
        });
        return this;
    }

    public NewYearGift sortByCountSugar() {
        Collections.sort(sweetGift, new Comparator<Sweetness>() {
            @Override
            public int compare(Sweetness o1, Sweetness o2) {
                return Double.compare(o1.getCountSugarOneHundredGrams(), o2.getCountSugarOneHundredGrams());
            }
        });
        return this;
    }

    public List<Candy> searсhSweetsInRangeCountSugar(double minSugat, double maxSugar) {
        List<Candy> allCandies = getCandies();
        List<Candy> candiesInRange = new ArrayList<>();
        for (int i = 0; i < allCandies.size() ; i++) {
            if (allCandies.get(i).getCountSugarOneHundredGrams() >= minSugat
            && allCandies.get(i).getCountSugarOneHundredGrams() <= maxSugar) {
                candiesInRange.add(allCandies.get(i));
            }
        }
        return allCandies;
    }

    private List<Candy> getCandies() {
        List<Candy> candies = new ArrayList<>();
        for(Sweetness sweetness: sweetGift) {
            if (sweetness instanceof Candy) {
                candies.add((Candy) sweetness);
            }
        }
        return candies;
    }

    @Override
    public String toString() {
        return "NewYearGift{" +
                "sweetGift=" + sweetGift.toString() +
                '}';
    }
}
