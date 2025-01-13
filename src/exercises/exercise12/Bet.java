/**
 * Cada jugador de la porra, pone un 1 euro cada jornada y decide el resultado
 * de los partidos acordados.

 * Si nadie acierta en una jornada los resultados, el bote se acumula.

 * Los jugadores empiezan con un dinero inicial que será decidido por el
 * programador (ya sea como parámetro o como constante). Si el jugador no tiene
 * dinero en una jornada no podrá jugar la porra.

 * Los jugadores podrán repetir resultados, y se repartirá el bote entre los
 * jugadores que acierten los resultados.

 * Los resultados de la porra serán generados aleatoriamente, tanto los de
 * jugador como los de los partidos (no es necesario nombre, solo resultados).

 * Al final del programa, se deberá mostrar el dinero que tienen los jugadores y
 * el número de veces que han ganado.
 */

package exercises.exercise12;

public class Bet {
    private double money;
    private int wins;
    private Match prediction;
    private Match result;
    private boolean isWinner;

    public Bet(double money, Match prediction) {
        this.money = money;
        this.prediction = prediction;
        this.wins = 0;
    }

    // Getters
    public double getMoney() {
        return money;
    }

    public int getWins() {
        return wins;
    }

    public Match getPrediction() {
        return prediction;
    }

    public Match getResult() {
        return result;
    }

    public boolean isWinner() {
        return isWinner;
    }

    // Setters
    public void setMoney(double money) {
        this.money = money;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setPrediction(Match prediction) {
        this.prediction = prediction;
    }

    public void setResult(Match result) {
        this.result = result;
    }

    public void setWinner(Match result) {
        if (prediction.compareTo(result) == 0) {
            this.isWinner = true;
            return;
        }

        this.isWinner = false;
    }

    // toString
    @Override
    public String toString() {
        return "Bet{" + "money=" + money + ", wins=" + wins + ", prediction=" + prediction + ", result=" + result
                + ", isWinner=" + isWinner + '}';
    }
}

interface IMatch {
    int compareTo(Match match);
}

class Match implements IMatch {
    @SuppressWarnings("unused")
    private String homeTeam;
    private int homeGoals;
    @SuppressWarnings("unused")
    private String awayTeam;
    private int awayGoals;

    public Match(String homeTeam, int homeGoals, String awayTeam, int awayGoals) {
        this.homeTeam = homeTeam;
        this.homeGoals = homeGoals;
        this.awayTeam = awayTeam;
        this.awayGoals = awayGoals;
    }

    // Getters
    public int getHomeGoals() {
        return homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    // CompareTo
    @Override
    public int compareTo(Match match) {
        return Integer.compare(homeGoals, match.homeGoals) * Integer.compare(awayGoals, match.awayGoals);
    }

    // toString
    @Override
    public String toString() {
        return "Match{" + "homeGoals=" + homeGoals + ", awayGoals=" + awayGoals + '}';
    }
}
