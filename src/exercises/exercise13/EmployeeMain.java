package exercises.exercise13;

import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {
        System.out.println("\nExercise 13:\n");

        List<Employee> employees = List.of(
                new EmployeeBuilder()
                        .setFullName("Juanito", "Alimaña")
                        .setAge(29)
                        .setSalary(5_000)
                        .setCommission(300)
                        .buildCommercialEmployee(),
                new EmployeeBuilder()
                        .setFullName("Wade", "Wilson")
                        .setAge(31)
                        .setSalary(7_000)
                        .setCommission(0)
                        .buildCommercialEmployee(),
                new EmployeeBuilder()
                        .setFullName("Ryan", "Reynolds")
                        .setAge(35)
                        .setSalary(8_000)
                        .setCommission(500)
                        .buildCommercialEmployee(),
                new EmployeeBuilder()
                        .setFullName("Pepito", "Grillo")
                        .setAge(24)
                        .setSalary(1_500)
                        .setZone("zona 1")
                        .buildDeliveryEmployee(),
                new EmployeeBuilder()
                        .setFullName("Peter", "Parker")
                        .setAge(26)
                        .setSalary(1_800)
                        .setZone("zona 3")
                        .buildDeliveryEmployee(),
                new EmployeeBuilder()
                        .setFullName("Miles", "Morales")
                        .setAge(23)
                        .setSalary(1_700)
                        .setZone("zona 3")
                        .buildDeliveryEmployee());

        for (Employee employee : employees) {
            PlusStrategy plusStrategy = new EmployeePlusStrategy();

            if (plusStrategy.isEligibleForPlus(employee)) {
                employee.plus();
            }

            System.out.println(employee);
        }
    }
}
