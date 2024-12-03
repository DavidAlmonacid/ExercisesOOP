/**
 * Ahora crea una clase ejecutable que realice lo siguiente:
 * Crea un array de Electrodomésticos de 6 posiciones.
 * Asigna a cada posición un objeto de las clases anteriores con los valores que
 * desees.
 * <p>
 * Ahora, recorre este array y ejecuta el método precioFinal().
 * Deberás mostrar el precio de cada clase, es decir, el precio de todas las
 * televisiones por un lado, el de las lavadoras por otro y la suma de los
 * Electrodomésticos (puedes crear objetos Electrodoméstico, pero recuerda que
 * Television y Lavadora también son electrodomésticos). Recuerda el uso
 * operador instanceof.
 * <p>
 * Por ejemplo, si tenemos un Electrodoméstico con un precio final de 300, una
 * lavadora de 200 y una televisión de 500, el resultado final será de 1000
 * (300+200+500) para electrodomésticos, 200 para lavadora y 500 para
 * televisión.
 */

package exercises.exercise5;

public class HomeApplianceMain {
    public static void main(String[] args) {
        System.out.println("\nExercise 5:\n");

        HomeAppliance[] homeAppliances = new HomeAppliance[6];
        homeAppliances[0] = new Television(50, true, 100, Color.BLACK, EnergyConsumption.A, 10);
        homeAppliances[1] = new WashingMachine(10, 200, Color.RED, EnergyConsumption.B, 20);
        homeAppliances[2] = new Television();
        homeAppliances[3] = new WashingMachine();
        homeAppliances[4] = new Television(250, 40);
        homeAppliances[5] = new WashingMachine(350, 50);

        int totalTelevisionsPrice = 0;
        int totalWashingMachinesPrice = 0;
        int totalHomeAppliancesPrice = 0;

        for (HomeAppliance homeAppliance : homeAppliances) {
            if (homeAppliance instanceof Television) {
                totalTelevisionsPrice += homeAppliance.getPrice();
                System.out.println("Television price: " + homeAppliance.getPrice());
            } else if (homeAppliance instanceof WashingMachine) {
                totalWashingMachinesPrice += homeAppliance.getPrice();
                System.out.println("WashingMachine price: " + homeAppliance.getPrice());
            }

            totalHomeAppliancesPrice += homeAppliance.getPrice();
        }

        System.out.println("\nTotal Televisions price: " + totalTelevisionsPrice);
        System.out.println("Total WashingMachines price: " + totalWashingMachinesPrice);
        System.out.println("Total HomeAppliances price: " + totalHomeAppliancesPrice);
    }
}
