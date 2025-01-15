package exercises.exercise13;

public class CommercialEmployee extends Employee {

    private double commission;

    // Constructor
    public CommercialEmployee(String name, int age, double salary, double commission) {
        super(name, age, salary);
        this.commission = commission;
    }

    // Getters and Setters
    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    // Method implementation
    @Override
    public void plus() {
        if (getAge() > 30 && commission > 200) {
            setSalary(getSalary() + PLUS);
        }
    }

    // toString
    @Override
    public String toString() {
        return "Commercial Employee { " +
                "name=\"" + getName() + '"' +
                ", age=" + getAge() +
                ", salary=" + getSalary() +
                ", commission=" + commission + ' ' +
                '}';
    }

}
