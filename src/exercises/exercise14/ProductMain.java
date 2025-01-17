package exercises.exercise14;

import java.util.List;

public class ProductMain {

    public static void main(String[] args) {
        System.out.println("\nExercise 14:\n");

        List<Product> products = List.of(
                new Product("Product 1", 10),
                new PerishableProduct("Perishable Product 1", 10, 1),
                new NonPerishableProduct("Non Perishable Product 1", 10, "Type 1"));

        for (Product product : products) {
            System.out.println(product.calculatePrice(5));
        }
    }

}
