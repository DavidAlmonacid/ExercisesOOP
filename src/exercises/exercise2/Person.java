/**
 * Haz una clase llamada Persona que siga las siguientes condiciones:
 * <p>
 * Sus atributos son: nombre, edad, DNI, sexo (MALE, FEMALE), peso y
 * altura. No queremos que se accedan directamente a ellos. Piensa que
 * modificador de acceso es el más adecuado, también su tipo. Si quieres añadir
 * algún atributo puedes hacerlo.
 * <p>
 * Por defecto, todos los atributos menos el DNI serán valores por defecto según
 * su tipo (0 números, cadena vacía para String, etc.). Sexo será hombre por
 * defecto, usa una constante para ello.
 * <p>
 * Se implementarán varios constructores:
 * Un constructor por defecto.
 * Un constructor con el nombre, edad y sexo, el resto por defecto.
 * Un constructor con todos los atributos como parámetro.
 * <p>
 * Los métodos que se implementarán son:
 * <p>
 * calcularIMC(): calculará si la persona está en su peso ideal (peso en
 * kg/(altura^2 en m)), si esta fórmula devuelve un valor menor que 18.5, la
 * función devuelve que está en bajo peso a través de un enum, si devuelve un
 * número entre 18.5 y 24.99 (incluidos), significa que esta por debajo de su
 * peso ideal la función devuelve que tiene un peso normal, si la fórmula arroja
 * un valor entre 25 y 29.99 significa que tiene sobrepeso, y si devuelve un
 * valor mayor que 30 significa que tiene obesidad. Te recomiendo que uses
 * constantes para devolver estos valores.
 * <p>
 * esMayorDeEdad(): indica si es mayor de edad, devuelve un booleano.
 * <p>
 * generaDNI(): genera un número aleatorio de 8 cifras, genera a partir de este
 * su número su letra correspondiente. Este método sera invocado cuando se
 * construya el objeto. Puedes dividir el método para que te sea más fácil. No
 * será visible al exterior.
 * <p>
 * Métodos set de cada parámetro, excepto de DNI.
 * <p>
 * toString(): devuelve toda la información del objeto.
 * <p>
 * Ahora, crea una clase ejecutable que haga lo siguiente:
 * <p>
 * Pide por teclado el nombre, la edad, sexo, peso y altura.
 * Crea 3 objetos de la clase anterior, el primer objeto obtendrá las anteriores
 * variables pedidas por teclado, el segundo objeto obtendrá todos los
 * anteriores menos el peso y la altura y el último por defecto, para este
 * último utiliza los métodos set para darle a los atributos un valor.
 * <p>
 * Para cada objeto, deberá comprobar si está en su peso ideal, tiene sobrepeso
 * o por debajo de su peso ideal con un mensaje. Indicar para cada objeto si es
 * mayor de edad.
 * <p>
 * Por último, mostrar la información de cada objeto.
 * Puedes usar métodos en la clase ejecutable, para que os sea más fácil.
 */

package exercises.exercise2;

import java.util.Random;

public class Person {
    private static final int ADULT_AGE = 18;

    private final String id;
    private String name;
    private byte age;
    private PersonGender gender;
    private float weight;
    private float height;

    public Person() {
        this.id = generateID();
        this.name = "";
        this.age = 0;
        this.gender = PersonGender.MALE;
        this.weight = 0;
        this.height = 0;
    }

    public Person(String name, byte age, PersonGender gender) {
        this.id = generateID();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = 0;
        this.height = 0;
    }

    public Person(String id, String name, byte age, PersonGender gender, float weight, float height) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }

        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }

        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
    }

    public PersonBMI calculateBMI() {
        if (height <= 0) {
            throw new IllegalArgumentException("Height can't be 0 or negative");
        }

        float formula = this.weight / (float) Math.pow(this.height, 2);

        if (Float.isNaN(formula) || Float.isInfinite(formula)) {
            throw new IllegalArgumentException("Invalid weight or height");
        }

        if (formula < 18.5) {
            return PersonBMI.UNDERWEIGHT;
        } else if (formula >= 18.5 && formula <= 24.99) {
            return PersonBMI.NORMAL;
        } else if (formula >= 25 && formula <= 29.99) {
            return PersonBMI.OVERWEIGHT;
        } else {
            return PersonBMI.OBESITY;
        }
    }

    public boolean isAdult() {
        return this.age >= ADULT_AGE;
    }

    private String generateID() {
        Random random = new Random();
        int randomNum = random.nextInt(90_000_000) + 10_000_000;
        return String.format("%08d", randomNum);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required and can't be empty");
        }

        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age can't be negative");
        }

        this.age = age;
    }

    public PersonGender getGender() {
        return gender;
    }

    public void setGender(PersonGender gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender cannot be null");
        }

        this.gender = gender;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight can't be negative");
        }

        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }

        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Person [id=%s, name=%s, age=%d, gender=%s, weight=%.2f, height=%.2f]", id, name, age, gender, weight, height);
    }
}
