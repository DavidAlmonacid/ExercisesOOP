package exercises.exercise16;

public class ContactBuilder {

    private String name;
    private Phone phoneNumber;

    public ContactBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ContactBuilder setPhoneNumber(String countryCode, String number) {
        this.phoneNumber = new Phone(countryCode, number);
        return this;
    }

    public Contact build() {
        return new Contact(name, phoneNumber);
    }

}
