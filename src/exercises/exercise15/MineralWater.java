package exercises.exercise15;

public class MineralWater extends Drink {

    private String protectedDesignationOfOrigin;

    public MineralWater(int id, double liters, double price, String brand, String protectedDesignationOfOrigin) {
        super(id, liters, price, brand);
        this.protectedDesignationOfOrigin = protectedDesignationOfOrigin;
    }

    public MineralWater(int id, double liters, double price, String brand, boolean hasDiscount,
            String protectedDesignationOfOrigin) {
        super(id, liters, price, brand, hasDiscount);
        this.protectedDesignationOfOrigin = protectedDesignationOfOrigin;
    }

    public String getProtectedDesignationOfOrigin() {
        return protectedDesignationOfOrigin;
    }

    public void setProtectedDesignationOfOrigin(String protectedDesignationOfOrigin) {
        this.protectedDesignationOfOrigin = protectedDesignationOfOrigin;
    }

    @Override
    public String toString() {
        return "MineralWater [protectedDesignationOfOrigin=" + protectedDesignationOfOrigin + ", getId()=" + getId()
                + ", getLiters()=" + getLiters() + ", getPrice()=" + getPrice() + ", getBrand()=" + getBrand()
                + ", hasDiscount()=" + hasDiscount() + "]";
    }

}
