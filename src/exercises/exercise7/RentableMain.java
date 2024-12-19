/**
 * Crea una aplicación ejecutable y realiza lo siguiente:
 * Crea dos arrays, uno de Series y otro de Videojuegos, de 5 posiciones cada
 * uno.
 * Genere un objeto en cada posición del array, con los valores que desee, puede
 * usar distintos constructores.
 * <p>
 * Renta algunos Videojuegos y Series con función entregar().
 * Cuenta cuántas Series y Videojuegos hay rentados y cuántas no.
 * Luego devuelve todos los Videojuegos y Series.
 * <p>
 * Por último, índica el Videojuego que tiene más horas estimadas y la serie con
 * más temporadas. Muéstralos en pantalla con toda su información
 * (usa la función toString()).
 */

package exercises.exercise7;

import java.util.List;

public class RentableMain {
    public static void main(String[] args) {
        System.out.println("\nExercise 7:\n");

        List<Serie> series = List.of(
                new Serie("Breaking Bad", 5, "Drama", "Vince Gilligan"),
                new Serie("The Mandalorian", 2, "Sci-Fi", "Jon Favreau"),
                new Serie("The Witcher", 1, "Fantasy", "Lauren Schmidt Hissrich"),
                new Serie("The Office", 9, "Comedy", "Greg Daniels"),
                new Serie("Stranger Things", 4, "Sci-Fi", "The Duffer Brothers")
        );

        List<VideoGame> videoGames = List.of(
                new VideoGame("The Legend of Zelda: Breath of the Wild", 100),
                new VideoGame("The Witcher 3: Wild Hunt", 50),
                new VideoGame("Red Dead Redemption 2", 60),
                new VideoGame("God of War", 40),
                new VideoGame("The Last of Us Part II", 30)
        );

        // Rent some series and video games
        series.get(0).rent();
        series.get(1).rent();
        series.get(2).rent();
        videoGames.get(2).rent();

        // Count rented and not rented series and video games
        int rentedSeries = 0;
        int notRentedSeries = 0;

        for (Serie serie : series) {
            if (serie.isRented()) {
                rentedSeries++;
            } else {
                notRentedSeries++;
            }
        }

        int rentedVideoGames = 0;
        int notRentedVideoGames = 0;

        for (VideoGame videoGame : videoGames) {
            if (videoGame.isRented()) {
                rentedVideoGames++;
            } else {
                notRentedVideoGames++;
            }
        }

        // Return all series and video games
        for (Serie serie : series) {
            serie.returnItem();
        }

        for (VideoGame videoGame : videoGames) {
            videoGame.returnItem();
        }

        System.out.println("Series rentadas: " + rentedSeries);
        System.out.println("Series no rentadas: " + notRentedSeries);

        System.out.println("\nVideojuegos rentados: " + rentedVideoGames);
        System.out.println("Videojuegos no rentados: " + notRentedVideoGames);

        // Find the video game with the most estimated hours compared to the rest
        VideoGame videoGameWithMostHours = videoGames.get(0);

        for (int i = 1; i < videoGames.size(); i++) {
            VideoGame videoGame = videoGames.get(i);

            if (videoGame.compareTo(videoGameWithMostHours) > 0) {
                videoGameWithMostHours = videoGame;
            }
        }

        // Find the serie with the most seasons compared to the rest
        Serie serieWithMostSeasons = series.get(0);

        for (int i = 1; i < series.size(); i++) {
            Serie serie = series.get(i);

            if (serie.compareTo(serieWithMostSeasons) > 0) {
                serieWithMostSeasons = serie;
            }
        }

        System.out.println("\nVideojuego con más horas estimadas: " + videoGameWithMostHours);
        System.out.println("Serie con más temporadas: " + serieWithMostSeasons);
    }
}
