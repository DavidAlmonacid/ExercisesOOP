/**
 * Las clases anteriores no son padre-hija, pero si tienen cosas en común,
 * por eso vamos a hacer una interfaz llamada Rentable con los siguientes métodos:
 * - rentar(): cambia el atributo prestado a true.
 * - devolver(): cambia el atributo prestado a: false.
 * - compareTo (Object a), compara las horas estimadas en los videojuegos,
 * y en las series el número de temporadas. Como parámetro recibirá un objeto,
 * no es necesario que implementes la interfaz Comparable. Recuerda el uso del
 * casting de objetos.
 */

package exercises.exercise7;

public interface Rentable {
    void rent();
    void returnItem();
    int compareTo(Object o);
}
