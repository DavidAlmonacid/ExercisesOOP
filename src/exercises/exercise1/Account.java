/**
 * Crea una clase llamada Cuenta que tendrá los siguientes atributos: titular
 * y cantidad (puede tener decimales).
 * 
 * El titular será obligatorio y la cantidad es opcional. Crea dos constructores
 * que cumpla lo anterior.
 * 
 * Crea sus métodos get, set y toString.
 * 
 * Tendrá dos métodos especiales:
 * 
 * ingresar(double cantidad): se ingresa una cantidad a la cuenta, si la
 * cantidad introducida es negativa, no se hará nada.
 * 
 * retirar(double cantidad): se retira una cantidad a la cuenta, si restando la
 * cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta pasa
 * a ser 0.
 */

package exercises.exercise1;

public class Account {
    // Attributes
    private String holder;
    private double amount;

    // Constructors
    public Account(String holder) {
        this(holder, 0);
    }

    public Account(String holder, double amount) {
        if (holder == null || holder.isBlank()) {
            throw new IllegalArgumentException("Holder name is required and can't be empty");
        }

        this.holder = holder;

        if (amount < 0) {
            this.amount = 0;
        } else {
            this.amount = amount;
        }
    }

    // Getter methods
    public String getHolder() {
        return holder;
    }

    public double getAmount() {
        return amount;
    }

    // Setter methods
    public void setHolder(String holder) {
        if (holder == null || holder.isBlank()) {
            throw new IllegalArgumentException("Holder name is required and can't be empty");
        }

        this.holder = holder;
    }

    public void setAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount can't be negative");
        }

        this.amount = amount;
    }

    // Methods

    /**
     * Deposits the specified amount into the account.
     * 
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        if (amount > 0) {
            this.amount += amount;
        }
    }

    /**
     * Withdraws the specified amount from the account.
     * If the amount to withdraw is greater than the current balance, sets the
     * balance to 0.
     * 
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
        if (amount > 0) {
            this.amount = Math.max(this.amount - amount, 0);
        }
    }

    // toString
    @Override
    public String toString() {
        return "Account [holder=" + holder + ", amount=" + amount + "]";
    }
}
