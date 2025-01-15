package exercises.exercise13;

public class EmployeeBuilder {

    private String fullName;
    private int age;
    private double salary;
    private double commission;
    private String zone;

    public EmployeeBuilder() {
    }

    public EmployeeBuilder setFullName(String firstName, String lastName) {
        if (firstName.equals(null) || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty or blank");
        }

        if (lastName.equals(null) || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty or blank");
        }

        this.fullName = firstName + " " + lastName;
        return this;
    }

    public EmployeeBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        this.age = age;
        return this;
    }

    public EmployeeBuilder setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }

        this.salary = salary;
        return this;
    }

    public EmployeeBuilder setCommission(double commission) {
        if (commission < 0) {
            throw new IllegalArgumentException("Commission cannot be negative");
        }

        this.commission = commission;
        return this;
    }

    public EmployeeBuilder setZone(String zone) {
        if (zone.equals(null) || zone.trim().isEmpty()) {
            throw new IllegalArgumentException("Zone cannot be empty or blank");
        }

        this.zone = zone;
        return this;
    }

    public DeliveryEmployee buildDeliveryEmployee() {
        return new DeliveryEmployee(fullName, age, salary, zone);
    }

    public CommercialEmployee buildCommercialEmployee() {
        return new CommercialEmployee(fullName, age, salary, commission);
    }

}
