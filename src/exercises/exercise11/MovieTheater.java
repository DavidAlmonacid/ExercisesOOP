// Programa sobre un Cine (solo de una sala). Tiene un conjunto de asientos (8
// filas por 9 columnas, por ejemplo).
//
// Del cine nos interesa conocer la película que se está reproduciendo y el
// precio de la entrada al cine.
//
// Los asientos son etiquetados por una letra (columna) y un número (fila), la
// fila 1 empieza al final de la matriz como se muestra en la siguiente tabla.
// Se debe saber si está ocupado el asiento o no.
//
// A8 B8 C8 D8 E8 F8 G8 H8 I8
// A7 B7 C7 D7 E7 F7 G7 H7 I7
// A6 B6 C6 D6 E6 F6 G6 H6 I6
// A5 B5 C5 D5 E5 F5 G5 H5 I5
// A4 B4 C4 D4 E4 F4 G4 H4 I4
// A3 B3 C3 D3 E3 F3 G3 H3 I3
// A2 B2 C2 D2 E2 F2 G2 H2 I2
// A1 B1 C1 D1 E1 F1 G1 H1 I1

package exercises.exercise11;

import java.util.ArrayList;
import java.util.List;

public class MovieTheater {
    private final int ROWS = 8;
    private final int COLS = 9;

    private List<List<Seat>> seats;
    private String playingNow;
    private int ticketPrice;

    public MovieTheater(String playingNow, int ticketPrice) {
        this.seats = generateSeats(ROWS, COLS);
        this.playingNow = playingNow;
        this.ticketPrice = ticketPrice;
    }

    public String getPlayingNow() {
        return playingNow;
    }

    public void setPlayingNow(String playingNow) {
        this.playingNow = playingNow;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getROWS() {
        return ROWS;
    }

    public int getCOLS() {
        return COLS;
    }

    private List<List<Seat>> generateSeats(int rows, int columns) {
        List<List<Seat>> seats = new ArrayList<>();

        for (int i = rows; i > 0; i--) {
            List<Seat> row = new ArrayList<>();

            for (char letter = 'A'; letter < 'A' + columns; letter++) {
                String id = String.format("%c%d", letter, i);
                Seat seat = new Seat(id);
                row.add(seat);
            }

            seats.add(row);
        }

        return seats;
    }

    public void setSeatUnavailable(String seatId, boolean isAvailable) {
        for (List<Seat> row : seats) {
            for (Seat seat : row) {
                if (seat.getId().equals(seatId)) {
                    seat.setAvailable(isAvailable);
                    return;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Add playing now and ticket price info
        sb.append("Playing now: ").append(playingNow).append("\n");
        sb.append("Ticket price: $").append(ticketPrice).append("\n\n");
        sb.append("Available seats:\n");

        // Iterate over the seats to create the seating chart
        for (List<Seat> row : seats) {
            for (Seat seat : row) {
                if (seat.isAvailable()) {
                    sb.append(seat.getId()).append(" "); // Show seat ID if available
                } else {
                    sb.append("   "); // Double space if not available
                }
            }
            sb.append("\n"); // New line after each row
        }

        return sb.toString();
    }
}

class Seat {
    private String id;
    private boolean isAvailable;

    public Seat(String id) {
        this.id = id;
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
