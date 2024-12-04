package exercises.exercise8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3MullItOver {
    public static void main(String[] args) {
        try {
            System.out.println("\nExercise 8");
            System.out.println("Day 3: Mull It Over - Part 1\n");

            Path filePath = Paths.get("src/exercises/exercise8/mul-program.txt");
            List<String> programLines = Files.readAllLines(filePath);

            int totalMulInstructions = 0;

            for (String line : programLines) {
                Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    totalMulInstructions += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
                }
            }

            System.out.println("Total Mul Instructions: " + totalMulInstructions);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
