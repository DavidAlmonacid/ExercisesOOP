/**
 * Se requiere realizar un programa que permita gestionar un almacén de
 * bebidas. En un almacén se guardan un conjunto de bebidas.
 *
 * Estos productos son bebidas como agua mineral y bebidas azucaradas
 * (coca-cola, fanta, etc).
 *
 * De los productos nos interesa saber su identificador (cada uno tiene uno
 * distinto), cantidad de litros, precio y marca.
 *
 * - Si es agua mineral nos interesa saber también la denominación de origen.
 * - Si es una bebida azucarada queremos saber el porcentaje de azúcar que tiene.
 * - Si la bebida cuenta con alguna promoción, en caso afirmativo tendrá un
 * descuento del 10% en el precio.
 *
 * En el almacén iremos almacenado estas bebidas por estanterías (que son las
 * columnas de la matriz).
 *
 * Las operaciones del almacén son las siguientes:
 * - Calcular precio de todas las bebidas: Calcula el precio total de todos los
 * productos del almacén.
 * - Calcular el precio total de una marca de bebida: Dada una marca, calcular
 * el precio total de esas bebidas.
 * - Calcular el precio total de una estantería: Dada una estantería (columna),
 * calcular el precio total de esas bebidas.
 * - Agregar producto: Agrega un producto en la primera posición libre, si el
 * identificador está repetido en alguno de las bebidas, no se agregará esa
 * bebida.
 * - Eliminar un producto: Dado un ID, eliminar el producto del almacén.
 * - Mostrar información: Mostramos para cada bebida toda su información.
 *
 * Puedes usar un main para probar las funcionalidades (añade productos, calcula
 * precios, muestra información, etc).
 */

package exercises.exercise15;

import java.util.Arrays;
import java.util.List;

public class Store {

    private List<Drink[]> shelves;

    public Store(List<Drink[]> shelves) {
        this.shelves = shelves;
    }

    double calculatePriceOfAllDrinks() {
        return shelves
                .stream()
                .flatMap(shelf -> Arrays.stream(shelf))
                .filter(drink -> drink != null)
                .mapToDouble(Drink::getPrice)
                .sum();
    }

    double calculatePriceOfDrinksByBrand(String brand) {
        return shelves
                .stream()
                .flatMap(shelf -> Arrays.stream(shelf))
                .filter(drink -> drink != null && drink.getBrand().equals(brand))
                .mapToDouble(Drink::getPrice)
                .sum();
    }

    double calculatePriceOfDrinksByShelf(int shelf) {
        return Arrays
                .stream(shelves.get(shelf))
                .filter(drink -> drink != null)
                .mapToDouble(Drink::getPrice)
                .sum();
    }

    void addDrink(Drink drink) {
        // First, check if the drink ID is unique
        boolean isDuplicateId = shelves
                .stream()
                .flatMap(shelf -> Arrays.stream(shelf))
                .filter(d -> d != null)
                .anyMatch(d -> d.getId() == drink.getId());

        if (isDuplicateId) {
            System.out.println("Drink ID already exists.");
            return; // Don't add if ID already exists
        }

        // Find first empty slot
        for (Drink[] shelf : shelves) {
            for (int i = 0; i < shelf.length; i++) {
                if (shelf[i] == null) {
                    shelf[i] = drink;
                    return;
                }
            }
        }

        // If no empty slots found, create a new row
        Drink[] newRow = new Drink[shelves.get(0).length];
        newRow[0] = drink;
        shelves.add(newRow);
    }

    void deleteDrink(int id) {
        for (Drink[] shelf : shelves) {
            for (int i = 0; i < shelf.length; i++) {
                if (shelf[i] != null && shelf[i].getId() == id) {
                    shelf[i] = null;
                    return;
                }
            }
        }
    }

    void printShelves() {
        for (Drink[] drinks : shelves) {
            for (Drink drink : drinks) {
                System.out.println(drink);
            }
        }
    }

}
