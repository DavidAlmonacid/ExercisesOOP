package exercises.exercise2;

import java.util.Scanner;

public class PersonMain {
    public static void main(String[] args) {
        System.out.println("\nExercise 2:");

        // Create scanner for user input
        Scanner scanner = new Scanner(System.in);

        // First person - all data from keyboard
        System.out.println("Enter data for first person:");
        Person person1 = createPersonFromInput(scanner);

        // Second person - name, age and gender from keyboard
        System.out.println("\nEnter data for second person (without weight/height):");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        byte age = Byte.parseByte(scanner.nextLine());
        System.out.print("Gender (M/F): ");
        PersonGender gender = scanner.nextLine().toUpperCase().startsWith("F") ? PersonGender.FEMALE : PersonGender.MALE;
        Person person2 = new Person(name, age, gender);
        person2.setWeight(80.5f);
        person2.setHeight(1.85f);

        // Third person - default constructor and setters
        Person person3 = new Person();
        person3.setName("John Doe");
        person3.setAge((byte) 25);
        person3.setGender(PersonGender.MALE);
        person3.setWeight(70.5f);
        person3.setHeight(1.75f);

        // Show results for each person
        System.out.println("\nResults:");
        showPersonInfo(person1, 1);
        showPersonInfo(person2, 2);
        showPersonInfo(person3, 3);

        // Close scanner
        scanner.close();
    }

    private static Person createPersonFromInput(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        byte age = Byte.parseByte(scanner.nextLine());

        System.out.print("Gender (M/F): ");
        PersonGender gender = scanner.nextLine().toUpperCase().startsWith("F") ? PersonGender.FEMALE : PersonGender.MALE;

        System.out.print("Weight (kg): ");
        float weight = Float.parseFloat(scanner.nextLine());

        System.out.print("Height (m): ");
        float height = Float.parseFloat(scanner.nextLine());

        return new Person(String.format("%08d", (int) (Math.random() * 100000000)), name, age, gender, weight, height);
    }

    private static void showPersonInfo(Person person, int number) {
        System.out.println("\nPerson " + number + ":");
        System.out.println(person);

        try {
            PersonBMI bmi = person.calculateBMI();
            System.out.println("BMI Status: " + bmi);
        } catch (IllegalArgumentException e) {
            System.out.println("BMI Status: Cannot calculate (missing weight/height)");
        }

        System.out.println("Is adult: " + person.isAdult());
    }
}
