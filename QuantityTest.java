public class QuantityTest {

    public static void main(String[] args) {

        // Test Case 1: 2 feet == 24 inches
        runTest(new Quantity(2, "feet"), new Quantity(24, "inches"));

        // Test Case 2: 1 foot == 12 inches
        runTest(new Quantity(1, "feet"), new Quantity(12, "inches"));

        // Test Case 3: Not equal
        runTest(new Quantity(2, "feet"), new Quantity(30, "inches"));

        // Test Case 4: Approx equal
        runTest(new Quantity(2, "feet"), new Quantity(24.3, "inches"));
    }

    static void runTest(Quantity q1, Quantity q2) {

        System.out.println("Comparing: " + q1 + " and " + q2);

        if (q1.equals(q2)) {
            System.out.println("Result: Equal");
        } else {
            System.out.println("Result: Not Equal");
        }

        System.out.println("---------------------------");
    }
}