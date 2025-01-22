/**
 * Se requiere realizar una agenda telefónica de contactos.
 *
 * Un contacto está definido por un nombre y un teléfono.
 * Un contacto es igual a otro cuando sus números telefónicos son iguales.
 *
 * Crea un menú con opciones por consola para probar todas estas
 * funcionalidades.
*/

package exercises.exercise16;

public class Contact {

    private String name;
    private Phone phoneNumber;

    public Contact(String name, Phone phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Phone phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Contact contact = (Contact) obj;

        boolean isSameCountryCode = phoneNumber.getCountryCode().equals(contact.phoneNumber.getCountryCode());
        boolean isSamePhoneNumber = phoneNumber.getNumber().equals(contact.phoneNumber.getNumber());

        return isSameCountryCode && isSamePhoneNumber;
    }

    @Override
    public String toString() {

        return "Contact: {\n" +
                "  name: " + name + '\n' +
                "  phone: " + phoneNumber + '\n' +
                '}';
    }

}
