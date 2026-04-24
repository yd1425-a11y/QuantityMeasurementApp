public class QuantityTest {

    public static void main(String[] args) {

        // Test 1: feet vs inches
        runTest(new Quantity(2, "feet"), new Quantity(24, "inches"));

        // Test 2: meter vs cm
        runTest(new Quantity(1, "meter"), new Quantity(100, "cm"));

        // Test 3: mixed units
        runTest(new Quantity(1, "feet"), new Quantity(30.48, "cm"));

        // Test 4: not equal
        runTest(new Quantity(1, "meter"), new Quantity(120, "cm"));

        // Test 5: approx equal
        runTest(new Quantity(1, "meter"), new Quantity(99.6, "cm"));
    }

    static void runTest(Quantity q1, Quantity q2) {

        System.out.println("Comparing: " + q1 + " and " + q2);

        if (q1.equals(q2)) {
            System.out.println("Result: Equal");
        } else {
            System.out.println("Result: Not Equal");
        }

        System.out.println("----------------------------");
    }
}