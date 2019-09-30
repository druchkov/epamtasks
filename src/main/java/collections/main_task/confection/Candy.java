package collections.main_task.confection;

import collections.main_task.assortment.CandyType;

public class Candy extends Sweetness {
    private CandyType candyType;

    public Candy(String nameSweetness, int weightSweetness, CandyType candyType) {
        super(nameSweetness, weightSweetness);
        this.candyType = candyType;
    }

    public CandyType getCandyType() {
        return candyType;
    }

    public void setCandyType(CandyType candyType) {
        this.candyType = candyType;
    }

    public double getTotatCountSugarCandy() {
        return getCountSugarOneHundredGrams() * getWeightSweetness() / 100;
    }

    @Override
    public double getCountSugarOneHundredGrams() {
        return  candyType.getCountSugarOneHundredGrams();
    }

    @Override
    public String toString() {
        return "Candy " + super.toString().replace("]",
                ", candyType= " + candyType +
                ", countSugar=" + getCountSugarOneHundredGrams() +
                "]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Candy candy = (Candy) o;

        return candyType == candy.candyType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (candyType != null ? candyType.hashCode() : 0);
        return result;
    }
}
