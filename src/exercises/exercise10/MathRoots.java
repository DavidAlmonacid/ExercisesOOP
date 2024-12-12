/**
 * Vamos a realizar una clase llamada Raices, donde representaremos los
 * valores de una ecuación de 2º grado.
 *
 * Tendremos los 3 coeficientes como atributos, llamémosles a, b y c.
 * Hay que insertar estos 3 valores para construir el objeto.
 *
 * Las operaciones que se podrán hacer son las siguientes:
 * - getDiscriminante(): devuelve el valor del discriminante (double), el
 * discriminante tiene la siguiente formula, (b^2)-4*a*c.
 * - tieneRaices(): devuelve un booleano indicando si tiene dos soluciones, para
 * que esto ocurra, el discriminante debe ser mayor o igual que 0.
 * - tieneRaiz(): devuelve un booleano indicando si tiene una única solución, para
 * que esto ocurra, el discriminante debe ser igual que 0.
 * - obtenerRaices(): imprime las 2 posibles soluciones.
 * - obtenerRaiz(): imprime única raíz, que será cuando solo tenga una solución posible.
 *
 * Formula ecuación 2º grado: (-b±√((b^2)-(4*a*c)))/(2*a)
 * Sólo varía el signo delante de -b
 */

package exercises.exercise10;

public class MathRoots {
    private double a;
    private double b;
    private double c;

    public MathRoots(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return Math.pow(b, 2) - (4 * a * c);
    }

    public boolean hasRoots() {
        return getDiscriminant() > 0;
    }

    public boolean hasRoot() {
        return getDiscriminant() == 0;
    }

    public String getRoots() {
        if (!hasRoots()) {
            return "This equation has no real roots.";
        }

        double root = Math.sqrt(getDiscriminant());
        double solution1 = (-b + root) / (2 * a);
        double solution2 = (-b - root) / (2 * a);

        return String.format("Solution 1: %.7f\nSolution 2: %.7f", solution1, solution2);
    }

    public String getRoot() {
        if (!hasRoot()) {
            return "This equation has no unique real root.";
        }

        double root = Math.sqrt(getDiscriminant());
        double solution = (-b + root) / (2 * a);

        return String.format("Solution: %.7f", solution);
    }
}
