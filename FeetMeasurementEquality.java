public class FeetMeasurementEquality {

    // Method to check equality
    public static String checkFeet(double leftFoot, double rightFoot) {

        if (leftFoot == rightFoot) {
            return "Exactly Equal";
        } 
        else if (Math.abs(leftFoot - rightFoot) <= 0.5) {
            return "Approximately Equal";
        } 
        else {
            return "Not Equal";
        }
    }

    // Main method for user input
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        double leftFoot, rightFoot;

        System.out.println("=== Feet Measurement Equality Check ===");

        System.out.print("Enter left foot measurement: ");
        leftFoot = sc.nextDouble();

        System.out.print("Enter right foot measurement: ");
        rightFoot = sc.nextDouble();

        String result = checkFeet(leftFoot, rightFoot);

        System.out.println("Result: " + result);

        sc.close();
    }
}