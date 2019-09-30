package collections.main_task;

import collections.main_task.assortment.CandyType;
import collections.main_task.assortment.ChocolateType;
import collections.main_task.confection.Candy;
import collections.main_task.confection.ChocolateBar;
import collections.main_task.confection.Sweetness;

import java.util.Arrays;
import java.util.List;

public class Runner {
    static List<? extends Sweetness> gift = Arrays.asList(
            new ChocolateBar("Alpen Gold milk", 90, ChocolateType.MILK, 56),
            new ChocolateBar("Spartak dark", 100, ChocolateType.DARK, 76),
            new Candy("Toffee", 50, CandyType.UNGLAZED),
            new Candy("Alenka", 120, CandyType.WAFFLE),
            new Candy("Kapriz", 95, CandyType.GLAZED),
            new Candy("Aeroflotskie", 135, CandyType.WAFFLE)
    );

    public static void main(String[] args) {
        NewYearGift newYearGift = new NewYearGift(gift);
        System.out.println("Подарок отсортирован по весу содержимого " + newYearGift
                .sortByWeight()
                .toString()
        );
        System.out.println("Подарок отсортирован по количеству сахара в сладостях " + newYearGift
                .sortByCountSugar()
                .toString()
        );
        System.out.println("Вес подарка = " + newYearGift.getTotalWeigthGift());
        System.out.println("Конфеты в диапозоне содержания сахара [50-55] " +
                "количество штук =" + newYearGift.searсhSweetsInRangeCountSugar(50,55).size() + " "
                + newYearGift
                .searсhSweetsInRangeCountSugar(50, 55)
                .toString()
        );

    }


}
