public class QuantityTest {

    public static void main(String[] args) {

        // Test 1: meter to cm
        runTest(new Quantity(1, "meter"), "cm");

        // Test 2: feet to inches
        runTest(new Quantity(2, "feet"), "inches");

        // Test 3: inches to feet
        runTest(new Quantity(24, "inches"), "feet");

        // Test 4: cm to meter
        runTest(new Quantity(100, "cm"), "meter");
    }

    static void runTest(Quantity q, String targetUnit) {

        Quantity result = q.convertTo(targetUnit);

        System.out.println("Converting: " + q);
        System.out.println("Result: " + result);
        System.out.println("----------------------------");
    }
}