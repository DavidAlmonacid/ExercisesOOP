// Realizaremos una pequeña simulación, en el que generaremos muchos
// espectadores y los sentaremos aleatoriamente (no podemos donde ya esté
// ocupado).
//
// Únicamente se podrá sentar si hay espacio libre y si tiene edad para ver la
// película, en caso de que el asiento este ocupado le buscaremos uno libre.

package exercises.exercise11;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovieTheaterMain {
    public static void main(String[] args) {
        List<Movie> movies = List.of(
        new Movie("The Shawshank Redemption", 142, "Frank Darabont", "R"),
        new Movie("The Godfather", 175, "Francis Ford Coppola", "R"),
        new Movie("The Dark Knight", 152, "Christopher Nolan", "PG-13"),
        new Movie("12 Angry Men", 96, "Sidney Lumet", "PG"),
        new Movie("Schindler's List", 195, "Steven Spielberg", "PG-13"));

        MovieTheater movieTheater = new MovieTheater(movies.get(4).getTitle(), 12_800);

        Set<String> busySeats = new HashSet<>();
        int seatRows = movieTheater.getROWS();
        int seatCols = movieTheater.getCOLS();

        while (busySeats.size() < 20) {
            String randomSeat = generateRandomSeat(seatRows, seatCols);

            if (busySeats.contains(randomSeat)) {
                continue;
            }

            movieTheater.setSeatUnavailable(randomSeat, false);
            busySeats.add(randomSeat);
        }

        System.out.println("Busy Seats: " + busySeats + '\n');
        System.out.println(movieTheater);
    }

    private static String generateRandomSeat(int rows, int cols) {
        int initialLetter = 'A';
        int randomLetter = getRandomRange(initialLetter, initialLetter + cols - 1);
        int randomNum = getRandomRange(1, rows);

        return String.format("%c%d", randomLetter, randomNum);
    }

    private static int getRandomRange(int min, int max) {
        return (int) Math.floor(((max + 1 - min) * Math.random()) + min);
    }
}
