/**
 * --- Part One ---
 * The unusual data (your puzzle input) consists of many reports, one report per
 * line. Each report is a list of numbers called levels that are separated by
 * spaces. For example:
 * 7 6 4 2 1
 * 1 2 7 8 9
 * 9 7 6 2 1
 * 1 3 2 4 5
 * 8 6 4 4 1
 * 1 3 6 7 9
 * <p>
 * This example data contains six reports each containing five levels.
 * <p>
 * The engineers are trying to figure out which reports are safe. The Red-Nosed
 * reactor safety systems can only tolerate levels that are either gradually
 * increasing or gradually decreasing. So, a report only counts as safe if both
 * of the following are true:
 * - The levels are either all increasing or all decreasing.
 * - Any two adjacent levels differ by at least one and at most three.
 * <p>
 * In the example above, the reports can be found safe or unsafe by checking
 * those rules:
 * 7 6 4 2 1: Safe because the levels are all decreasing by 1 or 2.
 * 1 2 7 8 9: Unsafe because 2 7 is an increase of 5.
 * 9 7 6 2 1: Unsafe because 6 2 is a decrease of 4.
 * 1 3 2 4 5: Unsafe because 1 3 is increasing but 3 2 is decreasing.
 * 8 6 4 4 1: Unsafe because 4 4 is neither an increase nor a decrease.
 * 1 3 6 7 9: Safe because the levels are all increasing by 1, 2, or 3.
 * <p>
 * So, in this example, 2 reports are safe.
 */

package exercises.exercise6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Day2RedNosedReportsMain {
    public static void main(String[] args) {
        try {
            System.out.println("\nExercise 6:\n");
            System.out.println("Day 2: Red-Nosed Reports - Part 1");

            String sep = File.separator;
            Path filePath = Paths.get(String.format("src%sexercises%sexercise6%sreports.txt", sep, sep, sep));
            List<String> lines = Files.readAllLines(filePath);

            int safeReportsCount = 0;

            for (String line : lines) {
                int[] levels = Arrays.stream(line.split("\\s")).mapToInt(Integer::parseInt).toArray();

                boolean isSafeAscending = true;
                boolean isSafeDescending = true;

                for (int i = 0; i < levels.length - 1; i++) {
                    int currentLevel = levels[i];
                    int nextLevel = levels[i + 1];

                    int difference = Math.abs(currentLevel - nextLevel);

                    if (difference <= 0 || difference > 3) {
                        isSafeAscending = false;
                        isSafeDescending = false;
                        break;
                    }

                    if (currentLevel >= nextLevel) {
                        isSafeAscending = false;
                        continue;
                    }

                    if (currentLevel <= nextLevel) {
                        isSafeDescending = false;
                    }
                }

                if (isSafeAscending || isSafeDescending) {
                    safeReportsCount++;
                }
            }

            System.out.println("Safe reports: " + safeReportsCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
