package collections.main_task.assortment;

public enum CandyType {
    GLAZED(51.3),
    WAFFLE(56),
    NOUGAT(66),
    UNGLAZED(54.9),
    JELLY(75),
    FONDAT(51.4),
    FRUIT(59);

    private double countSugarOneHundredGrams;

    CandyType(double countSugarOneHundredGrams) {
        this.countSugarOneHundredGrams = countSugarOneHundredGrams;
    }

    public double getCountSugarOneHundredGrams() {
        return countSugarOneHundredGrams;
    }
}
