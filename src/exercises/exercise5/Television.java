/**
 * Crearemos una subclase llamada Television con las siguientes características:
 * Sus atributos son resolución (en pulgadas) y sintonizador TDT (booleano),
 * además de los atributos heredados.
 * Por defecto, la resolución será de 20 pulgadas y el sintonizador será, false.
 * <p>
 * Los constructores que se implementaran serán:
 * - Un constructor por defecto.
 * - Un constructor con el precio y peso. El resto por defecto.
 * - Un constructor con la resolución, sintonizador TDT y el resto de atributos
 * heredados. Recuerda que debes llamar al constructor de la clase padre.
 * <p>
 * Los métodos que se implementara serán:
 * - getter de resolución y sintonizador TDT.
 * - precioFinal(): Si tiene una resolución mayor de 40 pulgadas se incrementará
 * el precio un 30%, si tiene un sintonizador TDT incorporado aumentará 50.
 * Recuerda que las condiciones que hemos visto en la clase Electrodoméstico
 * también deben afectar al precio.
 */

package exercises.exercise5;

public class Television extends HomeAppliance {
    private final int DEFAULT_RESOLUTION = 20;
    private final boolean DEFAULT_DTT = false;

    private final int resolution;

    public int getResolution() {
        return resolution;
    }

    private final boolean dtt;

    public boolean isDtt() {
        return dtt;
    }

    public Television() {
        super();
        this.resolution = DEFAULT_RESOLUTION;
        this.dtt = DEFAULT_DTT;
    }

    public Television(int price, float weight) {
        super(price, weight);
        this.resolution = DEFAULT_RESOLUTION;
        this.dtt = DEFAULT_DTT;
    }

    public Television(int resolution, boolean dtt, int price, Color color, EnergyConsumption energyConsumption, float weight) {
        super(price, color, energyConsumption, weight);
        this.resolution = resolution;
        this.dtt = dtt;
    }

    @Override
    public void finalPrice() {
        super.finalPrice();

        if (dtt) {
            price += 50;
        }

        if (resolution > 40) {
            price += (int) (price * 0.3);
        }
    }
}
