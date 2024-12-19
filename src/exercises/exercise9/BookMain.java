/**
 * En el fichero main, crea 2 objetos Libro (los valores que se quieran) y
 * muéstralos por pantalla.
 * Por último, indica cuál de los 2 tiene más páginas.
 */

package exercises.exercise9;

public class BookMain {
    public static void main(String[] args) {
        System.out.println("\nExercise 9:\n");

        Book book1 = new Book("El Quijote", "Miguel de Cervantes", 200, "1234567890");
        Book book2 = new Book("El Señor de los Anillos", "J.R.R. Tolkien", 500, "0987654321");

        System.out.println(book1);
        System.out.println(book2);
        System.out.println();

        switch (book1.compareTo(book2)) {
            case 1 -> System.out.println("El libro " +
                    '\"' + book1.getTitle() + '\"' +
                    ", tiene más páginas que el libro " +
                    '\"' + book2.getTitle() + '\"' +
                    '.');
            case -1 -> System.out.println("El libro " +
                    '\"' + book2.getTitle() + '\"' +
                    ", tiene más páginas que el libro " +
                    '\"' + book1.getTitle() + '\"' +
                    '.');
            default -> System.out.println("Ambos libros tienen el mismo número de páginas.");
        }
    }
}
