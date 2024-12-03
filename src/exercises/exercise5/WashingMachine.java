/**
 * Crearemos una subclase llamada Lavadora con las siguientes características:
 * Su atributo es carga, además de los atributos heredados.
 * Por defecto, la carga es de 5 kg. Usa una constante para ello.
 * <p>
 * Los constructores que se implementaran serán:
 * - Un constructor por defecto.
 * - Un constructor con el precio y peso. El resto por defecto.
 * - Un constructor con la carga y el resto de atributos heredados. Recuerda que
 * debes llamar al constructor de la clase padre.
 * <p>
 * Los métodos que se implementara serán:
 * - Método get de carga.
 * - precioFinal():, si tiene una carga mayor de 30 kg, aumentara el precio 50 €,
 * de lo contrario, no se incrementara el precio. Llama al método padre y añade el
 * código necesario. Recuerda que las condiciones que hemos visto en la clase
 * Electrodoméstico también deben afectar al precio.
 */

package exercises.exercise5;

public class WashingMachine extends HomeAppliance {
    private final short DEFAULT_LOAD = 5;

    private final int load;

    public int getLoad() {
        return load;
    }

    public WashingMachine() {
        super();
        this.load = DEFAULT_LOAD;
    }

    public WashingMachine(int price, float weight) {
        super(price, weight);
        this.load = DEFAULT_LOAD;
    }

    public WashingMachine(int load, int price, Color color, EnergyConsumption energyConsumption, float weight) {
        super(price, color, energyConsumption, weight);
        this.load = load;
    }

    @Override
    public void finalPrice() {
        super.finalPrice();

        if (load > 30) {
            price += 50;
        }
    }
}
