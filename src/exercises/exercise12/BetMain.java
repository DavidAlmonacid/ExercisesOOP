package exercises.exercise12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BetMain {
    private static double accumulatedMoney = 0;

    public static void main(String[] args) {
        System.out.println("\nExercise 12:\n");

        Random random = new Random();
        List<Bet> bets = new ArrayList<>();

        Match result = new Match("Real Madrid", random.nextInt(5), "Barcelona", random.nextInt(5));
        System.out.println("Result: " + result);

        for (int i = 0; i < 100; i++) {

            int homeGoals = random.nextInt(5);
            int awayGoals = random.nextInt(5);
            int money = random.nextInt(2);

            Bet bet = new Bet(money, new Match("Real Madrid", homeGoals, "Barcelona", awayGoals));

            if (bet.getMoney() <= 0) {
                continue;
            }

            accumulatedMoney += bet.getMoney();

            bet.setResult(result);
            bet.setWinner(bet.getResult());

            bets.add(bet);
        }

        List<Bet> winners = new ArrayList<>();

        for (Bet bet : bets) {
            if (bet.getPrediction().getHomeGoals() == result.getHomeGoals()
                    && bet.getPrediction().getAwayGoals() == result.getAwayGoals()) {
                winners.add(bet);
            }
        }

        int totalWinners = winners.size();

        if (totalWinners > 0) {
            System.out.println("Total wins: " + totalWinners);
            System.out.println("Total accumulated money: " + accumulatedMoney);

            // Repartir el dinero entre los ganadores
            double moneyPerWinner = accumulatedMoney / totalWinners;

            winners.forEach(winner -> {
                winner.setMoney(moneyPerWinner);
                winner.setWins(winner.getWins() + 1);
            });
        }

        System.out.println("\nWinners:" + winners);
    }
}
