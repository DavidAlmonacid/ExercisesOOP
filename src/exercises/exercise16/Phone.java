package exercises.exercise16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {

    private String countryCode;
    private String number;

    public Phone(String countryCode, String number) {
        this.countryCode = countryCode;
        this.number = number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    private String formatPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("(\\d{3})(\\d{3})(\\d{4})");
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()) {
            return matcher.replaceAll("$1 $2 $3");
        }

        return phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        Phone phone = (Phone) obj;
        return countryCode.equals(phone.getCountryCode()) && number.equals(phone.getNumber());
    }

    @Override
    public String toString() {
        return String.format("+%s %s", countryCode, formatPhoneNumber(number));
    }

}
