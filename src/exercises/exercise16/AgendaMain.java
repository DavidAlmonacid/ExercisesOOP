package exercises.exercise16;

import java.util.Scanner;

public class AgendaMain {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Agenda agenda = Agenda.getInstance();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            printMenu();
            int option = getOption();

            switch (option) {
                case 1 -> addContact();
                case 2 -> searchContactByName();
                case 3 -> searchContactByPhone();
                case 4 -> listContacts();
                case 5 -> deleteContact();
                case 6 -> exit = true;
                default -> System.out.println("Invalid option!");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== Contact Agenda Menu ===");
        System.out.println("1. Add Contact");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Phone");
        System.out.println("4. List All Contacts");
        System.out.println("5. Delete Contact");
        System.out.println("6. Exit");
        System.out.print("\nChoose an option: ");
    }

    private static int getOption() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter country code: ");
        String countryCode = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String number = scanner.nextLine();

        Contact contact = new ContactBuilder()
                .setName(name)
                .setPhoneNumber(countryCode, number)
                .build();

        agenda.addContact(contact);
    }

    private static void searchContactByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        agenda.findContact(name);
    }

    private static void searchContactByPhone() {
        System.out.print("Enter country code: ");
        String countryCode = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String number = scanner.nextLine();

        Phone phone = new Phone(countryCode, number);
        agenda.findContact(phone);
    }

    private static void listContacts() {
        agenda.listAllContacts();
    }

    private static void deleteContact() {
        System.out.print("Enter country code: ");
        String countryCode = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String number = scanner.nextLine();

        Phone phone = new Phone(countryCode, number);
        agenda.deleteContact(phone);
    }

}
