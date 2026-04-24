public class Quantity {

    private double value;
    private String unit;

    // Constructor
    public Quantity(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    // Convert everything to inches for comparison
    private double toInches() {
        switch (unit.toLowerCase()) {
            case "feet":
                return value * 12;
            case "inch":
            case "inches":
                return value;
            default:
                throw new IllegalArgumentException("Invalid unit");
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

    // Main method (optional demo)
    public static void main(String[] args) {

        Quantity q1 = new Quantity(2, "feet");
        Quantity q2 = new Quantity(24, "inches");

        if (q1.equals(q2)) {
            System.out.println("Quantities are equal");
        } else {
            System.out.println("Quantities are NOT equal");
        }
    }
}