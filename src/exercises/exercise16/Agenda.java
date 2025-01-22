/**
 * Una agenda de contactos está formada por un conjunto de contactos.
 *
 * Los métodos de la agenda serán los siguientes:
 * - añadirContacto(Contacto c): Añade un contacto a la agenda. Si ya existe un
 * contacto con exactamente el mismo número telefónico, se mostrará un mensaje
 * indicando que ya hay un contacto con ese mismo número.
 * - existeContacto(Phone phone): Indica si el contacto pasado existe o no.
 * - listarContactos(): Lista toda la agenda.
 * - buscaContacto(String nombre): Busca un contacto por su nombre y muestra su
 * información.
 * - buscaContacto(Phone phone): Busca un contacto por su número y muestra su
 * información.
 * - eliminarContacto(Phone phone): Elimina el contacto de la agenda, indica si se
 * ha eliminado o no por pantalla.
 */

package exercises.exercise16;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private static volatile Agenda instance;
    private List<Contact> contacts;

    private Agenda() {
        contacts = new ArrayList<>();
    }

    public static Agenda getInstance() {
        if (instance == null) {
            synchronized (Agenda.class) {
                if (instance == null) {
                    instance = new Agenda();
                }
            }
        }

        return instance;
    }

    public void addContact(Contact contact) {
        boolean exists = existPhoneContact(contact);

        if (!exists) {
            contacts.add(contact);
            return;
        }

        System.out.println("\nWarning!!!");
        System.out.println("A contact with that phone number already exists.");
        System.out.println("Please enter a different phone number.");
    }

    public void listAllContacts() {
        System.out.println("\nContact List\n");

        if (contacts.size() == 0) {
            System.out.println("There's no contacts here.");
            return;
        }

        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void findContact(String name) {
        var filteredContacts = contacts.stream()
                .filter(contact -> {
                    String contactName = contact.getName().toLowerCase();
                    return contactName.equals(name.toLowerCase());
                })
                .toList();

        searchAndDisplayContacts("Search by Name", filteredContacts);
    }

    public void findContact(Phone phone) {
        var filteredContacts = contacts.stream()
                .filter(contact -> contact.getPhoneNumber().equals(phone))
                .toList();

        searchAndDisplayContacts("Search by Phone", filteredContacts);
    }

    public void deleteContact(Phone phone) {
        var contactToDelete = contacts.stream()
                .filter(contact -> contact.getPhoneNumber().equals(phone))
                .findFirst();

        if (contactToDelete.isPresent()) {
            contacts.remove(contactToDelete.get());
            System.out.println("\nContact successfully deleted.");
        } else {
            System.out.println("\nNo contact found with that phone number.");
        }
    }

    private boolean existPhoneContact(Contact contact) {
        for (Contact c : contacts) {
            if (c.equals(contact)) {
                return true;
            }
        }

        return false;
    }

    private void listContacts(List<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    private void searchAndDisplayContacts(String message, List<Contact> filteredContacts) {
        System.out.println("\nContact List - " + message + "\n");

        if (filteredContacts.size() > 0) {
            listContacts(filteredContacts);
        } else {
            System.out.println("No matches were found!");
        }
    }

}
