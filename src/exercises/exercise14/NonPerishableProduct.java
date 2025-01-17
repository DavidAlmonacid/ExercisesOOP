package exercises.exercise14;

public class NonPerishableProduct extends Product {

    private String type;

    public NonPerishableProduct(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "NonPerishableProduct [type=" + type + ", name=" + getName() + ", price=" + getPrice() + "]";
    }

}
