public class Quantity {

    private double value;
    private String unit;

    // Constructor
    public Quantity(double value, String unit) {
        this.value = value;
        this.unit = unit.toLowerCase();
    }

    // Convert to inches (base unit)
    private double toInches() {
        switch (unit) {
            case "feet":
                return value * 12;

            case "inch":
            case "inches":
                return value;

            case "cm":
                return value / 2.54;

            case "meter":
            case "meters":
                return value * 39.37;

            default:
                throw new IllegalArgumentException("Invalid unit: " + unit);
        }
    }

    // Convert to target unit
    public Quantity convertTo(String targetUnit) {
        targetUnit = targetUnit.toLowerCase();

        double inches = this.toInches();
        double convertedValue;

        switch (targetUnit) {
            case "feet":
                convertedValue = inches / 12;
                break;

            case "inch":
            case "inches":
                convertedValue = inches;
                break;

            case "cm":
                convertedValue = inches * 2.54;
                break;

            case "meter":
            case "meters":
                convertedValue = inches / 39.37;
                break;

            default:
                throw new IllegalArgumentException("Invalid target unit: " + targetUnit);
        }

        return new Quantity(convertedValue, targetUnit);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }

    // Demo main
    public static void main(String[] args) {

        Quantity q = new Quantity(1, "meter");

        Quantity result = q.convertTo("feet");

        System.out.println(q + " = " + result);
    }
}