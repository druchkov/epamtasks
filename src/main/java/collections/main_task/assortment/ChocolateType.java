package collections.main_task.assortment;

public enum ChocolateType {
    DARK("Dark", 30.0),
    MILK("Milk", 52.0),
    WHITE("White", 59.0);

    private String nameChocolateType;
    private double countSugarOneHundredGrams;

    ChocolateType(String nameChocolateType, double countSugar) {
        this.nameChocolateType = nameChocolateType;
        this.countSugarOneHundredGrams = countSugar;
    }

    public String getNameChocolateType() {
        return this.nameChocolateType;
    }

    public double getCountSugar() {
        return this.countSugarOneHundredGrams;
    }
}
