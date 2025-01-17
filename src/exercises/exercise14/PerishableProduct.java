package exercises.exercise14;

public class PerishableProduct extends Product {

    private int daysToExpire;

    public PerishableProduct(String name, double price, int daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    @Override
    public double calculatePrice(int quantity) {
        double price = getPrice();

        double newPrice = switch (daysToExpire) {
            case 1 -> price / 4;
            case 2 -> price / 3;
            case 3 -> price / 2;
            default -> 0;
        };

        return quantity * newPrice;
    }

    @Override
    public String toString() {
        return "PerishableProduct [daysToExpire=" + daysToExpire + "]";
    }

}
