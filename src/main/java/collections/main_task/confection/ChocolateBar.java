package collections.main_task.confection;

import collections.main_task.assortment.ChocolateType;

public class ChocolateBar extends Sweetness {
    private ChocolateType chocolateType;
    private int percentChocolate;

    public ChocolateBar(String nameSweetness, int weightSweetness,
                        ChocolateType chocolateType, int percentChocolate) {
        super(nameSweetness, weightSweetness);
        this.chocolateType = chocolateType;
        this.percentChocolate = percentChocolate;
    }

    public ChocolateType getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(ChocolateType chocolateType) {
        this.chocolateType = chocolateType;
    }

    public int getPercentChocolate() {
        return percentChocolate;
    }

    public void setPercentChocolate(int percentChocolate) {
        if (percentChocolate > 100 || percentChocolate < 1) {
            throw new IllegalArgumentException("Percent of Chocolate should be more than 0 and less than 100");
        }
        this.percentChocolate = percentChocolate;
    }

    public double getTotalCountSugarInChocolate() {
        return chocolateType.getCountSugar() * getWeightSweetness() / 100;
    }

    @Override
    public double getCountSugarOneHundredGrams() {
        return chocolateType.getCountSugar();
    }

    @Override
    public String toString() {
        return "ChocolateBar " + super.toString().replace("]",
                ", chocolateType=" + chocolateType +
                ", countChocolate=" + percentChocolate +
                ", countSugar=" + getCountSugarOneHundredGrams() +
                "]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ChocolateBar that = (ChocolateBar) o;

        if (percentChocolate != that.percentChocolate) return false;
        return chocolateType == that.chocolateType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (chocolateType != null ? chocolateType.hashCode() : 0);
        result = 31 * result + percentChocolate;
        return result;
    }
}
