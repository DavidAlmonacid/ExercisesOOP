/**
 * Haz una clase llamada Password que siga las siguientes condiciones:
 * <p>
 * Que tenga los atributos longitud y contraseña. Por defecto, la longitud será de 12.
 * <p>
 * Los constructores serán los siguientes:
 * Un constructor por defecto.
 * Un constructor con la longitud que nosotros le pasemos. Generará una contraseña aleatoria con esa longitud.
 * <p>
 * Los métodos que implementa serán:
 * generarPassword(): Genera la contraseña del objeto con la longitud que tenga.
 * Método get para contraseña y longitud.
 * Método set para longitud.
 */

package exercises.exercise3;

public class Password {

    private int length;
    private String password;

    public Password() {
        this.length = 12;
        this.password = generatePassword();
    }

    public Password(int length) {
        if (length < 12) {
            throw new IllegalArgumentException("Length must be greater than or equal to 12");
        }

        this.length = length;
        this.password = generatePassword();
    }

    private String generatePassword() {
        final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String NUMBERS = "0123456789";

        String[] sortedPasswordChars = new String[length];

        for (int i = 0; i < length; i++) {
            int randomIndex;
            String currentChar;

            if (i < length / 2) {
                randomIndex = (int) (Math.random() * NUMBERS.length());
                currentChar = Character.toString(NUMBERS.charAt(randomIndex));

                sortedPasswordChars[i] = currentChar;
            } else {
                randomIndex = (int) (Math.random() * CHARS.length());
                currentChar = Character.toString(CHARS.charAt(randomIndex));

                sortedPasswordChars[i] = (i % 2 == 0) ? currentChar.toLowerCase() : currentChar;
            }
        }

        return Shuffle(sortedPasswordChars);
    }

    private String Shuffle(String[] sortedPasswordChars) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sortedPasswordChars.length; i++) {
            int randomIndex = (int) (Math.random() * sortedPasswordChars.length);

            String temp = sortedPasswordChars[i];
            sortedPasswordChars[i] = sortedPasswordChars[randomIndex];
            sortedPasswordChars[randomIndex] = temp;
        }

        for (String character : sortedPasswordChars) {
            sb.append(character);
        }

        return sb.toString();
    }

    // Getters
    public int getLength() {
        return length;
    }

    // Setters
    public void setLength(int length) {
        this.length = length;
        this.password = generatePassword();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
