/**
 * Crearemos una clase Videojuego con las siguientes características:
 * Sus atributos son título, horas estimadas, entregado, género y compañía.
 * Por defecto, las horas estimadas serán de 10 horas y entregado: false.
 * El resto de atributos serán valores por defecto según el tipo del atributo.
 * <p>
 * Los constructores que se implementarán son:
 * Un constructor por defecto.
 * Un constructor con el título y horas estimadas. El resto por defecto.
 * Un constructor con todos los atributos, excepto de entregado.
 * <p>
 * Los métodos que se implementarán son:
 * Métodos get de todos los atributos, excepto de entregado.
 * Métodos set de todos los atributos, excepto de entregado.
 * Sobrescribe toString.
 */

package exercises.exercise7;

public class VideoGame implements Rentable {
    private final boolean DEFAULT_RENTED = false;
    @SuppressWarnings("unused")
    private final String rentedUserId;

    private String title;
    private String genre;
    private String company;
    private int estimatedHours;
    private boolean isRented;

    public VideoGame() {
        this.title = "";
        this.genre = "";
        this.company = "";
        this.estimatedHours = 10;
        this.isRented = DEFAULT_RENTED;
        this.rentedUserId = "";
    }

    public VideoGame(String title, int estimatedHours) {
        this.title = title;
        this.genre = "";
        this.company = "";
        this.estimatedHours = estimatedHours;
        this.isRented = DEFAULT_RENTED;
        this.rentedUserId = "";
    }

    public VideoGame(String title, String genre, String company, int estimatedHours) {
        this.title = title;
        this.genre = genre;
        this.company = company;
        this.estimatedHours = estimatedHours;
        this.isRented = DEFAULT_RENTED;
        this.rentedUserId = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(int estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    @Override
    public String toString() {
        return "VideoGame{" + "title='" + title + '\'' + ", genre='" + genre + '\'' + ", company='" + company + '\'' + ", estimatedHours=" + estimatedHours + '}';
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
        if (o instanceof VideoGame videoGame) {
            return Integer.compare(estimatedHours, videoGame.estimatedHours);
        }

        return 0;
    }
}
