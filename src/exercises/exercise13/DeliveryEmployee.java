package exercises.exercise13;

public class DeliveryEmployee extends Employee {

    private String zone;

    // Constructor
    public DeliveryEmployee(String name, int age, double salary, String zone) {
        super(name, age, salary);
        this.zone = zone;
    }

    // Getters and Setters
    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    // Method implementation
    @Override
    public void plus() {
        if (getAge() < 25 && zone.equals("zona 3")) {
            setSalary(getSalary() + PLUS);
        }
    }

    // toString
    @Override
    public String toString() {
        return "Delivery Employee { " +
                "name=\"" + getName() + '"' +
                ", age=" + getAge() +
                ", salary=" + getSalary() +
                ", zone=\"" + zone + "\" " +
                '}';
    }

}
