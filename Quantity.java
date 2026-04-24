public class Quantity {

    private double value;
    private String unit;

    // Constructor
    public Quantity(double value, String unit) {
        this.value = value;
        this.unit = unit.toLowerCase();
    }

    // Convert everything to inches (base unit)
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

    // Equality check
    public boolean equals(Quantity other) {
        double diff = Math.abs(this.toInches() - other.toInches());
        return diff <= 0.5; // tolerance
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }

    // Demo main
    public static void main(String[] args) {

        Quantity q1 = new Quantity(1, "meter");
        Quantity q2 = new Quantity(100, "cm");

        if (q1.equals(q2)) {
            System.out.println("Quantities are equal");
        } else {
            System.out.println("Quantities are NOT equal");
        }
    }
}