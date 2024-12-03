package exercises.exercise1;

public class AccountMain {
    public static void main(String[] args) {
        System.out.println("\nExercise 1:");

        Account account1 = new Account("John", 1000);
        Account account2 = new Account("Peter");

        account1.deposit(500);
        account1.withdraw(200);

        account2.deposit(-3000);
        account2.withdraw(200);

        System.out.println();
        System.out.println(account1);
        System.out.println(account2);
        System.out.println();
    }
}
