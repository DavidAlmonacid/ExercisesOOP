package exercises;

public class Account {
    // Attributes
    private String holder;
    private double amount;

    // Constructors
    public Account(String holder) {
        this(holder, 0);
    }

    public Account(String holder, double amount) {
        this.holder = holder;

        if (amount < 0) {
            this.amount = 0;
        } else {
            this.amount = amount;
        }
    }

    // Methods
    public void deposit(double amount) {
        if (amount > 0) {
            this.amount += amount;
        }
    }

    public void withdraw(double amount) {
        double subtract = this.amount - amount;

        if (subtract < 0) {
            this.amount = 0;
            return;
        }

        this.amount = subtract;
    }

    // Getter and Setter for `holder`
    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    // Getter and Setter for `amount`
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // toString
    @Override
    public String toString() {
        return "Account [holder=" + holder + ", amount=" + amount + "]";
    }
}

// 1) Crea una clase llamada Cuenta que tendrá los siguientes atributos: titular
// y cantidad (puede tener decimales).

// El titular será obligatorio y la cantidad es opcional. Crea dos constructores
// que cumpla lo anterior.

// Crea sus métodos get, set y toString.

// Tendrá dos métodos especiales:

// ingresar(double cantidad): se ingresa una cantidad a la cuenta, si la
// cantidad introducida es negativa, no se hará nada.

// retirar(double cantidad): se retira una cantidad a la cuenta, si restando la
// cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta pasa
// a ser 0.
