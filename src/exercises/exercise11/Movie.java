// De las películas nos interesa saber el título, duración, director y
// clasificación.

package exercises.exercise11;

public class Movie {
    private String title;
    private int duration;
    private String director;
    private String classification;

    public Movie(String title, int duration, String director, String classification) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.classification = classification;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getDirector() {
        return director;
    }

    public String getClassification() {
        return classification;
    }
}
