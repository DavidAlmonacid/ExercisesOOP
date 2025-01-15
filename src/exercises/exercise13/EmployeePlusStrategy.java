package exercises.exercise13;

public class EmployeePlusStrategy implements PlusStrategy {

    @Override
    public boolean isEligibleForPlus(Employee employee) {
        return switch (employee.getClass().getSimpleName()) {
            case "DeliveryEmployee" -> {
                DeliveryEmployee delivery = (DeliveryEmployee) employee;
                yield delivery.getAge() < 25 && delivery.getZone().equals("zona 3");
            }

            case "CommercialEmployee" -> {
                CommercialEmployee commercial = (CommercialEmployee) employee;
                yield commercial.getAge() > 30 && commercial.getCommission() > 200;
            }

            default -> false;
        };
    }

}
