/**
 * Crearemos una clase llamada Serie con las siguientes características:
 * Sus atributos son título, número de temporadas, entregado, género y creador.
 * Por defecto, el número de temporadas es de 3 temporadas y entregado: false.
 * El resto de atributos serán valores por defecto según el tipo del atributo.
 * <p>
 * Los constructores que se implementarán son:
 * Un constructor por defecto.
 * Un constructor con el título y creador. El resto por defecto.
 * Un constructor con todos los atributos, excepto de entregado.
 * <p>
 * Los métodos que se implementarán son:
 * Métodos get de todos los atributos, excepto de entregado.
 * Métodos set de todos los atributos, excepto de entregado.
 * Sobrescribe toString.
 */

package exercises.exercise7;

public class Serie implements Rentable {
    private final int DEFAULT_SEASONS = 3;
    private final boolean DEFAULT_RENTED = false;
    private final String rentedUserId;

    private String title;
    private int seasons;
    private String genre;
    private String director;
    private boolean isRented;

    public Serie() {
        this.title = "";
        this.seasons = DEFAULT_SEASONS;
        this.genre = "";
        this.director = "";
        this.isRented = DEFAULT_RENTED;
        this.rentedUserId = "";
    }

    public Serie(String title, String director) {
        this.title = title;
        this.seasons = DEFAULT_SEASONS;
        this.genre = "";
        this.director = director;
        this.isRented = DEFAULT_RENTED;
        this.rentedUserId = "";
    }

    public Serie(String title, int seasons, String genre, String director) {
        this.title = title;
        this.seasons = seasons;
        this.genre = genre;
        this.director = director;
        this.isRented = DEFAULT_RENTED;
        this.rentedUserId = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    @Override
    public String toString() {
        return "Serie {" + "director='" + director + '\'' + ", genre='" + genre + '\'' + ", seasons=" + seasons + ", title='" + title + '\'' + '}';
    }

    @Override
    public void rent() {
        isRented = true;
    }

    @Override
    public void returnItem() {
        isRented = false;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Serie serie) {
            return Integer.compare(seasons, serie.seasons);
        }

        return -1;
    }
}
