package exercises.exercise15;

import java.util.ArrayList;
import java.util.List;

public class StoreMain {

    public static void main(String[] args) {
        System.out.println("\nExercise 15:\n");

        final int numberOfShelves = 5;
        final int numberOfDrinksPerShelf = 5;
        int id = 1;

        List<Drink[]> drinksInShelves = new ArrayList<>();

        for (int i = 0; i < numberOfDrinksPerShelf; i++) {
            Drink[] drinks = new Drink[numberOfShelves];

            for (int j = 0; j < numberOfShelves; j++) {
                if (j % 2 == 0) {
                    drinks[j] = new MineralWater(id, 0.5, 15, "Evian", true, "France");
                } else {
                    drinks[j] = new SugaryDrink(id, 1.25, 5, "Coca-Cola", 10);
                }

                id++;
            }

            drinksInShelves.add(drinks);
        }

        Store store = new Store(drinksInShelves);

        store.addDrink(new MineralWater(id, 0.5, 20, "Vittel", "France"));
        id++;

        store.addDrink(new SugaryDrink(id, 1.25, 4, "Pepsi", 12));
        id++;

        store.addDrink(new MineralWater(id, 0.5, 15, "Evian", "France"));
        id++;

        store.deleteDrink(id - 1);

        System.out.println("* Total price");
        System.out.println("Price of all drinks: " + store.calculatePriceOfAllDrinks());

        System.out.println("\n* Prices by brand");
        System.out.println("Price of Coca-Cola drinks: " + store.calculatePriceOfDrinksByBrand("Coca-Cola"));
        System.out.println("Price of Pepsi drinks: " + store.calculatePriceOfDrinksByBrand("Pepsi"));
        System.out.println("Price of Evian drinks: " + store.calculatePriceOfDrinksByBrand("Evian"));
        System.out.println("Price of Vittel drinks: " + store.calculatePriceOfDrinksByBrand("Vittel"));

        System.out.println("\n* Total price in shelf 2");
        System.out.println("Price of drinks in shelf 2: " + store.calculatePriceOfDrinksByShelf(2));

        System.out.println("\n* Print drinks:");
        store.printShelves();
    }

}
