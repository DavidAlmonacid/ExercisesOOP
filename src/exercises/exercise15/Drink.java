package exercises.exercise15;

public class Drink {

    private int id;
    private double liters;
    private double price;
    private String brand;
    private boolean hasDiscount;

    public Drink(int id, double liters, double price, String brand) {
        this.id = id;
        this.liters = liters;
        this.price = price;
        this.brand = brand;
        this.hasDiscount = false;
    }

    public Drink(int id, double liters, double price, String brand, boolean hasDiscount) {
        this.id = id;
        this.liters = liters;
        this.price = hasDiscount ? price * 0.9 : price;
        this.brand = brand;
        this.hasDiscount = hasDiscount;
    }

    public int getId() {
        return id;
    }

    public double getLiters() {
        return liters;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public boolean hasDiscount() {
        return hasDiscount;
    }

    @Override
    public String toString() {
        return "Drink [id=" + id + ", liters=" + liters + ", price=" + price + ", brand=" + brand + ", hasDiscount="
                + hasDiscount + "]";
    }

}
