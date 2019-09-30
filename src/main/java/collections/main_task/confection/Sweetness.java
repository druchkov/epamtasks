package collections.main_task.confection;

public abstract class Sweetness {
    private String nameSweetness;
    private int weightSweetness;

    public Sweetness(String nameSweetness, int weightSweetness) {
        this.nameSweetness = nameSweetness;
        this.weightSweetness = weightSweetness;
    }

    public String getNameSweetness() {
        return nameSweetness;
    }

    public void setNameSweetness(String nameSweetness) {
        this.nameSweetness = nameSweetness;
    }

    public int getWeightSweetness() {
        return weightSweetness;
    }

    public abstract double getCountSugarOneHundredGrams();

    public void setWeightSweetness(int weightSweetness) {
        if (weightSweetness <= 0) {
            throw new IllegalArgumentException("Weight should be more than 0");
        }
        this.weightSweetness = weightSweetness;
    }

    @Override
    public String toString() {
        return  "[" + nameSweetness +
                ", weightSweetness=" + weightSweetness +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sweetness sweetness = (Sweetness) o;

        if (Double.compare(sweetness.weightSweetness, weightSweetness) != 0) return false;
        return nameSweetness != null ? nameSweetness.equals(sweetness.nameSweetness) : sweetness.nameSweetness == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = nameSweetness != null ? nameSweetness.hashCode() : 0;
        temp = Double.doubleToLongBits(weightSweetness);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
