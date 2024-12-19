package exercises.exercise3;

public class PasswordMain {
    public static void main(String[] args) {
        System.out.println("\nExercise 3:\n");

        Password password1 = new Password();
        Password password2 = new Password(12);
        Password password3 = new Password();
        password3.setLength(18);
        Password password4 = new Password(23);

        System.out.println("Password 1: " + password1.getPassword());
        System.out.println("Password 2: " + password2.getPassword());
        System.out.println("Password 3: " + password3.getPassword());
        System.out.println("Password 4: " + password4.getPassword());
        System.out.println();
    }
}
