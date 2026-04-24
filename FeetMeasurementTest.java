public class FeetMeasurementTest {

    public static void main(String[] args) {

        // Test Case 1: Exact equality
        runTest(25.0, 25.0);

        // Test Case 2: Approximate equality
        runTest(25.0, 25.3);

        // Test Case 3: Not equal
        runTest(25.0, 26.0);
    }

    static void runTest(double left, double right) {

        String result = FeetMeasurementEquality.checkFeet(left, right);

        System.out.println("Testing values: " + left + " & " + right);
        System.out.println("Result: " + result);
        System.out.println("--------------------------");
    }
}