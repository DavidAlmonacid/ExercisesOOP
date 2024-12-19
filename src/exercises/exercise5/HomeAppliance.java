/**
 * Crearemos una superclase llamada Electrodoméstico con las siguientes características:
 * Sus atributos son precio base, color, consumo energético (letras entre A y F)
 * y peso. Indica que se podrán heredar.
 * <p>
 * Los colores disponibles son blanco, negro, rojo, azul y gris. No importa si
 * el nombre está en mayúsculas o en minúsculas.
 * <p>
 * Por defecto, el color será blanco, el consumo energético será F, el precioBase
 * es de 100 € y el peso de 5 kg.
 * <p>
 * Los constructores que se implementaran serán:
 * Un constructor por defecto.
 * Un constructor con el precio y peso. El resto por defecto.
 * Un constructor con todos los atributos.
 * <p>
 * Los métodos que implementara serán:
 * - Métodos get de todos los atributos.
 * - precioFinal(): El precio aumentará según su precio y tamaño.
 * Esta es la lista de precios:
 * Letra Precio
 * A 100 €
 * B 80 €
 * C 60 €
 * D 50 €
 * E 30 €
 * F 10 €
 * Tamaño Precio
 * Entre 0 y 19 kg 10 €
 * Entre 20 y 49 kg 50 €
 * Entre 50 y 79 kg 80 €
 * Mayor que 80 kg 100 €
 */

package exercises.exercise5;

public class HomeAppliance {
    protected int price;
    protected Color color;
    protected EnergyConsumption energyConsumption;
    protected float weight;

    public HomeAppliance() {
        this.price = 100;
        this.color = Color.WHITE;
        this.energyConsumption = EnergyConsumption.F;
        this.weight = 5;
    }

    public HomeAppliance(int price, float weight) {
        this.price = price;
        this.color = Color.WHITE;
        this.energyConsumption = EnergyConsumption.F;
        this.weight = weight;
    }

    public HomeAppliance(int price, Color color, EnergyConsumption energyConsumption, float weight) {
        this.price = price;
        this.color = color;
        this.energyConsumption = energyConsumption;
        this.weight = weight;
    }

    // Getters
    public int getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }

    public EnergyConsumption getEnergyConsumption() {
        return energyConsumption;
    }

    public float getWeight() {
        return weight;
    }

    // Methods
    public void finalPrice() {
        price += switch (energyConsumption) {
            case A -> 100;
            case B -> 80;
            case C -> 60;
            case D -> 50;
            case E -> 30;
            default -> 10;
        };

        if (weight >= 0 && weight < 20) {
            price += 10;
        } else if (weight >= 20 && weight < 50) {
            price += 50;
        } else if (weight >= 50 && weight < 80) {
            price += 80;
        } else {
            price += 100;
        }
    }
}
