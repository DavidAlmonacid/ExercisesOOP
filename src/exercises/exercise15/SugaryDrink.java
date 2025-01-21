package exercises.exercise15;

public class SugaryDrink extends Drink {

    private double sugarPercentage;

    public SugaryDrink(int id, double liters, double price, String brand, double sugarPercentage) {
        super(id, liters, price, brand);
        this.sugarPercentage = sugarPercentage;
    }

    public SugaryDrink(int id, double liters, double price, String brand, boolean hasDiscount, double sugarPercentage) {
        super(id, liters, price, brand, hasDiscount);
        this.sugarPercentage = sugarPercentage;
    }

    public double getSugarPercentage() {
        return sugarPercentage;
    }

    public void setSugarPercentage(double sugarPercentage) {
        this.sugarPercentage = sugarPercentage;
    }

    @Override
    public String toString() {
        return "SugaryDrink [sugarPercentage=" + sugarPercentage + ", getId()=" + getId() + ", getLiters()="
                + getLiters() + ", getPrice()=" + getPrice() + ", getBrand()=" + getBrand() + ", hasDiscount()="
                + hasDiscount() + "]";
    }

}
