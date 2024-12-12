package exercises.exercise10;

public class MathRootsMain {
    public static void main(String[] args) {
        System.out.println("\nExercise 10:\n");

        System.out.println("Equation 1");
        MathRoots quadraticEquation1 = new MathRoots(3, 4, 5);

        String solutions1 = quadraticEquation1.getRoots();
        System.out.println(solutions1);

        String solution1 = quadraticEquation1.getRoot();
        System.out.println(solution1);
        System.out.println();

        // -------------------------------------------------------

        System.out.println("Equation 2");
        MathRoots quadraticEquation2 = new MathRoots(1, -5, 6);

        String solutions2 = quadraticEquation2.getRoots();
        System.out.println(solutions2);

        String solution2 = quadraticEquation2.getRoot();
        System.out.println(solution2);
        System.out.println();

        // -------------------------------------------------------

        System.out.println("Equation 3");
        MathRoots quadraticEquation3 = new MathRoots(1, -6, 9);

        String solutions3 = quadraticEquation3.getRoots();
        System.out.println(solutions3);

        String solution3 = quadraticEquation3.getRoot();
        System.out.println(solution3);
    }
}
