/**
 * Nos piden realizar la gestión de una serie de productos.
 *
 * 1. Los productos tienen los siguientes atributos:
 * Nombre
 * Precio
 *
 * 2. Tenemos dos tipos de productos:
 * - Perecedero: tiene un atributo llamado días a caducar
 * - No perecedero: tiene un atributo llamado tipo
 *
 * 3. Crea sus constructores, getters, setters y toString.
 *
 * 4. Tendremos una función llamada calcular, que según cada clase hará una cosa u
 * otra, a esta función le pasaremos como parámetro la cantidad de productos.
 *
 * 4.1. En Producto, simplemente seria multiplicar el precio por la cantidad de
 * productos pasados.
 *
 * 4.2. En Perecedero, aparte de lo que hace producto, el precio se reducirá según
 * los días a caducar:
 * - Si caduca en 3 días, se reducirá a la mitad del precio original.
 * - Si caduca en 2 días, se reducirá a 1/3 del precio original.
 * - Si caduca en 1 día, se reducirá a 1/4 del precio original.
 *
 * 4.3. En NoPerecedero, hace lo mismo que en producto.
 *
 * 5. Crea una clase ejecutable y crea un array de productos y muestra el precio
 * total de vender 5 productos de cada uno. Crea tú mismo los elementos del
 * array.
 */

package exercises.exercise14;

public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double calculatePrice(int quantity) {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + "]";
    }

}
