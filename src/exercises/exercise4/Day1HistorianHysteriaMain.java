/**
 * --- Part One ---
 * Throughout the Chief's office, the historically significant locations are listed not by name but by a unique number called the location ID. To make sure they don't miss anything, The Historians split into two groups, each searching the office and trying to create their own complete list of location IDs.
 *
 * There's just one problem: by holding the two lists up side by side (your puzzle input), it quickly becomes clear that the lists aren't very similar. Maybe you can help The Historians reconcile their lists?
 *
 * For example:
 * 3   4
 * 4   3
 * 2   5
 * 1   3
 * 3   9
 * 3   3
 *
 * Maybe the lists are only off by a small amount! To find out, pair up the numbers and measure how far apart they are. Pair up the smallest number in the left list with the smallest number in the right list, then the second-smallest left number with the second-smallest right number, and so on.
 *
 * In the example list above, the pairs and distances would be as follows:
 * - The smallest number in the left list is 1, and the smallest number in the right list is 3. The distance between them is 2.
 * - The second-smallest number in the left list is 2, and the second-smallest number in the right list is another 3. The distance between them is 1.
 * - The third-smallest number in both lists is 3, so the distance between them is 0.
 * - The next numbers to pair up are 3 and 4, a distance of 1.
 * - The fifth-smallest numbers in each list are 3 and 5, a distance of 2.
 * - Finally, the largest number in the left list is 4, while the largest number in the right list is 9; these are a distance 5 apart.
 * - To find the total distance between the left list and the right list, add up the distances between all of the pairs you found. In the example above, this is 2 + 1 + 0 + 1 + 2 + 5, a total distance of 11!
 * 
 * --- Part Two ---
 * This time, you'll need to figure out exactly how often each number from the left list appears in the right list. Calculate a total similarity score by adding up each number in the left list after multiplying it by the number of times that number appears in the right list.
 * 
 * Here are the same example lists again:
 * 3   4
 * 4   3
 * 2   5
 * 1   3
 * 3   9
 * 3   3
 * 
 * For these example lists, here is the process of finding the similarity score:
 * - The first number in the left list is 3. It appears in the right list three times, so the similarity score increases by 3 * 3 = 9.
 * - The second number in the left list is 4. It appears in the right list once, so the similarity score increases by 4 * 1 = 4.
 * - The third number in the left list is 2. It does not appear in the right list, so the similarity score does not increase (2 * 0 = 0).
 * - The fourth number, 1, also does not appear in the right list.
 * - The fifth number, 3, appears in the right list three times; the similarity score increases by 9.
 * - The last number, 3, appears in the right list three times; the similarity score again increases by 9.
 * 
 * So, for these example lists, the similarity score at the end of this process is 31 (9 + 4 + 0 + 0 + 9 + 9).
 */

package exercises.exercise4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day1HistorianHysteriaMain {
    public static void main(String[] args) {
        try {
            System.out.println("Day 1: Historian Hysteria - Part 1");

            // Get the path to the file in the same package
            Path filePath = Paths.get(Day1HistorianHysteriaMain.class.getResource("distance-log.txt").toURI());
            List<String> lines = Files.readAllLines(filePath);

            List<Integer> leftColumn = new ArrayList<>();
            List<Integer> rightColumn = new ArrayList<>();

            for (String line : lines) {
                String[] parts = line.split("\\s{3,}");
                leftColumn.add(Integer.parseInt(parts[0]));
                rightColumn.add(Integer.parseInt(parts[1]));
            }

            // Sort the columns in ascending order
            leftColumn.sort(Integer::compareTo);
            rightColumn.sort(Integer::compareTo);

            int totalDistance = 0;

            for (int i = 0; i < leftColumn.size(); i++) {
                totalDistance += Math.abs(leftColumn.get(i) - rightColumn.get(i));
            }

            System.out.println("Total distance: " + totalDistance);

            // ----------------------------------------------------

            System.out.println("\nDay 1: Historian Hysteria - Part 2");

            int similarityScore = 0;

            for (Integer integer : leftColumn) {
                similarityScore += integer * rightColumn.stream().filter(i -> i.equals(integer)).count();
            }

            System.out.println("Similarity score: " + similarityScore);
        } catch (IOException | URISyntaxException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
