/**
 * Crear una clase Libro que contenga los siguientes atributos:
 * – ISBN
 * – Título
 * – Autor
 * – Número de páginas
 * <p>
 * Crear sus respectivos métodos get y set correspondientes para cada atributo.
 * Generar toString() para mostrar la información relativa al libro con el siguiente
 * formato: «El libro con ISBN <ISBN>, creado por <AUTHOR> tiene <PAGES> páginas»
 */

package exercises.exercise9;

public class Book {
    private String title;
    private String author;
    private int pages;
    private String ISBN;

    public Book(String title, String author, int pages, String ISBN) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.ISBN = ISBN;
    }

    public int compareTo(Object o) {
        if (o instanceof Book otherBook) {
            return Integer.compare(this.pages, otherBook.pages);
        }

        return 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "El libro con ISBN " + ISBN +
                ", creado por " + author +
                " tiene " + pages +
                " páginas.";
    }
}
