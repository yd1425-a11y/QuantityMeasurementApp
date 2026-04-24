import java.util.Scanner;

public class FeetMeasurementEquality {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double leftFoot, rightFoot;

        System.out.println("=== Feet Measurement Equality Check ===");

        System.out.print("Enter left foot measurement: ");
        leftFoot = sc.nextDouble();

        System.out.print("Enter right foot measurement: ");
        rightFoot = sc.nextDouble();

        // Exact equality
        if (leftFoot == rightFoot) {
            System.out.println("Feet measurements are exactly equal.");
        }
        // Approximate equality (recommended)
        else if (Math.abs(leftFoot - rightFoot) <= 0.5) {
            System.out.println("Feet measurements are approximately equal.");
        }
        else {
            System.out.println("Feet measurements are NOT equal.");
        }

        sc.close();
    }
}