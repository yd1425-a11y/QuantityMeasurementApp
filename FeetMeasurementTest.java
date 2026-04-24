public class FeetMeasurementTest {

    public static void main(String[] args) {

        // Test Case 1: Exact equality
        test(25.0, 25.0);

        // Test Case 2: Approx equal
        test(25.0, 25.3);

        // Test Case 3: Not equal
        test(25.0, 26.0);
    }

    static void test(double left, double right) {
        System.out.println("Testing: " + left + " & " + right);

        if (left == right) {
            System.out.println("Result: Exactly Equal\n");
        } 
        else if (Math.abs(left - right) <= 0.5) {
            System.out.println("Result: Approximately Equal\n");
        } 
        else {
            System.out.println("Result: Not Equal\n");
        }
    }
}